package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.SeccionIndefinidaException;
import com.willi.resistencia.exceptions.VigaNoEsbeltaException;

public abstract class VigaConAlturaYAncho extends Viga {
    protected float altura;
    protected float ancho;


    public VigaConAlturaYAncho(float altura, float ancho, float largo, int E, int G) {
        super(largo, E, G);
        if(altura <= 0 || ancho <= 0){
            throw new SeccionIndefinidaException("La seccion deberia tener alto y ancho");
        }else if(largo/altura < 10){
            throw new VigaNoEsbeltaException("Una de las dimensiones de la viga debe ser mas grande que las otras dos");
        }else {
            this.altura = altura;
            this.ancho = ancho;
        }
    }

    public abstract float getAltura();

    public abstract float getAncho();

}

