package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.*;
import javafx.scene.control.cell.TextFieldListCell;
import org.junit.Assert;
import org.junit.Test;

public class RectangularTest {

    @Test
    public void area_de_la_viga_de_10_x_10_deberia_devolver_100() {
        Rectangular vigaRectangular = new Rectangular(10f, 10f, 40f, 2000, 1500);
        float realArea = vigaRectangular.getArea();
        float expectedArea = 100f;
        Assert.assertEquals(expectedArea, realArea, 0.1);
    }

    @Test(expected = SeccionIndefinidaException.class)
    public void seccion_con_valores_negativos_deberia_tirar_un_error(){
        Rectangular vr = new Rectangular(-20, -10, 500, 2500, 1000);
    }

    @Test(expected = VigaConLargoIndefinidoException.class)
    public void largo_de_viga_negativo_deberia_tirar_un_error() {
        Rectangular vigaRectangular = new Rectangular(10f, 10f, -5f, 0, 0);
    }

    @Test(expected = ModulosIndefinidosException.class)
    public void modulos_negativos_o_nulos_deberian_tirar_un_error(){
        Rectangular vR = new Rectangular(10, 10, 500, 0, -2000);
    }

    @Test
    public void jy_de_la_seccion_de_20_x_10_deberia_devolver_6666_67(){
        Rectangular vR = new Rectangular(20, 10, 500, 2000, 1500);
        float realJy = vR.momentoDeInerciaY();
        float expectedJy = 6666.67f;
        Assert.assertEquals(expectedJy, realJy, 0.1);
    }

    @Test
    public void jz_de_la_seccion_de_20_x_10_deberia_devolver_1666_67(){
        Rectangular vr = new Rectangular(20 ,10 , 500, 2500, 1500);
        float realJz = vr.momentoDeInerciaZ();
        float expectedJz = 1666.67f;
        Assert.assertEquals(expectedJz, realJz, 0.1);
    }




}