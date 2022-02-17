package secciones;

public abstract class Vigas {
    protected float altura;
    protected float ancho;
    protected float largo;
    protected int E;
    protected int G;

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

    public abstract float getLargo();

    public abstract float getAltura();

    public abstract float getAncho();

    public abstract float solicitacionTorsional(float fuerza, String unidad, String dirrecion);

}

