package com.willi.resistencia;

import com.willi.resistencia.complementos.Apoyos;
import com.willi.resistencia.secciones.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Rectangular v1 = new Rectangular(-20, 10, 500, 210, 80);

        v1.baricentro();

        Apoyos vf = new Apoyos(2, "Fijo", 0, 0);
        Apoyos vm = new Apoyos(1, "Móvil", v1.getLargo(), 0);

        System.out.println("Esfuezo normal en Viga1 :" + v1.solicitacionAxil(100, "N", "z") + " N");
        System.out.println("area :" + v1.getArea());
        System.out.println("Esfuerzo a Flexion Recta en direccion Y: " + v1.solicitacionAFlexion(50, "Nm", "y") + " kNm");
    }
}