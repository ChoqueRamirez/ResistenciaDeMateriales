package Secciones;

public class BarraCircular {
    public float radio;
    public float largo;
    public float Jp;
    public int E;
    public int G;

    public BarraCircular(float radio, float largo, int E, int G){
        this.radio = radio;
        this.largo = largo;
        this.E = E;
        this.G = G;
    }

    private double area(){
        return Math.PI * radio * radio;
    }

    public void Baricentro(){
        System.out.println("Al ser doblemente simetrica el Baricentro se encuentra en el centro de la seccion");
    }

    public void  MomentosPolarDeInercia(){
        Jp = (float) ((Math.PI * radio * radio * radio * radio)/4);
        System.out.println("Jp: " + Jp + "cm4");
    }

    public void RigidezAxial(){
        int Rigidez;
        Rigidez = (int) ((E * area())/largo);
        System.out.println("Rigidez Axial = " + Rigidez);
    }

    public void CondicionRigidezFlexional() {
        int CondicionRFlexional;
        CondicionRFlexional = (int) (Jp * E);
        System.out.println("CondicionRFlexional = " + CondicionRFlexional);
    }




}
