package secciones;

public abstract class Vigas {
    protected float largo;
    protected int E;
    protected int G;

    public Vigas(float largo, int e, int g) {
        this.largo = largo;
        E = e;
        G = g;
    }

    public abstract float getLargo();

    public float solicitacionAxil(float fuerza, final String unidad, final String direccion){
        return fuerza / getArea();
    }

    public abstract float solicitacionAFlexion(float fuerza, final String unidad, final String direccion);

    public abstract void baricentro();

    public abstract float coordBaricentricaEnX();

    public abstract float coordBaricentricaEnY();

    public abstract float momentoDeInerciaY();

    public abstract float momentoDeInerciaZ();

    public abstract float getArea();

    public abstract float solicitacionTorsional(float fuerza, String unidad, String dirrecion);
}
