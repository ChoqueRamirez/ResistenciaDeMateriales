package Secciones;

public class IPNDobleT extends Vigas{

    private final String designacion;

    public IPNDobleT(float altura, float ancho, float largo, int E, int G, String designacion) {
        super(altura, ancho, largo, E, G);
        this.designacion = designacion;
        System.out.println("Perfil Doble T - IPN. Se encuentra tabulado");
    }

    @Override
    public float area() {
        return area = 39.5F;

    }

    @Override
    public void baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
        System.out.println("Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " + ancho/2 + "cm; Y= " + altura/2 + "cm");

    }

    @Override
    public void momentosDeInercia() {
        Jy = 3060F;
        Jz = 162F;
        System.out.println("Jy = " + Jy + "cm4");
        System.out.println("Jz = " + Jz + "cm4");

    }

    @Override
    public float rigidezAxial() {
        int RigidezAxil;
        return RigidezAxil = (int) ((E * area()) / largo);
    }

    @Override
    public float condicionRigidezFlexional() {
        int CondicionRFlexional;
        return CondicionRFlexional = (int) (Jy * E);

    }

    @Override
    public float condicionRigidezTorsional() {
        float condicionRTorsional;
        return condicionRTorsional = 0;
    }

}
