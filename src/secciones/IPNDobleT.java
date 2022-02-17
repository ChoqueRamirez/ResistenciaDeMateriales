package secciones;

public class IPNDobleT extends Vigas{

    private final String designacion;
    private float area;
    private float Jy;
    private float Jz;

    public IPNDobleT(float altura, float ancho, float area, float largo, float Jy, float Jz, int E, int G, String designacion) {
        super(altura, ancho, largo, E, G);
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
    public float momentosPolarDeInercia(){
        if(radio != 0){
            return (float) ((Math.PI * radio * radio * radio * radio)/4);
        }else{
            return 0;
        }
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
    public float getRadio(){
        return radio;
    }

}
