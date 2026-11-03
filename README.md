# Sistema de Restaurante em Java

Esse projeto foi desenvolvido como parte de uma atividade prática do curso da SoulCode ElasTech. A ideia foi simular o sistema de um restaurante: abrir comandas, escolher lanches, customizar ingredientes, colocar adicionais e fechar o caixa no fim do expediente.

---

## Funcionalidades

* **Faz pedidos do zero:** Gera o número da comanda automaticamente e associa ao nome do cliente.
* **Cardápio base:** Criação rápida dos lanches padrão (X-Burger, X-Salada e X-Bacon).
* **Personalização de ingredientes:** O cliente pode pedir para tirar ingredientes (queijo, alface, tomate ou cebola). Isso altera a descrição do item ("sem cebola"), mas não mexe no preço base.
* **Adicionais:** Adiciona opções pagas (+ cheddar, + bacon extra) que somam ao valor final e atualizam a descrição.
* **Edição de comandas:** Permite buscar um pedido pelo número para acrescentar itens, tirar itens ou cancelar a comanda inteira (sem somar pedidos cancelados no faturamento do dia).
* **Fechamento do dia:** Mostra o total arrecadado e usa um `HashSet` para listar todas as combinações únicas que saíram durante o dia (sem repetições).
* **Menu sem travamento:** Toda a leitura do teclado no console conta com tratamento para entradas inválidas (como digitar letras onde se espera números), impedindo que o programa trave em loop infinito.

---

## Organização

responsabilidades bem divididas entre as classes e pacotes:

* `app`: O `Main` serve apenas para iniciar a aplicação. Toda a interação com quem está usando (perguntas e mensagens) fica dentro de `MenuConsole`. As operações de negócio são orquestradas pela `RestauranteFacade`.
* `cardapio`: Contém a interface `ItemCardapio`, a classe `Lanche`, a fábrica e os adicionais.
* `pedido`: Guarda a classe `Pedido` (comanda individual) e a `GerenciadorPedidos`, que gerencia o `HashMap` com todas as comandas do dia.
* `financeiro`: Pacote reservado para possíveis extensões de controle de caixa e transações.

### Padrões de projeto 

* **Factory Method (`LancheFactory`):** Criada para encapsular a criação dos lanches padrão, garantindo que cada item novo seja um objeto independente na memória (assim, personalizar um lanche não afeta o de outro cliente).
* **Decorator (`AdicionalDecorator`, `ComCheddar`, `ComBaconExtra`):** Usado para "embrulhar" qualquer `ItemCardapio`. O adicional acrescenta seu próprio preço e seu texto na descrição delegando o restante para o item original, sem precisar mexer na classe `Lanche`.
* **Facade (`RestauranteFacade`):** Junta as chamadas do sistema em um lugar só para que a interface de console não precise conhecer os detalhes internos de cada classe.

---


## Link do Vídeo de Apresentação

https://youtu.be/Jueuw4yPYgk

