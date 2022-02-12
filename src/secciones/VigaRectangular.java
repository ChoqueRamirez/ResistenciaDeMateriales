package secciones;


import complementos.Coordenadas;

public class VigaRectangular extends Vigas{


    public VigaRectangular(float altura, float ancho, float largo, int E, int G){
        super(altura, ancho, largo, E, G);
        System.out.println("Viga Rectangular - Asumimos Linealidades: estatica, cinematica y mecánica");
    }

    @Override
    public float getArea(){
        return ancho * altura;
    }

    @Override
    public void baricentro(){
        Coordenadas coordenadas = new Coordenadas(ancho/2, altura/2);
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion"
        + "\n" + "Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " +
        coordenadas.getCoordenadaEnX() + "cm; Y= " + coordenadas.getCoordenadaEnY() + "cm");
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
        return (int) ((E * getArea()) / largo);

    }

    @Override
    public float condicionRigidezFlexional(){
        return (int) (Jy * E);

    }

    @Override
    public float condicionRigidezTorsional(){
        int condicionRTorsional;
        return condicionRTorsional = 0;
    }



    public float getLargo() {
        return largo;
    }

    public float getJy() {
        return Jy;
    }

    public float getJz() {
        return Jz;
    }

}




