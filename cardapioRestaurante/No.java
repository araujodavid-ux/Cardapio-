package cardapioRestaurante;

import java.util.ArrayList;

public class No {
    String nome;
    Double preco; 
    ArrayList<No> filhos; 

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



