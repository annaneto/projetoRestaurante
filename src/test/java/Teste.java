import org.example.projetoRestaurante.cardapio.Lanche;
import org.example.projetoRestaurante.pedido.GerenciadorPedidos;
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
    void lancheRecusaNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("   ", 15.0);
        });
    }

    @Test
    void pedidoCalculaTotalCorretamente() {
        Pedido pedido = new Pedido(1, "Ana");
        pedido.adicionarItem(new Lanche("X-Burger", 16.0));
        pedido.adicionarItem(new Lanche("X-Salada", 18.0));
        assertEquals(34.0, pedido.calcularTotal(), 0.001);
    }
}