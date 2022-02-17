package secciones;

public abstract class VigasConAlturaYAncho extends Vigas{
    protected float altura;
    protected float ancho;

    public VigasConAlturaYAncho(float altura, float ancho, float largo, int E, int G) {
        super(largo, E, G);
        this.altura = altura;
        this.ancho = ancho;
    }

    public abstract float getAltura();

    public abstract float getAncho();

}

