package com.willi.resistencia;

import com.willi.resistencia.complementos.Apoyos;
import com.willi.resistencia.secciones.Circular;
import com.willi.resistencia.secciones.Viga;
import com.willi.resistencia.secciones.Rectangular;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Rectangular v1 = new Rectangular(20, 10, 500, 210, 80);
        v1.baricentro();

        Apoyos vf = new Apoyos(2, "Fijo", 0);
        Apoyos vm = new Apoyos(1, "Móvil", v1.getLargo());

        System.out.println("Esfuezo normal en Viga1 :" + v1.solicitacionAxil(100, "N", "z") + " N/cm2");

        System.out.println("Esfuerzo a Flexion Recta en direccion Y: " + v1.solicitacionAFlexion(50, "Nm", "y"));

        Viga viga = new Rectangular(20, 10, 500, 210, 80);








    }
}