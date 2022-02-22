package com.willi.resistencia.secciones;

public class VigaRectangular extends VigaConAlturaYAncho {

    public VigaRectangular(float altura, float ancho, float largo, int E, int G){
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
        return (altura * ancho * ancho * ancho)/12;
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
    public float solicitacionAxil(float fuerza, final String unidad, final String direccion){
        return fuerza / getArea();
    }

    @Override
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        return 0;
    }

    @Override
    public float solicitacionAFlexion(float fuerza, final String unidad, final String direccion) {
        return  (fuerza * altura / 2 ) / momentoDeInerciaY();
    }
}




