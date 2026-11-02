package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.ItemCardapio;
import org.example.projetoRestaurante.cardapio.LancheFactory;
import org.example.projetoRestaurante.pedido.GerenciadorPedidos;
import org.example.projetoRestaurante.pedido.Pedido;

import java.util.ArrayList;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente){
       return gerenciador.criarPedido(nomeCliente);
    }
    public Pedido buscarPedido(int id){
        return gerenciador.consultarPedido(id);
    }
    public void adicionarItemPedido(int id, ItemCardapio item) {
        Pedido pedido = gerenciador.consultarPedido(id);
        if (pedido != null) {
            pedido.adicionarItem(item);
        }
    }
    public ArrayList<Pedido> getPedidos(){
        return gerenciador.getPedidos();
    }
    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDia();
    }

    // metodos para adicionar opcao de lanche

    public void adicionarXBurgerAoPedido(int idPedido) {
        Pedido p = gerenciador.consultarPedido(idPedido);
        if (p != null) {
            p.adicionarItem(LancheFactory.xBurger());
        }
    }

    public void adicionarXSaladaAoPedido(int idPedido) {
        Pedido p = gerenciador.consultarPedido(idPedido);
        if (p != null) {
            p.adicionarItem(LancheFactory.xSalada());
        }
    }

    public void adicionarXBaconAoPedido(int idPedido) {
        Pedido p = gerenciador.consultarPedido(idPedido);
        if (p != null) {
            p.adicionarItem(LancheFactory.xBacon());
        }
    }



}
