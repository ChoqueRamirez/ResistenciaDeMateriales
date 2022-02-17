package secciones;

public class TuboRectangular extends Vigas{

    private float espesor1;
    private float espesor2;

    public TuboRectangular(float ancho, float espesor1, float altura, float espesor2,  float largo, int E, int G) {
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
        if(radio != 0){
            return (float) ((Math.PI * radio * radio * radio * radio)/4);
        }else{
            return 0;
        }
    }

    public float constanteDeTorsion(){
        return (ancho-espesor1)*(altura-espesor2);
    }

    @Override
    public float getArea() {
        return 0;
    }

    @Override
    public float getLargo() {
        return largo;
    }

    @Override
    public float getAltura() {
        return altura;
    }

    @Override
    public float getAncho() {
        return ancho;
    }

    @Override
    public float getRadio() {
        return radio;
    }

    public float getEspesor1() {
        return espesor1;
    }

    public float getEspesor2() {
        return espesor2;
    }
}
