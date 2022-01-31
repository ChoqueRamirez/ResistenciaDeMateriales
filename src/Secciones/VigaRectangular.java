package Secciones;


import Complementos.Coordenadas;

public class VigaRectangular extends Vigas{

    float coordenadaEnX;

    public VigaRectangular(float altura, float ancho, float largo, int E, int G){
        super(altura, ancho, largo, E, G);
        System.out.println("Viga Rectangular - Asumimos Linealidades: estatica, cinematica y mecánica");
    }

    @Override
    public float area(){
        return area = ancho * altura;
    }

    @Override
    public void baricentro(){

        Coordenadas coordenadas = new Coordenadas(ancho/2, altura/2);
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion"
        + "\n" + "Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " +
        coordenadas.getCoordenadaEnX() + "cm; Y= " + coordenadas.getCoordenadaEnY() + "cm");
    }


    @Override
    public void momentosDeInercia(){
        Jy = (ancho * altura * altura * altura)/12;
        Jz = (altura * ancho * ancho * ancho)/12;
        System.out.println("Jy: " + Jy + " cm4");
        System.out.println("Jz: " + Jz + " cm4");
    }

    @Override
    public float rigidezAxial() {
        int RigidezAxial;
        return RigidezAxial = (int) ((E * area()) / largo);

    }

    @Override
    public float condicionRigidezFlexional(){
        int condicionRFlexional;
        return condicionRFlexional = (int) (Jy * E);

    }

    @Override
    public float condicionRigidezTorsional(){
        int condicionRTorsional;
        return condicionRTorsional = 0;
    }


}
