package Secciones;

import com.sun.javafx.collections.FloatArraySyncer;

public abstract class Vigas {
    public float altura;
    public float ancho;
    public float largo;
    public float radio;
    public int E;
    public int G;
    public float Jy;
    public float Jz;


    public Vigas(float altura, float ancho, float largo, int E, int G, float radio) {
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
        this.radio = radio;
        this.E = E;
        this.G = G;
    }

    public Vigas(float radio, float largo , int E, int G) {
        this.altura = radio;
        this.largo = largo;
        this.E = E;
        this.G = G;
    }


    public abstract Baricentro;

    public abstract void MomentosDeInercia();

    public abstract void MomentosPolarDeInercia();

    public abstract void RigidezAxial();

    public abstract void CondicionRigidezFlexional();

    public abstract void CondicionRigidezTorsional();

}

