package secciones;

public abstract class Vigas {
    protected float altura;
    protected float ancho;
    protected float largo;
    protected float radio;
    protected int E;
    protected int G;

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


    public abstract void baricentro();

    public abstract float coordBaricentricaEnX();

    public abstract float coordBaricentricaEnY();

    public abstract float momentoDeInerciaY();

    public abstract float momentoDeInerciaZ();

    public abstract float momentosPolarDeInercia();

    public abstract float getArea();

    public abstract float getLargo();

    public abstract float getAltura();

    public abstract float getAncho();

    public abstract float getRadio();




}

