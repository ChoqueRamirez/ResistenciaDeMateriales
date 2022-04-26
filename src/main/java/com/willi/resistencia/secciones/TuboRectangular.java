package com.willi.resistencia.secciones;

import java.util.Objects;

public class TuboRectangular extends VigaConAlturaYAncho {

    private final float espesorAncho;
    private final float espesorAltura;

    public TuboRectangular(float ancho, float espesorAncho, float altura, float espesorAltura, float largo, int E, int G) {
        super(altura, ancho, largo, E, G);
        this.espesorAncho = espesorAncho;
        this.espesorAltura = espesorAltura;
    }

    @Override
    public void baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion"
                + "\n" + "Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " +
                coordBaricentricaEnX() + "cm; Y= " + coordBaricentricaEnY() + "cm");
    }

    @Override
    public float coordBaricentricaEnX(){
        return getAncho()/2;
    }

    @Override
    public float coordBaricentricaEnY(){
        return getAltura()/2;
    }

    @Override
    public float momentoDeInerciaY() {
        return (float) ( ((ancho*Math.pow(altura, 3))/12) - ( (ancho-2*espesorAncho)*(Math.pow((altura-2*espesorAltura), 3))/12) );
    }

    @Override
    public float momentoDeInerciaZ() {
        return (float) (((altura*Math.pow(ancho, 3))/12) - ( (altura-2*espesorAltura)*(Math.pow((ancho-2*espesorAncho), 3))/12));
    }

    public float constanteDeTorsion(){
        return (ancho-espesorAncho)*(altura-espesorAltura);
    }

    @Override
    public float solicitacionAxil(float carga, final String unidad, final String direccion){
        return tensionNormalSA = carga / getArea();
    }

    @Override
    public float solicitacionTorsional(float carga, String unidad, String dirrecion) {

        return tensionTangencialST = carga/(2 * constanteDeTorsion() * espesorAncho);
    }

    @Override
    public float solicitacionAFlexion(float carga, final String unidad, final String direccionLocal) {
        if (Objects.equals(direccionLocal, "z")){
            return tensionNormalSF = (carga * getLargo()/4) * (altura/2) / momentoDeInerciaY();
        } else if (Objects.equals(direccionLocal, "y")){
            return tensionNormalSF = ((carga * getLargo() / 4) * ancho/2) / momentoDeInerciaZ();
        } else{
            return tensionNormalSF = 0;
        }

    }

    @Override
    public float solicitacionPorCorte(float carga, String unidad, final String direccion){
        return tensionTangencialFV = (carga/2 * ( 2*(espesorAncho *((altura/2)- espesorAncho)) + ((ancho-2* espesorAncho)* espesorAncho) ) /momentoDeInerciaY()*(2* espesorAncho));
    }

    @Override
    public float deformacionEspLong(){
        return (getTensionNormalSA() + getTensionNormalSF())/E;
    }

    @Override
    public float deformacionEspTang(){
        return (getTensionTangencialFV() + getTensionTangencialST())/G;
    }

    @Override
    public float getArea() {
        return (ancho * altura) - ((ancho-espesorAncho)*(altura-espesorAltura));
    }

    @Override
    public float getLargo() {
        return largo;
    }

    @Override
    public float getAltura() {
        return altura;
    }

    @Override
    public float getAncho() {
        return ancho;
    }

    public float getEspesorAncho() {
        return espesorAncho;
    }

    public float getEspesorAltura() {
        return espesorAltura;
    }

    @Override
    public float getTensionNormalSA() {
        return tensionNormalSA;
    }

    @Override
    public float getTensionNormalSF() {
        return tensionNormalSF;
    }

    @Override
    public float getTensionTangencialST() {
        return tensionTangencialST;
    }

    @Override
    public float getTensionTangencialFV() {
        return tensionTangencialFV;
    }

}
