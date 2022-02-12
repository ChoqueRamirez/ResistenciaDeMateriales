package solicitaciones;

import secciones.Vigas;

public class Solitaciones {
    protected float fuerza;
    protected String unidad;
    protected String dirrecion;


    public Solitaciones(float fuerza, String unidad, String dirrecion){
        this.fuerza = fuerza;
        this.unidad = unidad;
        this.dirrecion = dirrecion;

    }

    public float solicitacionAxil(Vigas vigaASolicitar){
        return fuerza/vigaASolicitar.getArea();
    }

    public float solicitacionAFlexion(Vigas vigaAsolicitar){
        return  (fuerza* vigaAsolicitar.getAltura()/2)/vigaAsolicitar.momentoDeInerciaY();
    }





}
