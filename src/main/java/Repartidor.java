import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Repartidor {

    private final String nombre;
    private Posicion posicion;
    private List<Pedido> pedidosPorEntregar = new ArrayList<>();

    public Repartidor(String nombre, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.posicion = new Posicion(longitud, latitud);
    }

    public String getNombre() {
        return nombre;
    }


    public void cambioDePosicion(Double latitud, Double longitud){
        this.posicion = new Posicion(latitud, longitud);
    }

    public void asignarPedido(List<Pedido> pedidos) {

        if(pedidos.isEmpty()){
            return;
        }

        Pedido pedido = pedidoConMenorDistancia(pedidos);
        pedidosPorEntregar.add(pedido);
    }

    protected Pedido pedidoConMenorDistancia(List<Pedido> pedidos) {
        return pedidos.stream()
                .min((d1, d2) -> (int) (distancia(d1.getPosicion()) - distancia(d2.getPosicion())))
                .orElseThrow(() -> new RuntimeException(""));
    }

    protected double distancia(Posicion posicion) {
        return posicion.getLatitud() / this.posicion.getLatitud();
    }

    public List<Pedido> quePedidosTenes() {
        return pedidosPorEntregar;
    }
}
