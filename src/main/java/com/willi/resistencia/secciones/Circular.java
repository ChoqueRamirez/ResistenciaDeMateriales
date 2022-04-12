package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.VigaConLargoIndefinidoException;
import com.willi.resistencia.exceptions.VigaConRadioIndefinidoException;

import java.util.Objects;

public class Circular extends Viga {

    private final float radio;

    public Circular(float radio, float largo, int E, int G) {
        super(largo, E, G);
        if(radio <= 0){
            throw new VigaConRadioIndefinidoException("La viga debe tener un radio positivo");
        }
        this.radio = radio;
        System.out.println("Barra Circular - Asumimos Linealidades: estatica, cinematica y mecánica");
    }


    @Override
    public void baricentro() {
        System.out.println("Baricentro: al tener simetria polar, este se encuentra en el centro de la seccion");
    }

    @Override
    public float coordBaricentricaEnX() {
        return getRadio();
    }

    @Override
    public float coordBaricentricaEnY() {
        return getRadio();
    }

    @Override
    public float momentoDeInerciaY() {
        return (float) ((Math.PI * Math.pow(radio, 4)) / 4);
    }

    @Override
    public float momentoDeInerciaZ() {
        return (float) ((Math.PI * Math.pow(radio, 4)) / 4);
    }

    public float momentosPolarDeInercia() {
        return (float) ((Math.PI * Math.pow(radio, 4)) / 2);
    }

    @Override
    public float solicitacionAxil(float carga, final String unidad, final String direccion) {
        return (carga / getArea());
    }

    @Override
    public float solicitacionTorsional(float carga, String unidad, String dirrecion) {
        return (carga * radio) / momentosPolarDeInercia();
    }

    @Override
    public float solicitacionAFlexion(float carga, final String unidad, final String direccion) {
        if (Objects.equals(direccion, "y")) {
            return ((carga * getLargo() / 4) * radio) / momentoDeInerciaY();
        } else if (Objects.equals(direccion, "z")) {
            return ((carga * getLargo() / 4) * radio) / momentoDeInerciaZ();
        } else {
            return 0;
        }
    }

    @Override
    public float solicitacionPorCorte(float carga, String unidad, final String direccion) {
        return (float) (carga / 2 * (getArea() / 2) * (4 * radio) / (3 * Math.PI)) / (momentoDeInerciaY() * radio * 2);
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * radio * radio);
    }

    @Override
    public float getLargo() {
        return largo;
    }

    public float getRadio() {
        return radio;
    }

}
