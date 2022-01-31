import Secciones.*;

public class Main {
    public static void main(String[] args) {
        VigaRectangular v1 = new VigaRectangular(20, 10, 500, 210, 80);
        v1.baricentro();
        v1.momentosDeInercia();
        v1.rigidezAxial();
        v1.condicionRigidezFlexional();
        v1.condicionRigidezTorsional();



        System.out.println("");

        BarraCircular v2 = new BarraCircular(5, 500, 210, 80);

        v2.baricentro();
        v2.momentosPolarDeInercia();
        v2.rigidezAxial();
        v2.condicionRigidezFlexional();
        v2.condicionRigidezTorsional();

        System.out.println("");

        IPNDobleT v3 = new IPNDobleT(22, 9.8F, 500, 210, 85, "220");
        v3.baricentro();
        v3.momentosDeInercia();
        v3.rigidezAxial();
        v3.condicionRigidezFlexional();




    }
}
