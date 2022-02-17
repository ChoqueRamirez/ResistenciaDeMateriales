package com.willi.resistencia.secciones;

public abstract class VigaConAlturaYAncho extends Viga {
    protected float altura;
    protected float ancho;

    public VigaConAlturaYAncho(float altura, float ancho, float largo, int E, int G) {
        super(largo, E, G);
        this.altura = altura;
        this.ancho = ancho;
    }

    public abstract float getAltura();

    public abstract float getAncho();

}

