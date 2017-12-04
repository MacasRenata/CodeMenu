package com.example.macas.codemenu;

import java.util.ArrayList;


public class cardapio {

    private Long id;
    private String nome;
    private String tipo;
    private double preco;
    private String urlImagem;

    MainActivityMenu context;
    private String newCardapio;
    ArrayList<cardapio> ListaCardapio;


    public cardapio(){
        super();
    }

    public cardapio(Long id, String nome, String tipo, double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.urlImagem = urlImagem;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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
