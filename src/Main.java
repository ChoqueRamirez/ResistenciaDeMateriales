import complementos.Apoyos;
import secciones.*;
import solicitaciones.Solitaciones;


public class Main {
    public static void main(String[] args) {
        VigaRectangular v1 = new VigaRectangular(20, 10, 500, 210, 80);
        v1.baricentro();
        v1.momentosDeInercia();
        v1.rigidezAxial();
        v1.condicionRigidezFlexional();
        v1.condicionRigidezTorsional();

        Apoyos vf = new Apoyos(2, "Fijo", 0);
        Apoyos vm = new Apoyos(1 , "Móvil", v1.getLargo());

        Solitaciones esfuerzoNormal = new Solitaciones(100,"N", "z");
        Solitaciones momentoY = new Solitaciones(50, "Nm", "y");

        System.out.println("Esfuezo normal en Viga1 :" + esfuerzoNormal.solicitacionAxil(v1) + " N/cm2");

        System.out.println("Esfuerzo a Flexion Recta en direccion Y: " + momentoY.solicitacionAFlexion(v1));



//        System.out.println("");
//
//        BarraCircular v2 = new BarraCircular(5, 500, 210, 80);
//
//        v2.baricentro();
//        v2.momentosPolarDeInercia();
//        v2.rigidezAxial();
//        v2.condicionRigidezFlexional();
//        v2.condicionRigidezTorsional();
//
//        System.out.println("");
//
//        IPNDobleT v3 = new IPNDobleT(22, 9.8F, 500, 210, 85, "220");
//        v3.baricentro();
//        v3.momentosDeInercia();
//        v3.rigidezAxial();
//        v3.condicionRigidezFlexional();



    }
}
