package solicitaciones;

import secciones.BarraCircular;
import secciones.TuboRectangular;
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

    public float solicitacionTorsional(TuboRectangular vigaASolicitar) {
        if (vigaASolicitar.getRadio() != 0) {
            return (fuerza * vigaASolicitar.getRadio()) / vigaASolicitar.momentosPolarDeInercia();
        } else if (vigaASolicitar.getRadio() == 0) {
            return fuerza/(2 * vigaASolicitar.constanteDeTorsion() * vigaASolicitar.getEspesor1());
        } else if(vigaASolicitar.getRadio() ==0 && vigaASolicitar.getEspesor1() !=0 && vigaASolicitar.getEspesor2() != 0){
            return fuerza/(2 * vigaASolicitar.constanteDeTorsion() * vigaASolicitar.getEspesor1());
        } else{
            return 0;
        }
    }
}
