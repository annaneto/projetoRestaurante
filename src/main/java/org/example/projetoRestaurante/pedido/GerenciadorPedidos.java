package org.example.projetoRestaurante.pedido;

import org.example.projetoRestaurante.cardapio.ItemCardapio;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class GerenciadorPedidos {
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente) {
        Pedido novoPedido = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novoPedido.getId(), novoPedido);
        contadorPedidos++;
        return novoPedido;
    }

    public Pedido buscarPedido(int id) {
        return pedidos.get(id);
    }

    public Pedido consultarPedido(int id) {
        return pedidos.get(id);
    }


    public boolean cancelarPedido(int id) {
        return pedidos.remove(id) != null;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }

    public double calcularTotalDoDia() {
        double total = 0.0;
        for (Pedido p : pedidos.values()) {
            total += p.calcularTotal();
        }
        return total;
    }

    public double calcularTotalDia() {
        return calcularTotalDoDia();
    }

    // Item 3.3
    public HashSet<String> obterCombinacoesUnicas() {
        HashSet<String> combinacoes = new HashSet<>();
        for (Pedido p : pedidos.values()) {
            for (ItemCardapio item : p.getItens()) {
                combinacoes.add(item.getDescricao());
            }
        }
        return combinacoes;
    }
}