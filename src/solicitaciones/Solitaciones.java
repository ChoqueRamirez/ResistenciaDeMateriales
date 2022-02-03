package solicitaciones;

public abstract class Solitaciones {
    protected float fuerza;
    protected String dirrecion;

    public Solitaciones(float fuerza, String dirrecion){
        this.fuerza = fuerza;
        this.dirrecion = dirrecion;
    }

    public abstract float solicitacionAxil();

    public abstract float solicitacionAFlexion();

    public abstract float solicitacionATorsion();

    public abstract float solicitacionPorCorte();


}
