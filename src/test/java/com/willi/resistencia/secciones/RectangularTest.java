package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

public class RectangularTest {

    @Test
    public void area_de_la_viga_de_10_x_10_deberia_devolver_100() {
        Rectangular vigaRectangular = new Rectangular(10f, 10f, 400f, 2000, 1500);
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

    @Test(expected = VigaNoEsbeltaException.class)
    public void viga_con_poca_longitud_deberia_tirar_un_error(){
        Rectangular vr = new Rectangular(20, 10 , 50, 2000, 1500);
    }

    @Test(expected = ModulosIndefinidosException.class)
    public void modulos_negativos_deberian_tirar_un_error(){
        Rectangular vR = new Rectangular(10, 10, 500, -1000, -2000);
    }

    @Test(expected = ModulosIndefinidosException.class)
    public void modulos_nulos_deberian_tirar_un_error(){
        Rectangular vR = new Rectangular(10, 10, 500, 0, -0);
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

    @Test
    public void s_Axil_con_carga_negativa_1000_deberia_devolver_una_tension_negativa_5(){
        Rectangular vr = new Rectangular(20, 10, 500, 2500, 1500);
        float realSA = vr.solicitacionAxil(-1000, "kN", "x");
        float expectedSA = -5;
        Assert.assertEquals(expectedSA, realSA,0.1);
    }

    @Test
    public void s_Torsion_con_carga_10000_deberia_devolver_una_tension_de_203_25(){
        Rectangular vr = new Rectangular(20, 10, 500, 2500, 1500);
        float realST = vr.solicitacionTorsional(10000, "kNcm", "x");
        float expectedST = 20.325f;
        Assert.assertEquals(expectedST, realST, 0.1);
    }

    @Test
    public void s_Flexion_con_carga_500_deberia_devolver_una_tension_de_93_75(){
        Rectangular vr = new Rectangular(20,10, 500, 2500, 1500);
        float realSF = vr.solicitacionAFlexion(500, "kN", "z");
        float expectedSF = 93.75f;
        Assert.assertEquals(expectedSF, realSF, 0.1);
    }

    @Test
    public void s_Corte_con_carga_70_negativo_deberia_devolver_una_tension_de_0_14_negativo(){
        Rectangular vr = new Rectangular(25, 15, 500, 20000, 13000);
        float realSFV = vr.solicitacionPorCorte(-70, "kN", "z");
        float expectedSFV = -0.14f;
        Assert.assertEquals(expectedSFV, realSFV, 0.1);
    }

    @Test
    public void deformacion_Especifica_Long_debido_a_una_cargaAxil_de_150_y_carga_200_en_dirZ_deberia_dar_0_0182(){
        Rectangular vr = new Rectangular(20, 10, 500, 2100, 1300);
        vr.solicitacionAxil(150,"kN", "x");
        vr.solicitacionAFlexion(200, "kN", "z");
        float realDefEspLong = vr.deformacionEspLong();
        float expectedDefEspLong = 0.0182f;
        Assert.assertEquals(expectedDefEspLong, realDefEspLong, 0.1);
    }

    @Test
    public void deformacion_Especifica_Tang_debido_a_un_Mx_de_30_y_una_carga_200_en_dirZ_deberia_dar(){
        Rectangular vr = new Rectangular(20, 10, 500, 2100, 1300);
        vr.solicitacionTorsional(30, "kNcm", "x");
        vr.solicitacionPorCorte(200, "kN", "z");
        float realDefEspTang = vr.deformacionEspTang();
        float expectedDefEspTang = 0.0006238f;
        Assert.assertEquals(expectedDefEspTang, realDefEspTang, 0.1);
    }

}