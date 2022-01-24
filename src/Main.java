import Secciones.BarraCircular;
import Secciones.VigaRectangular;

public class Main {
    public static void main(String[] args) {
        VigaRectangular Viga1 = new VigaRectangular(20, 10, 500, 210, 80);
        Viga1.Baricentro();
        Viga1.MomentosDeInercia();
        Viga1.RigidezAxial();
        Viga1.CondicionRigidezFlexional();
        Viga1.CondicionRigidezTorsional();

        System.out.println("");

        BarraCircular Viga2 = new BarraCircular(5, 500, 210, 80);
        Viga2.Baricentro();
        Viga2.MomentosPolarDeInercia();
        Viga2.RigidezAxial();
        Viga2.CondicionRigidezFlexional();
        Viga2.CondicionRigidezTorsional();




    }
}
