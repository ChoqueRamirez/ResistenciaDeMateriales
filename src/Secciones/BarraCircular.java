package Secciones;

public class BarraCircular extends Vigas {
    public float radio;
    public float largo;
    public float Jp;
    public int E;
    public int G;

    public BarraCircular(float radio, float largo, int E, int G){
        super(radio, largo, E, G);
        System.out.println("Barra Circular");
    }

    private double area(){
        return Math.PI * radio * radio;
    }

    public void Baricentro(){
        System.out.println("Al ser doblemente simetrica el Baricentro se encuentra en el centro de la seccion");
    }

    @Override
    public void MomentosDeInercia() {

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
        int CondicionRF;
        CondicionRF = (int) (Jp * E);
        System.out.println("Condicion de Rigidez Flexional = " + CondicionRF);
    }

    public void CondicionRigidezTorsional(){
        int CondcionRT;
        CondcionRT = (int) (Jp * G);
        System.out.println("Condcion de Rigidez Torsional = " + CondcionRT);
    }



}
