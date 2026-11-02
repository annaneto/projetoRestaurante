package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.Lanche;
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
    public void adcionarItemPedido(int id, Lanche lanche){
        Pedido pedido = gerenciador.consultarPedido(id);
        if(pedido != null){
            pedido.adicionarLanche(lanche);
        }
    }
    public ArrayList<Pedido> getPedidos(){
        return gerenciador.getPedidos();
    }
    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDia();
    }
}
