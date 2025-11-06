package cardapioRestaurante;

import java.util.*;

public class Cardapio {
    No raiz;

    public Cardapio(String nome) {
        raiz = new No(nome);
    }

    public No adicionarCategoria(No pai, String nome) {
        No novaCategoria = new No(nome);
        pai.adicionarFilho(novaCategoria);
        return novaCategoria;
    }

    public void adicionarItem(No categoria, String nome, double preco) {
        categoria.adicionarFilho(new No(nome, preco));
    }

    public void exibirCardapio() {
        exibirRecursivo(raiz, 0);
    }

    private void exibirRecursivo(No no, int nivel) {
        for (int i = 0; i < nivel; i++) System.out.print("   ");
        if (no.ehCategoria()) {
            System.out.println("[" + no.nome + "]");
        } else {
            System.out.printf("- %s (R$ %.2f)%n", no.nome, no.preco);
        }
        for (No filho : no.filhos) {
            exibirRecursivo(filho, nivel + 1);
        }
    }

    public No buscarItem(String nome) {
        return buscarItemRec(raiz, nome);
    }

    private No buscarItemRec(No no, String nome) {
        if (no.nome.equalsIgnoreCase(nome) && !no.ehCategoria()) {
            return no;
        }
        for (No filho : no.filhos) {
            No encontrado = buscarItemRec(filho, nome);
            if (encontrado != null)
                return encontrado;
        }
        return null;
    }

    public No buscarCategoria(String nome) {
        return buscarCategoriaRec(raiz, nome);
    }

    private No buscarCategoriaRec(No no, String nome) {
        if (no.nome.equalsIgnoreCase(nome) && no.ehCategoria()) {
            return no;
        }
        for (No filho : no.filhos) {
            No encontrado = buscarCategoriaRec(filho, nome);
            if (encontrado != null)
                return encontrado;
        }
        return null;
    }
}

