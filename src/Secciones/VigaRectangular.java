package Secciones;


public class VigaRectangular extends Vigas{
    public Geometria geometriaRectangular;
    public int E;
    public int G;


    public VigaRectangular(float altura, float ancho, float largo, int E, int G){
        super(altura, ancho, largo, E, G);
        System.out.println("Viga Rectangular - Asumimos Linealidades: estatica, cinematica y mecánica");

    }


    @Override
    public void area(){
        area = ancho * altura;
        System.out.println("Area = " + area + " cm2");
    }

    @Override
    public void Baricentro(){
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
        System.out.println("Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " + ancho/2 + "cm; Y= " + altura/2 + "cm");
    }

    @Override
    public void MomentosPolarDeInercia() {
        System.out.println("No es una seccion circular");
    }

    @Override
    public void MomentosDeInercia(){
        Jy = (ancho * altura * altura * altura)/12;
        Jz = (altura * ancho * ancho * ancho)/12;
        System.out.println("Jy: " + Jy + " cm4");
        System.out.println("Jz: " + Jz + " cm4");
    }

    @Override
    public void RigidezAxial() {
        int RigidezAxial;
        RigidezAxial = (int) ((E * area) / largo);
        System.out.println("Rigidez Axial = " + RigidezAxial);
    }

    @Override
    public void CondicionRigidezFlexional(){
        int CondicionRFlexional;
        CondicionRFlexional = (int) (Jy * E);
        System.out.println("CondicionRFlexional = " + CondicionRFlexional);
    }

    @Override
    public void CondicionRigidezTorsional(){
        System.out.println("Cond. Rigidez Torsional: No puede determinarse. No es una seccion circular tampoco puede connsiderarse una seccion abierta de paredes delgadas para aplicar la teoria de Saint Venant");
    }
}
