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

    public float rigidezAxial(){
        int rigidez;
        return rigidez = (int) ((E * area())/largo);

    }

    public float condicionRigidezFlexional() {
        int condicionRF;
        return condicionRF = (int) (Jp * E);

    }

    public float condicionRigidezTorsional(){
        int condcionRT;
        return condcionRT = (int) (Jp * G);

    }



}
