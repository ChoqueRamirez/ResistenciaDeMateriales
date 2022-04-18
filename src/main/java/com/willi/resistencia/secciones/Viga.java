package com.willi.resistencia.secciones;

import com.willi.resistencia.exceptions.ModulosIndefinidosException;
import com.willi.resistencia.exceptions.VigaConLargoIndefinidoException;

public abstract class Viga {
    protected float largo;
    protected int E;
    protected int G;
    protected float tensionNormalSA;
    protected float tensionNormalSF;
    protected float tensionTangencialST;
    protected float tensionTangencialFV;

    public Viga(float largo, int e, int g) {
        if(largo <= 0){
            throw new VigaConLargoIndefinidoException("La viga debe tener un largo");
        }else if(e <= 0 || g <= 0){
            throw new ModulosIndefinidosException("Los modulos deben ser mayores a cero");
        }else {
            this.largo = largo;
            this.E = e;
            this.G = g;
        }
    }

    public abstract void baricentro();

    public abstract float coordBaricentricaEnX();

    public abstract float coordBaricentricaEnY();

    public abstract float momentoDeInerciaY();

    public abstract float momentoDeInerciaZ();

    public abstract float solicitacionAxil(float fuerza, final String unidad, final String direccion);

    public abstract float solicitacionAFlexion(float fuerza, final String unidad, final String direccion);

    public abstract float solicitacionTorsional(float fuerza, String unidad, String dirrecion);

    public abstract float solicitacionPorCorte(float fuerza, String unidad, final String direccion);

    public abstract float deformacionEspLong();

    public abstract float deformacionEspTang();

    public abstract float getArea();

    public abstract float getLargo();

    public abstract float getTensionNormalSA();

    public abstract float getTensionNormalSF();

    public abstract float getTensionTangencialST();

    public abstract float getTensionTangencialFV();
}
