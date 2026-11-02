package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.Lanche;
import org.example.projetoRestaurante.pedido.Pedido;

public class Main {
    static void main() {
        RestauranteFacade facade = new RestauranteFacade();
        MenuConsole menu = new MenuConsole();
        int opcao = -1;

        do {
            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {
                case 1:
                    String nomeCliente = menu.lerNomeCliente();
                    try {
                        Pedido novoPedido = facade.criarPedido(nomeCliente);
                        menu.exibirMensagem("Pedido #" + novoPedido.getId() + " registrado!");

                        boolean continuar = true;
                        while (continuar) {
                            Lanche lanche = menu.lerOpcaoLanche();
                            if (lanche != null) {
                                // Instância nova a cada escolha
                                facade.adicionarItemPedido(novoPedido.getId(), lanche);
                                menu.exibirMensagem(lanche.getNome() + " adicionado ao pedido.");
                                continuar = menu.desejaAdicionarMaisItem();
                            } else {
                                continuar = false;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        menu.exibirMensagem("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    menu.exibirPedidos(facade.getPedidos());
                    break;

                case 3:
                    double total = facade.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total);
                    opcao = 0;
                    break;

                case 0:
                    menu.exibirMensagem("Encerrando o sistema...");
                    break;

                default:
                    menu.exibirMensagem("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}