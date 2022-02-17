public class Posicion {
    private Double longitud;
    private Double latitud;

    public Posicion(Double longitud, Double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public boolean esMenor(Posicion posicion) {
        return false;
    }
}
