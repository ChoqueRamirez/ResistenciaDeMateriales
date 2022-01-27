package Secciones;

public class IPNDobleT extends Vigas{

    private final String designacion;

    public IPNDobleT(float altura, float ancho, float largo, int E, int G, String designacion) {
        super(altura, ancho, largo, E, G);
        this.designacion = designacion;
        System.out.println("Perfil Doble T - IPN. Se encuentra tabulado");
    }

    @Override
    public void area() {
        area = 39.5F;
        System.out.println("Area: " + area + "cm2");
    }

    @Override
    public void Baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
        System.out.println("Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " + ancho/2 + "cm; Y= " + altura/2 + "cm");

    }

    @Override
    public void MomentosDeInercia() {
        Jy = 3060F;
        Jz = 162F;
        System.out.println("Jy = " + Jy + "cm4");
        System.out.println("Jz = " + Jz + "cm4");

    }

    @Override
    public void MomentosPolarDeInercia() {
    }

    @Override
    public void RigidezAxial() {
        int RigidezAxil;
        RigidezAxil = (int) ((E * area) / largo);
        System.out.println("Rigidez Axial = " + RigidezAxil);
    }

    @Override
    public void CondicionRigidezFlexional() {
        int CondicionRFlexional;
        CondicionRFlexional = (int) (Jy * E);
        System.out.println("CondicionRFlexional = " + CondicionRFlexional);
    }

    @Override
    public void CondicionRigidezTorsional() {

    }

}
