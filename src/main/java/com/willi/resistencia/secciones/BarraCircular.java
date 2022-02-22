package com.willi.resistencia.secciones;

public class BarraCircular extends Viga {

    private final float radio;

    public BarraCircular(float radio, float largo, int E, int G){
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
        return (radio * radio * radio * radio) / 12;
    }

    @Override
    public float momentoDeInerciaZ(){
        return (radio * radio * radio * radio)/12;
    }

    public float momentosPolarDeInercia(){
        return (float) ((Math.PI * radio * radio * radio * radio)/4);
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
        return  (fuerza * radio) / momentoDeInerciaY();
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
