package com.example.macas.codemenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macas on 19/11/17.
 */

public class pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date data;
    private int status;
    private double valor;
    private int quantidade;

    ArrayList<pedido> ListaPedido;


    public pedido(){
        super();
    }


    public pedido(Long id, Date data, double valor, int quantidade) {
        this.id = id;
        this.data = data;
        status = 1;
        this.valor = valor;
        this.quantidade = quantidade;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int sta) {
        if(sta < 2)
            status = sta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
