package com.willi.resistencia.secciones;

import java.util.Objects;

public class IPNDobleT extends VigaConAlturaYAncho {

    private final String designacion;
    private final float ty;
    private final float tw;
    private final float area;
    private final float Jy;
    private final float Jz;
    private final float momentoEstaticoQ;
    private final float moduloDeTorsionJ;

    public IPNDobleT(float altura, float ancho, float ty, float tw, float area,
                     float largo, float Jy, float Jz, float momentoEstaticoQ, int E, int G, String designacion, float moduloDeTorsionJ) {
        super(altura, ancho, largo, E, G);
        this.ty = ty;
        this.tw = tw;
        this.area = area;
        this.designacion = designacion;
        this.Jy = Jy;
        this.Jz = Jz;
        this.momentoEstaticoQ = momentoEstaticoQ;
        this.moduloDeTorsionJ = moduloDeTorsionJ;
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
    public float solicitacionAxil(float fuerza, final String unidad, final String direccion){
        return fuerza / getArea();
    }

    @Override
    public float solicitacionAFlexion(float fuerza, final String unidad, final String direccion) {
        if (Objects.equals(direccion, "y")){
            return (fuerza * altura/2) / momentoDeInerciaY();
        } else if (Objects.equals(direccion, "z")){
            return (fuerza * ancho/2) / momentoDeInerciaZ();
        } else{
            return 0;
        }
    }

    @Override
    public float solicitacionTorsional(float fuerza, String unidad, String dirrecion) {
        return (fuerza * tw ) / moduloDeTorsionJ;
    }

    public float solicitacionPorCorte(float fuerza, String unidad, final String direccion){
        return (fuerza * momentoEstaticoQ) / momentoDeInerciaY()*tw;
    }

    @Override
    public float deformacionEspecifica(Viga viga, float fuerza, String unidad, String direccion){
        return viga.solicitacionAFlexion(fuerza, unidad, direccion) / E;
    }

}
