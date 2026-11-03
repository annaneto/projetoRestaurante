package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.ItemCardapio;
import org.example.projetoRestaurante.pedido.GerenciadorPedidos;
import org.example.projetoRestaurante.pedido.Pedido;
import java.util.Collection;
import java.util.HashSet;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public Pedido buscarPedido(int id) {
        return gerenciador.buscarPedido(id);
    }

    public Pedido consultarPedido(int id) {
        return gerenciador.consultarPedido(id);
    }

    public void adicionarItemAoPedido(int id, ItemCardapio item) {
        Pedido pedido = gerenciador.buscarPedido(id);
        if (pedido != null) {
            pedido.adicionarItem(item);
        }
    }

    public void adicionarItemPedido(int id, ItemCardapio item) {
        adicionarItemAoPedido(id, item);
    }

    public boolean removerItemDoPedido(int id, int indiceItem) {
        Pedido pedido = gerenciador.buscarPedido(id);
        if (pedido != null) {
            return pedido.removerItem(indiceItem);
        }
        return false;
    }

    public boolean cancelarPedido(int id) {
        return gerenciador.cancelarPedido(id);
    }

    public Collection<Pedido> getPedidos() {
        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public HashSet<String> getCombinacoesUnicas() {
        return gerenciador.obterCombinacoesUnicas();
    }
}
