package secciones;

public class TuboRectangular extends VigasConAlturaYAncho {

    private final float espesor1;
    private final float espesor2;

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
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        return fuerza/(2 * constanteDeTorsion() * espesor1);
    }

    public float getEspesor1() {
        return espesor1;
    }

    public float getEspesor2() {
        return espesor2;
    }

    @Override
    public float solicitacionAFlexion(float fuerza, final String unidad, final String direccion) {
        return  (fuerza * altura / 2 ) / momentoDeInerciaY();
    }
}
