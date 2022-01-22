public class Viga {
    public float altura;
    public float ancho;
    public float largo;
    public float Jy;
    public float Jz;

    public Viga(float altura,float ancho, float largo){
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
    }

    public void Baricentro(){
        System.out.println("Al ser doblemente simetrica el Baricentro se encuentra en el centro de la seccion");
    }

    public void MomentoDeInercia(){
        Jy = (ancho * altura * altura * altura)/12;
        Jz = (altura * ancho * ancho * ancho)/12;
        System.out.println("Jy: " + Jy + " cm4");
        System.out.println("Jz: " + Jz + " cm4");

    }
}
