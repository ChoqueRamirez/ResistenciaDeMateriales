package secciones;

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


    public abstract float area();

    public abstract void baricentro();

    public abstract void momentosDeInercia();

    public abstract float rigidezAxial();

    public abstract float condicionRigidezFlexional();

    public abstract float condicionRigidezTorsional();

    public float getLargo() {
        return largo;
    }

    public float getAltura() {
        return altura;
    }

    public float getAncho() {
        return ancho;
    }

    public float getRadio() {
        return radio;
    }
}

