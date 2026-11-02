package org.example.projetoRestaurante.cardapio;

public class Lanche implements ItemCardapio{

    private String nome;
    private double preco;

    public Lanche(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPreco(double preco) {
        if(preco >= 0){
        this.preco = preco;
        }else{
            throw new IllegalArgumentException("O valor não pode ser menor que zero");
        }
    }
    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao(){
            return this.nome;
    }




    }

