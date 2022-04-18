package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.ModulosIndefinidosException;

import java.util.Objects;

public class Rectangular extends VigaConAlturaYAncho {


    public Rectangular(float altura, float ancho, float largo, int E, int G){
        super(altura, ancho, largo, E, G);
    }

    @Override
    public void baricentro(){
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
    public float momentoDeInerciaY(){
        return (float) ((ancho * Math.pow(altura, 3))/12);
    }

    @Override
    public float momentoDeInerciaZ(){
        return (float) ((altura * Math.pow(ancho, 3))/12);
    }

    @Override
    public float solicitacionAxil(float carga, final String unidad, final String direccion){
        return tensionNormalSA = carga / getArea();
    }

    @Override
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        if(altura/ancho == 1){
            return  tensionTangencialST = (float) (fuerza / (0.208*altura*Math.pow(ancho, 2)));
        } else if (altura/ancho == 2 ){
            return tensionTangencialST = (float) (fuerza/ (0.246*altura*Math.pow(ancho, 2)));
        }else if (altura/ancho == 3){
            return tensionTangencialST = (float) (fuerza/ (0.267*altura*Math.pow(ancho, 2)));
        }
        else{
            return tensionTangencialST = 0;
        }
    }

    @Override
    public float solicitacionAFlexion(float carga, final String unidad, final String direccion) {
        if (Objects.equals(direccion, "y")){
            return tensionNormalSF = ((carga * getLargo() / 4) * altura/2) / momentoDeInerciaY();
        } else if (Objects.equals(direccion, "z")){
            return tensionNormalSF = ((carga * getLargo() / 4) * ancho/2) / momentoDeInerciaZ();
        } else{
            return tensionNormalSF = 0;
        }
    }

    @Override
    public float solicitacionPorCorte(float carga, String unidad, final String direccion){
        return tensionTangencialFV = (carga/2 * (ancho*altura)*altura/4)/momentoDeInerciaY()*ancho;
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
    public float getArea(){
        return ancho * altura;
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




