package com.willi.resistencia.complementos;


public class Apoyos {
    private final int condicionDeVinculo;
    private final int GRADOS_DE_LIBERTAD = 3;
    private String tipoDeVinculo;
    private float longitud;
    protected int gradoDeHiperestaticidad;


    public Apoyos(int condicionDeVinculo, String tipoDeVinculo, float longitud){
        this.condicionDeVinculo = condicionDeVinculo;
        this.tipoDeVinculo = tipoDeVinculo;
        this.longitud = longitud;
    }

    public int gradoDeHiperesticidad() {
        return condicionDeVinculo - GRADOS_DE_LIBERTAD;
    }




}
