package complementos;

public class Coordenadas {
    protected final float coordenadaEnX;
    protected final float coordenadaEnY;

    public Coordenadas (float coordenadaEnX, float coordenadaEnY){
        this.coordenadaEnX = coordenadaEnX;
        this.coordenadaEnY = coordenadaEnY;
    }

    public float getCoordenadaEnX() {
        return coordenadaEnX;
    }

    public float getCoordenadaEnY() {
        return coordenadaEnY;
    }
}
