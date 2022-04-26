package com.willi.resistencia.secciones;

import java.util.Objects;

public class IPNDobleT extends VigaConAlturaYAncho {

    private final String designacion;
    private final float ty;
    private final float tw;
    private final float area;
    private final float Jy;
    private final float Jz;
    private final float momentoEstaticoQ;
    private final float moduloDeTorsionJ;

    public IPNDobleT(float altura, float ancho, float ty, float tw, float area,
                     float largo, float Jy, float Jz, float momentoEstaticoQ, int E, int G, String designacion, float moduloDeTorsionJ) {
        super(altura, ancho, largo, E, G);
        this.ty = ty;
        this.tw = tw;
        this.area = area;
        this.designacion = designacion;
        this.Jy = Jy;
        this.Jz = Jz;
        this.momentoEstaticoQ = momentoEstaticoQ;
        this.moduloDeTorsionJ = moduloDeTorsionJ;
        System.out.println("Perfil Doble T - IPN. Se encuentra tabulado");
    }


    @Override
    public void baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
        System.out.println("Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " +coordBaricentricaEnX() + "cm; Y= " + coordBaricentricaEnY() + "cm");
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
    public float momentoDeInerciaY(){
        return Jy;
    }

    @Override
    public float momentoDeInerciaZ(){
        return Jz;
    }

    @Override
    public float solicitacionAxil(float carga, final String unidad, final String direccion){
        return tensionNormalSA = carga / getArea();
    }

    @Override
    public float solicitacionAFlexion(float carga, final String unidad, final String direccion) {
        if (Objects.equals(direccion, "z")){
            return tensionNormalSF =  ((carga * getLargo() / 4) * altura/2) / momentoDeInerciaY();
        } else if (Objects.equals(direccion, "y")){
            return tensionNormalSF =  ((carga * getLargo() / 4) * ancho/2) / momentoDeInerciaZ();
        } else{
            return tensionNormalSF =  0;
        }
    }

    @Override
    public float solicitacionTorsional(float carga, String unidad, String dirrecion) {
        return tensionTangencialST = (carga * tw ) / moduloDeTorsionJ;
    }

    @Override
    public float solicitacionPorCorte(float carga, String unidad, final String direccion){
        return tensionTangencialFV = (carga/2 * momentoEstaticoQ) / momentoDeInerciaY() * tw;
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
        return area;
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
