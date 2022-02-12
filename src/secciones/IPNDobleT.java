package secciones;

public class IPNDobleT extends Vigas{

    private final String designacion;
    private float area;
    private float Jy;
    private float Jz;

    public IPNDobleT(float altura, float ancho, float area, float largo, float Jy, float Jz, int E, int G, String designacion) {
        super(altura, ancho, largo, E, G);
        this.area = area;
        this.designacion = designacion;
        this.Jy = Jy;
        this.Jz = Jz;
        System.out.println("Perfil Doble T - IPN. Se encuentra tabulado");
    }

    @Override
    public float getArea() {
        return area;

    }

    @Override
    public void baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
        System.out.println("Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " + ancho/2 + "cm; Y= " + altura/2 + "cm");

    }


    @Override
    public float momentoDeInerciaY(){
        return (ancho * altura * altura * altura)/12;
    }

    @Override
    public float momentoDeInerciaZ(){
        return (altura * ancho * ancho * ancho)/12;
    }

    @Override
    public float rigidezAxial() {
        int RigidezAxil;
        return RigidezAxil = (int) ((E * getArea()) / largo);
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
