package solicitaciones;

import secciones.VigaRectangular;
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
        float tensionNormalAxil;
        return tensionNormalAxil = fuerza/vigaASolicitar.area();
    }

    public float solicitacionAFlexion(Vigas vigaAsolicitar){
        float tensionFlexion;
        return tensionFlexion = (fuerza* vigaAsolicitar.getAltura()/2)/vigaAsolicitar.getJy();
    }





}
