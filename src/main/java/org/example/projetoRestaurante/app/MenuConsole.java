package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.ItemCardapio;
import org.example.projetoRestaurante.cardapio.Lanche;
import org.example.projetoRestaurante.cardapio.LancheFactory;
import org.example.projetoRestaurante.pedido.Pedido;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        while (true) {
            try {
                int opcao = sc.nextInt();
                sc.nextLine(); // consome a quebra de linha pendente
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros!");
                sc.nextLine(); // limpa a entrada inválida do buffer
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
        System.out.println("0 - Concluir escolha");
        System.out.print("Escolha o lanche: ");
    }

    public Lanche lerOpcaoLanche() {
        exibirCardapio();
        int opcao = lerOpcao();
        switch (opcao) {
            case 1:
                return LancheFactory.xBurger();
            case 2:
                return LancheFactory.xSalada();
            case 3:
                return LancheFactory.xBacon();
            case 0:
                return null;
            default:
                System.out.println("Opção de lanche inválida!");
                return null;
        }
    }

    public boolean desejaAdicionarMaisItem() {
        System.out.print("Deseja adicionar mais um item? (s/n): ");
        String resposta = sc.nextLine().trim();
        return resposta.equalsIgnoreCase("s");
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        System.out.println("\n--- PEDIDOS DO DIA ---");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado até o momento.");
            return;
        }
        for (Pedido p : pedidos) {
            System.out.println("Pedido #" + p.getId() + " - Cliente: " + p.getNomeCliente());
            System.out.println("Itens:");
            for (ItemCardapio item : p.getItens()) {
                System.out.println("  - " + item.getDescricao() + " (R$ " + String.format("%.2f", item.getPreco()) + ")");
            }
            System.out.println("Total do pedido: R$ " + String.format("%.2f", p.calcularTotal()));
            System.out.println("--------------------------");
        }
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.println("\n=== FECHAMENTO DO DIA ===");
        System.out.println("Total arrecadado hoje: R$ " + String.format("%.2f", total));
        System.out.println("Restaurante fechado. Até amanhã!");
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }
}