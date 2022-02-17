package secciones;

public class IPNDobleT extends Vigas{

    private final String designacion;
    private float area;
    private float Jy;
    private float Jz;

    public IPNDobleT(float altura, float ancho, float area, float largo, float Jy, float Jz, int E, int G, String designacion) {
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
        this.E = E;
        this.G = G;
        this.area = area;
        this.designacion = designacion;
        this.Jy = Jy;
        this.Jz = Jz;
        System.out.println("Perfil Doble T - IPN. Se encuentra tabulado");
    }


    @Override
    public void baricentro() {
        System.out.println("Baricentro: al ser doblemente simetrica este se encuentra en el centro de la seccion");
        System.out.println("Tomando como referencia el extremo izquierdo de la seccion con una terna X e Y: X= " +coordBaricentricaEnX() + "cm; Y= " + coordBaricentricaEnY() + "cm");
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
    public float momentoDeInerciaY(){
        return Jy;
    }

    @Override
    public float momentoDeInerciaZ(){
        return Jz;
    }

    @Override
    public float getArea() {
        return area;
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
    public float solicitacionAFlexion(float fuerza, final String unidad, final String direccion) {
        return  (fuerza * altura / 2 ) / momentoDeInerciaY();
    }

    @Override
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        // falta agregar la formula
        return 0;
    }

}
