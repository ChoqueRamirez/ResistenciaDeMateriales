package Secciones;

import com.sun.javafx.collections.FloatArraySyncer;

public abstract class Vigas {
    protected float altura;
    protected float ancho;
    protected float largo;
    protected float radio;
    protected int E;
    protected int G;
    protected float Jy;
    protected float Jz;
    protected float Jp;
    protected float area;



    public Vigas(float altura, float ancho, float largo, int E, int G) {
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
        this.E = E;
        this.G = G;
    }

    public Vigas(float radio, float largo , int E, int G) {
        this.radio = radio;
        this.largo = largo;
        this.E = E;
        this.G = G;
    }


    public abstract void area();

    public abstract void Baricentro();

    public abstract void MomentosDeInercia();

    public abstract void MomentosPolarDeInercia();

    public abstract void RigidezAxial();

    public abstract void CondicionRigidezFlexional();

    public abstract void CondicionRigidezTorsional();

}

