package Secciones;

public class VigaRectangular extends Vigas {


    public VigaRectangular(float altura, float ancho, float largo, int E, int G){
        super(altura, ancho, largo, E, G);
        System.out.println("Viga Rectangular - Asumimos Linealidades: estatica, cinematica y mecánica");

    }


    @Override
    public void area(){
        area = ancho * altura;
        System.out.println("Area = " + area);
    }

    @Override
    public void Baricentro(){
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
    }

    @Override
    public void MomentosPolarDeInercia() {


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
        int RigidezAxil;
        RigidezAxil = (int) ((E * area) / largo);
        System.out.println("Rigidez Axial = " + RigidezAxil);
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
