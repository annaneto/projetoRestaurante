package org.example.projetoRestaurante.app;

import org.example.projetoRestaurante.cardapio.ItemCardapio;
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
                            ItemCardapio item = menu.lerLanchePersonalizado();
                            if (item != null) {
                                facade.adicionarItemAoPedido(novoPedido.getId(), item);
                                menu.exibirMensagem(item.getDescricao() + " adicionado ao pedido.");
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

                case 3: // Item 3.2: Modificar pedido existente[cite: 1]
                    int idBusca = menu.lerIdPedido();
                    Pedido pExistente = facade.buscarPedido(idBusca);
                    if (pExistente == null) {
                        menu.exibirMensagem("Pedido não encontrado!");
                    } else {
                        menu.exibirDetalhesPedido(pExistente);
                        int opMod = menu.menuModificacaoPedido();
                        if (opMod == 1) {
                            ItemCardapio novoItem = menu.lerLanchePersonalizado();
                            if (novoItem != null) {
                                facade.adicionarItemAoPedido(idBusca, novoItem);
                                menu.exibirMensagem("Item adicionado com sucesso!");
                            }
                        } else if (opMod == 2) {
                            int idx = menu.lerIndiceItemRemover();
                            if (facade.removerItemDoPedido(idBusca, idx)) {
                                menu.exibirMensagem("Item removido com sucesso!");
                            } else {
                                menu.exibirMensagem("Índice de item inválido!");
                            }
                        } else if (opMod == 3) {
                            facade.cancelarPedido(idBusca);
                            menu.exibirMensagem("Pedido #" + idBusca + " cancelado com sucesso!");
                        }
                    }
                    break;

                case 4: // Item 3.3: Fechar restaurante e exibir relatório[cite: 1]
                    double total = facade.calcularTotalDoDia();
                    menu.exibirFechamentoDoDia(total, facade.getCombinacoesUnicas());
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