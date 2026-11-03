package org.example.projetoRestaurante.pedido;

import org.example.projetoRestaurante.cardapio.ItemCardapio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente){
        Pedido novoPedido = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(contadorPedidos, novoPedido);
        contadorPedidos++;
        return novoPedido;
    }
    public ArrayList<Pedido> getPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    public double calcularTotalDia(){
        double totalDia = 0;

        for(Pedido p : pedidos.values()){
            totalDia += p.calcularTotal();
        }
        return totalDia;
    }

    public Pedido consultarPedido(int idPedido){
        return pedidos.get(idPedido);
    }

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
