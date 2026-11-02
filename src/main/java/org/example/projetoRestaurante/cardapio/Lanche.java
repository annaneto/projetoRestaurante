package org.example.projetoRestaurante.cardapio;

public class Lanche {

    private String nome;
    private double preco;

    public void setNome(String nome) {
        if(nome != null || !nome.equals("")) {
            this.nome = nome;
        }else{
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
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

    public double getPreco() {
        return preco;
    }



    public Lanche(String nome, double preco) {
            setNome(nome);
            setPreco(preco);

        }
    }

