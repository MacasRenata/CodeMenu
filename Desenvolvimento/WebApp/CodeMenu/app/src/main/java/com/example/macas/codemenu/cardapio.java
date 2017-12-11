package com.example.macas.codemenu;

import java.io.Serializable;
import java.util.ArrayList;

// MODELO DA ARQUITETURA REST COM OS OBJETOS DA LISTA EM SERIALIZABLE PARA CONVERTER EM STRING PARA O GSON
public class cardapio implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String tipo;
    private double preco;
    private String urlImagem;


    ArrayList<cardapio> ListaCardapio;


    public cardapio() {

        super();
    }

    public cardapio(int id, String nome, String tipo, double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.urlImagem = urlImagem;

    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
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
