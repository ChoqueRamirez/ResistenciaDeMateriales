package Secciones;

public class VigaRectangular {
    public float altura;
    public float ancho;
    public float largo;
    public int E;
    public int G;
    public float Jy;
    public float Jz;

    public VigaRectangular(float altura, float ancho, float largo, int E, int G){
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
        this.E = E;
        this.G = G;
    }

    private double area(){
        return altura * ancho;
    }

    public void Baricentro(){
        System.out.println("Al ser doblemente simetrica el Baricentro se encuentra en el centro de la seccion");
    }

    public void MomentosDeInercia(){
        Jy = (ancho * altura * altura * altura)/12;
        Jz = (altura * ancho * ancho * ancho)/12;
        System.out.println("Jy: " + Jy + " cm4");
        System.out.println("Jz: " + Jz + " cm4");
    }

    public void RigidezAxial() {
        int RigidezAxil;
        RigidezAxil = (int) ((E * area()) / largo);
        System.out.println("Rigidez Axial = " + RigidezAxil);
    }

    public void CondicionRigidezFlexional(){
        int CondicionRFlexional;
        CondicionRFlexional = (int) (Jy * E);
        System.out.println("CondicionRFlexional = " + CondicionRFlexional);
    }

    public void CondicionRigidezTorsional(){
        System.out.println("No puede determinarse. No es una seccion circular tampoco puede connsiderarse una seccion abierta de paredes delgadas para aplicar la teoria de Saint Venant");
    }
}
