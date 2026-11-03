import org.example.projetoRestaurante.cardapio.ComCheddar;
import org.example.projetoRestaurante.cardapio.ItemCardapio;
import org.example.projetoRestaurante.cardapio.Lanche;
import org.example.projetoRestaurante.cardapio.LancheFactory;
import org.example.projetoRestaurante.pedido.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    void lancheRecusaPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Burger", -10.0);
        });
    }


    @Test
    void xBurgerComCheddarCalculaTotalCorretamente() {
        Pedido pedido = new Pedido(1, "Ana");
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBurger());
        pedido.adicionarItem(lanche);
        assertEquals(20.0, pedido.calcularTotal(), 0.001);
    }
}