package cardapioRestaurante;

import java.util.Scanner;

public class CardapioInterativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cardapio cardapio = new Cardapio("Cardápio do Restaurante");

        // Categorias principais
        No entradas = cardapio.adicionarCategoria(cardapio.raiz, "Entradas");
        No pratosPrincipais = cardapio.adicionarCategoria(cardapio.raiz, "Pratos Principais");
        No doces = cardapio.adicionarCategoria(cardapio.raiz, "Doces");
        No bebidas = cardapio.adicionarCategoria(cardapio.raiz, "Bebidas");

        // Subcategorias de pratos principais
        No massas = cardapio.adicionarCategoria(pratosPrincipais, "Massas");
        No carnes = cardapio.adicionarCategoria(pratosPrincipais, "Carnes");
        No lanches = cardapio.adicionarCategoria(pratosPrincipais, "Lanches");

        // Subcategorias de bebidas
        No refrigerantes = cardapio.adicionarCategoria(bebidas, "Refrigerantes");
        No sucos = cardapio.adicionarCategoria(bebidas, "Sucos");
        No cafes = cardapio.adicionarCategoria(bebidas, "Cafés");

        // Itens iniciais
        cardapio.adicionarItem(entradas, "Batata Frita", 14.00);
        cardapio.adicionarItem(entradas, "Queijo e Presunto Defumado", 12.00);

        cardapio.adicionarItem(massas, "Lasanha", 25.00);
        cardapio.adicionarItem(massas, "Espaguete à Bolonhesa", 23.00);

        cardapio.adicionarItem(carnes, "Picanha", 40.00);
        cardapio.adicionarItem(carnes, "Frango Grelhado", 28.00);

        cardapio.adicionarItem(lanches, "Hambúrguer", 18.00);
        cardapio.adicionarItem(lanches, "Cachorro-Quente", 15.00);

        cardapio.adicionarItem(doces, "Pudim", 9.00);
        cardapio.adicionarItem(doces, "Mousse de Chocolate", 10.00);
        cardapio.adicionarItem(doces, "Torta de Limão", 11.00);

        cardapio.adicionarItem(refrigerantes, "Coca-Cola", 7.00);
        cardapio.adicionarItem(refrigerantes, "Guaraná", 6.50);

        cardapio.adicionarItem(sucos, "Suco de Laranja", 8.00);
        cardapio.adicionarItem(sucos, "Suco de Uva", 8.50);

        cardapio.adicionarItem(cafes, "Café Expresso", 5.00);
        cardapio.adicionarItem(cafes, "Cappuccino", 7.50);

        int opcao;
        do {
            System.out.println("\n=== MENU DO SISTEMA ===");
            System.out.println("1. Mostrar cardápio completo");
            System.out.println("2. Buscar item por nome");
            System.out.println("3. Adicionar nova categoria");
            System.out.println("4. Adicionar novo item");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CARDÁPIO COMPLETO ===");
                    cardapio.exibirCardapio();
                    break;

                case 2:
                    System.out.print("\nDigite o nome do item a buscar: ");
                    String nomeBusca = sc.nextLine();
                    No item = cardapio.buscarItem(nomeBusca);
                    if (item != null)
                        System.out.printf("Item encontrado: %s (R$ %.2f)%n", item.nome, item.preco);
                    else
                        System.out.println("Item não encontrado.");
                    break;

                case 3:
                    System.out.print("\nDigite o nome da categoria pai: ");
                    String nomePai = sc.nextLine();
                    No pai = cardapio.buscarCategoria(nomePai);
                    if (pai != null) {
                        System.out.print("Digite o nome da nova categoria: ");
                        String novaCat = sc.nextLine();
                        cardapio.adicionarCategoria(pai, novaCat);
                        System.out.println("Categoria adicionada com sucesso!");
                    } else {
                        System.out.println("Categoria pai não encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("\nDigite o nome da categoria onde o item será adicionado: ");
                    String nomeCat = sc.nextLine();
                    No categoria = cardapio.buscarCategoria(nomeCat);
                    if (categoria != null) {
                        System.out.print("Nome do item: ");
                        String nomeItem = sc.nextLine();
                        System.out.print("Preço do item: ");
                        double preco = sc.nextDouble();
                        sc.nextLine();
                        cardapio.adicionarItem(categoria, nomeItem, preco);
                        System.out.println("Item adicionado com sucesso!");
                    } else {
                        System.out.println("Categoria não encontrada!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}

