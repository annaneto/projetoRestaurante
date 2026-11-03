package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.*;
import org.example.projetoRestaurante.pedido.Pedido;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Modificar um pedido");
        System.out.println("4 - Fechar restaurante");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Item 3.4: Trata qualquer erro numérico sem quebrar o sistema[cite: 1]
    public int lerOpcao() {
        while (true) {
            try {
                int opcao = sc.nextInt();
                sc.nextLine(); // Consome a quebra de linha
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite apenas números inteiros!");
                sc.nextLine(); // Limpa a entrada inválida do buffer[cite: 1]
                System.out.print("Tente novamente: ");
            }
        }
    }

    public String lerNomeCliente() {
        System.out.print("Digite o nome do cliente: ");
        return sc.nextLine();
    }

    public void exibirCardapio() {
        System.out.println("\n--- CARDÁPIO ---");
        System.out.println("1 - X-Burger (R$ 16,00)");
        System.out.println("2 - X-Salada (R$ 18,00)");
        System.out.println("3 - X-Bacon (R$ 22,00)");
        System.out.println("0 - Cancelar");
        System.out.print("Escolha o lanche: ");
    }

    // Item 3.1: Monta a personalização do lanche e adicionais[cite: 1]
    public ItemCardapio lerLanchePersonalizado() {
        exibirCardapio();
        int opcao = lerOpcao();
        Lanche lanche;
        switch (opcao) {
            case 1: lanche = LancheFactory.xBurger(); break;
            case 2: lanche = LancheFactory.xSalada(); break;
            case 3: lanche = LancheFactory.xBacon(); break;
            default: return null;
        }

        // Pergunta sobre retirada de ingredientes[cite: 1]
        System.out.print("Deseja retirar algum ingrediente? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            System.out.print("Retirar queijo? (s/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("s")) lanche.setQueijo(false);

            System.out.print("Retirar alface? (s/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("s")) lanche.setAlface(false);

            System.out.print("Retirar tomate? (s/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("s")) lanche.setTomate(false);

            System.out.print("Retirar cebola? (s/n): ");
            if (sc.nextLine().trim().equalsIgnoreCase("s")) lanche.setCebola(false);
        }

        // Adicionais com Decorator[cite: 1]
        ItemCardapio itemFinal = lanche;
        System.out.print("Adicionar cheddar extra (+ R$ 4,00)? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            itemFinal = new ComCheddar(itemFinal);
        }

        System.out.print("Adicionar bacon extra (+ R$ 6,00)? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            itemFinal = new ComBaconExtra(itemFinal);
        }

        return itemFinal;
    }

    public boolean desejaAdicionarMaisItem() {
        System.out.print("Deseja adicionar mais um item? (s/n): ");
        return sc.nextLine().trim().equalsIgnoreCase("s");
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        System.out.println("\n--- PEDIDOS DO DIA ---");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado até o momento.");
            return;
        }
        for (Pedido p : pedidos) {
            exibirDetalhesPedido(p);
        }
    }

    // Utiliza getId() e getDescricao()[cite: 1]
    public void exibirDetalhesPedido(Pedido p) {
        System.out.println("Pedido #" + p.getId() + " - Cliente: " + p.getNomeCliente());
        System.out.println("Itens:");
        for (int i = 0; i < p.getItens().size(); i++) {
            ItemCardapio item = p.getItens().get(i);
            System.out.println("  [" + (i + 1) + "] " + item.getDescricao() + " (R$ " + String.format("%.2f", item.getPreco()) + ")");
        }
        System.out.println("Total: R$ " + String.format("%.2f", p.calcularTotal()));
        System.out.println("--------------------------");
    }

    public int lerIdPedido() {
        System.out.print("Digite o ID do pedido: ");
        return lerOpcao();
    }

    public int lerIndiceItemRemover() {
        System.out.print("Digite o número do item a remover: ");
        return lerOpcao() - 1; // Ajusta de base 1 para índice base 0
    }

    public int menuModificacaoPedido() {
        System.out.println("\n--- MODIFICAR PEDIDO ---");
        System.out.println("1 - Acrescentar novo item");
        System.out.println("2 - Remover um item");
        System.out.println("3 - Cancelar pedido inteiro");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
        return lerOpcao();
    }

    // Item 3.3: Exibe o total e as combinações com HashSet[cite: 1]
    public void exibirFechamentoDoDia(double total, HashSet<String> combinacoes) {
        System.out.println("\n=== FECHAMENTO DO DIA ===");
        System.out.println("Total arrecadado hoje: R$ " + String.format("%.2f", total));
        System.out.println("Total de combinações diferentes pedidas: " + combinacoes.size());
        System.out.println("Combinações que saíram:");
        for (String c : combinacoes) {
            System.out.println("  * " + c);
        }
        System.out.println("Restaurante fechado. Até amanhã!");
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }
}