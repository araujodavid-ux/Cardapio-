package cardapioRestaurante;

import java.util.ArrayList;

public class No {
    String nome;
    Double preco; // null = categoria
    ArrayList<No> filhos; // usando apenas ArrayList

    public No(String nome) {
        this.nome = nome;
        this.preco = null;
        this.filhos = new ArrayList<>();
    }

    public No(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.filhos = new ArrayList<>();
    }

    public void adicionarFilho(No filho) {
        filhos.add(filho);
    }

    public boolean ehCategoria() {
        return preco == null;
    }
}


