package solicitaciones;

import secciones.BarraCircular;
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

    public float solicitacionTorsional(BarraCircular vigaAsolicitar) {
        if (vigaAsolicitar.getRadio() != 0) {
            return (fuerza * vigaAsolicitar.getRadio()) / vigaAsolicitar.momentosPolarDeInercia();
        } else if (vigaAsolicitar.getRadio() == 0) {
            return fuerza/(2*vigaAsolicitar.constanteDeTorsion*vigaAsolicitar.getEspesor);
        }else{
            return 0;
        }
    }
}
