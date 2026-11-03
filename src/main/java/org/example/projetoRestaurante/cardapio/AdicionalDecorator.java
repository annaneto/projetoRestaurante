package org.example.projetoRestaurante.cardapio;

public abstract class AdicionalDecorator implements ItemCardapio{

    protected ItemCardapio item;

    public AdicionalDecorator(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        this.item = item;
    }


}
