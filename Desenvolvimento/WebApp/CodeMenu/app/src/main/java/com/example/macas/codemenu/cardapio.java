package com.example.macas.codemenu;

/**
 * Created by macas on 19/11/17.
 */

public class cardapio {

    private Long id;
    private String nome;
    private int tipo;
    private double preco;
    private String urlImagem;


    public cardapio(){
        super();
    }

    public cardapio(Long id, String nome, int tipo, double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.urlImagem = urlImagem;

        //necessario fazer o filtro posteriormente
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }


}
