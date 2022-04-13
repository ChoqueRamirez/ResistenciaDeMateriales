package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.VigaConRadioIndefinidoException;
import org.junit.Test;

public class CircularTest {

    @Test(expected = VigaConRadioIndefinidoException.class)
    public void radio_de_la_seccion_circular_negativo_deberia_tirar_error(){
        Circular vigaCircular = new Circular(-5, 500, 2000, 1500);
    }
}
