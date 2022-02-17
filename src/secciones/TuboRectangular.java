package secciones;

public class TuboRectangular extends Vigas{

    private float espesor1;
    private float espesor2;

    public TuboRectangular(float altura, float espesor1, float ancho, float espesor2, float largo, int E, int G) {
        super(altura, ancho, largo, E, G);
        this.espesor1 = espesor1;
        this.espesor2 = espesor2;
    }

    @Override
    public void baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion"
                + "\n" + "Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " +
                coordBaricentricaEnX() + "cm; Y= " + coordBaricentricaEnY() + "cm");
    }

    @Override
    public float coordBaricentricaEnX(){
        return getAncho()/2;
    }

    @Override
    public float coordBaricentricaEnY(){
        return getAltura()/2;
    }

    @Override
    public float momentoDeInerciaY() {
        return 0;
    }

    @Override
    public float momentoDeInerciaZ() {
        return 0;
    }

    @Override
    public float momentosPolarDeInercia() {
        return 0;
    }

    @Override
    public float rigidezAxial() {
        return 0;
    }

    @Override
    public float condicionRigidezFlexional() {
        return 0;
    }

    @Override
    public float condicionRigidezTorsional() {
        return 0;
    }

    @Override
    public float getArea() {
        return 0;
    }

    @Override
    public float getLargo() {
        return 0;
    }

    @Override
    public float getAltura() {
        return 0;
    }

    @Override
    public float getAncho() {
        return 0;
    }

    @Override
    public float getRadio() {
        return 0;
    }
}
