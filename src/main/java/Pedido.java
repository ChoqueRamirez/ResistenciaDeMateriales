import java.util.List;

public class Pedido {
    private List<Producto> productoList;
    private Posicion posicion;

    public Pedido(List<Producto> productoList, Double longitud, Double latitude) {
        this.productoList = productoList;
        this.posicion = new Posicion(longitud, latitude);
    }

    public Posicion getPosicion() {
        return posicion;
    }


}
