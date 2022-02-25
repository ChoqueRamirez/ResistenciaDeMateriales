package com.willi.resistencia.secciones;

import java.util.Objects;

public class Circular extends Viga {

    private final float radio;

    public Circular(float radio, float largo, int E, int G){
        super(largo, E, G);
        this.radio = radio;
        System.out.println("Barra Circular - Asumimos Linealidades: estatica, cinematica y mecánica");
    }


    @Override
    public void baricentro(){
        System.out.println("Baricentro: al tener simetria polar, este se encuentra en el centro de la seccion");
    }

    @Override
    public float coordBaricentricaEnX(){
        return getRadio();
    }

    @Override
    public float coordBaricentricaEnY(){
        return getRadio();
    }

    @Override
    public float momentoDeInerciaY(){
        return (float) ((Math.PI * Math.pow(radio, 4)) / 4);
    }

    @Override
    public float momentoDeInerciaZ(){
        return (float) ((Math.PI * Math.pow(radio, 4)) / 4);
    }

    public float momentosPolarDeInercia(){
        return (float) ((Math.PI * Math.pow(radio, 4))/2);
    }

    @Override
    public float solicitacionAxil(float fuerza, final String unidad, final String direccion){
        return fuerza / getArea();
    }

    @Override
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        return (fuerza * radio) / momentosPolarDeInercia();
    }

    @Override
    public float solicitacionAFlexion(float fuerza, final String unidad, final String direccion) {
        if (Objects.equals(direccion, "y")){
            return (fuerza * radio) / momentoDeInerciaY();
        } else if (Objects.equals(direccion, "z")){
            return (fuerza * radio) / momentoDeInerciaZ();
        } else{
            return 0;
        }
    }

    public float solicitacionPorCorte(float fuerza, String unidad, final String direccion){
        return (float) (fuerza * (getArea()/2)*(4*radio)/(3*Math.PI))/(momentoDeInerciaY()*radio*2);
    }

    @Override
    public float getArea(){
        return (float) (Math.PI * radio * radio);
    }

    @Override
    public float getLargo() {
        return largo;
    }

    public float getRadio(){
        return radio;
    }

}
