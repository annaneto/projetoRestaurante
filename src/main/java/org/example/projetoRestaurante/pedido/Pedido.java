package org.example.projetoRestaurante.pedido;

import org.example.projetoRestaurante.cardapio.ItemCardapio;
import org.example.projetoRestaurante.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(int id, String nome){
        setId(id);
        setNomeCliente(nome);
    }
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setNomeCliente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Você digitou um valor vazio ou nulo");
        }
        this.nomeCliente = nome;
    }

    public String getNomeCliente(){
        return this.nomeCliente;
    }


    public void adicionarItem(ItemCardapio item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public boolean removerItem(int indice) {
        if (indice >= 0 && indice < itens.size()) {
            itens.remove(indice);
            return true;
        }
        return false;
    }


    public ArrayList<ItemCardapio> getItens(){
        return itens;
    }

    public double calcularTotal(){
        double valorTotal = 0;
        for(ItemCardapio item : itens){
            valorTotal += item.getPreco();
        }
        return valorTotal;
    }
}
