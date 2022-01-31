package Secciones;

public class BarraCircular extends Vigas {


    public BarraCircular(float radio, float largo, int E, int G){
        super(radio, largo, E, G);
        System.out.println("Barra Circular - Asumimos Linealidades: estatica, cinematica y mecánica");
    }

    @Override
    public float area(){
        return area = (float) (3.14 * radio * radio);

    }

    public void baricentro(){
        System.out.println("Baricentro: al tener simetria polar, este se encuentra en el centro de la seccion");
    }

    @Override
    public void momentosDeInercia() {
    }

    public void momentosPolarDeInercia(){
        Jp = (float) ((Math.PI * radio * radio * radio * radio)/4);
        System.out.println("Jp: " + Jp + "cm4");
    }

    public void rigidezAxial(){
        int rigidez;
        rigidez = (int) ((E * area())/largo);
        System.out.println("Rigidez Axial = " + rigidez);
    }

    public void condicionRigidezFlexional() {
        int condicionRF;
        condicionRF = (int) (Jp * E);
        System.out.println("Condicion de Rigidez Flexional = " + condicionRF);
    }

    public void condicionRigidezTorsional(){
        int condcionRT;
        condcionRT = (int) (Jp * G);
        System.out.println("Condcion de Rigidez Torsional = " + condcionRT);
    }



}
