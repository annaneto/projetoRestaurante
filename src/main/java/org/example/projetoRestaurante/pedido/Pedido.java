package org.example.projetoRestaurante.pedido;

import org.example.projetoRestaurante.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private String nomeCliente;
    ArrayList<Lanche> listaLanches = new ArrayList<>();

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


    public void adicionarLanche(Lanche lanche){
        listaLanches.add(lanche);
    }

    public ArrayList<Lanche> getItens(){
        return listaLanches;
    }

    public double calcularTotal(){
        double valorTotal = 0;
        for(Lanche lanche : listaLanches){
            valorTotal += lanche.getPreco();
        }
        return valorTotal;
    }
}
