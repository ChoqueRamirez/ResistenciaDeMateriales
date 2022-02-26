package com.willi.resistencia.secciones;

import java.util.Objects;

public class Rectangular extends VigaConAlturaYAncho {

    public Rectangular(float altura, float ancho, float largo, int E, int G){
        super(altura, ancho, largo, E, G);
        System.out.println("Viga Rectangular - Asumimos Linealidades: estatica, cinematica y mecánica");
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
    public float solicitacionAxil(float fuerza, final String unidad, final String direccion){
        return fuerza / getArea();
    }

    @Override
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        if(altura/ancho == 1){
            return (float) (fuerza / (0.208*altura*Math.pow(ancho, 2)));
        } else if (altura/ancho == 2 ){
            return (float) (fuerza/ (0.246*altura*Math.pow(ancho, 2)));
        }else if (altura/ancho == 3){
            return (float) (fuerza/ (0.267*altura*Math.pow(ancho, 2)));
        }
        else{
            return 0;
        }
    }

    @Override
    public float solicitacionAFlexion(float fuerza, final String unidad, final String direccion) {
        if (Objects.equals(direccion, "y")){
            return (fuerza * altura/2) / momentoDeInerciaY();
        } else if (Objects.equals(direccion, "z")){
            return (fuerza * ancho/2) / momentoDeInerciaZ();
        } else{
            return 0;
        }
    }

    public float solicitacionPorCorte(float fuerza, String unidad, final String direccion){
        return (fuerza * (ancho*altura)*altura/4)/momentoDeInerciaY()*ancho;
    }

    @Override
    public float deformacionEspecifica(Viga viga, float fuerza, String unidad, String direccion){
        return viga.solicitacionAFlexion(fuerza, unidad, direccion) / E;
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
}




