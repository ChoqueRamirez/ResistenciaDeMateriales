import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RepartidorTest {

    Repartidor repartidor;

    @Before
    public void inicialitazion(){
        repartidor = new Repartidor("juan", 10d, 30d);
    }

    @Test
    public void testDistancia() {
        double distancia = repartidor.distancia(new Posicion(10d, 10d));
        double expected = 1;

        Assert.assertEquals(expected, distancia, 0.1);
    }

    @Test
    public void test2(){
        Pedido pedido1 = new Pedido(new ArrayList<>(), 10d, 10d);
        Pedido expected = new Pedido(new ArrayList<>(), 20d, 40d);
        Pedido pedido3 = new Pedido(new ArrayList<>(), 60d, 70d);
        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList.add(pedido1);
        pedidoList.add(pedido3);
        pedidoList.add(expected);
        Pedido pedido = repartidor.pedidoConMenorDistancia(pedidoList);
        Assert.assertEquals(pedido1, pedido);
    }
}