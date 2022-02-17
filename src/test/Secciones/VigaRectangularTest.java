package Secciones;

import org.junit.Assert;
import org.junit.Test;
import secciones.VigaRectangular;

public class VigaRectangularTest {

    @Test
    public void area_de_la_viga_de_10_x_10_deberia_devolver_100() {
        VigaRectangular vigaRectangular = new VigaRectangular(10f, 10f, 40f, 0, 0);
        float realArea = vigaRectangular.getArea();
        float expectedArea = 100f;
        Assert.assertEquals(expectedArea, realArea, 0.1);
    }

    // me gustaría que hagas el test para que cuando creo una viga de dimensiones negativas
    // no me deje crearla, es decir, lance una excepción
    // Para testear que un método lance una excepción, tenes que hacer algo como
    // @Test(expected = ExceptionQueVasALanzar.class)
    // public void tu_test(){
    //  ... tu codigo ...
    // }
}