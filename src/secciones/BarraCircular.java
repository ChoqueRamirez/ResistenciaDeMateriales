package secciones;

public class BarraCircular extends Vigas {


    public BarraCircular(float radio, float largo, int E, int G){
        super(radio, largo, E, G);
        System.out.println("Barra Circular - Asumimos Linealidades: estatica, cinematica y mecánica");
    }


    @Override
    public float getArea(){
        return (float) (Math.PI * radio * radio);

    }

    public void baricentro(){
        System.out.println("Baricentro: al tener simetria polar, este se encuentra en el centro de la seccion");
    }

    @Override
    public float momentoDeInerciaY(){
        return (radio * radio * radio * radio)/12;
    }

    @Override
    public float momentoDeInerciaZ(){
        return (altura * ancho * ancho * ancho)/12;
    }

    public float momentosPolarDeInercia(){
        return (float) ((Math.PI * radio * radio * radio * radio)/4);
    }

    public float rigidezAxial(){
        return ((E * getArea())/largo);

    }

    public float condicionRigidezFlexional() {
        return (momentosPolarDeInercia() * E);

    }

    public float condicionRigidezTorsional(){
        return (momentosPolarDeInercia() * G);

    }

    public float getRadio() {
        return radio;
    }

}
