/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

import java.util.Date;

/**
 *
 * @author Marcio
 */
public class Pedidos {
    private long id;
    private Date data;
    private int status;
    private double valor;
    private int quantidade;
    private Cliente cliente_id;
    private Mesa mesa_id;    
    private Item item_id;    
    private Comanda comanda_id;    

    public Pedidos(long id, Date data, int status, double valor, int quantidade, Cliente cliente_id, Mesa mesa_id, Item item_id, Comanda comanda_id) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.quantidade = quantidade;
        this.cliente_id = cliente_id;
        this.mesa_id = mesa_id;
        this.item_id = item_id;
        this.comanda_id = comanda_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setStatus(int status) {
        this.status = status;
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

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Mesa getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(Mesa mesa_id) {
        this.mesa_id = mesa_id;
    }

    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    public Comanda getComanda_id() {
        return comanda_id;
    }

    public void setComanda_id(Comanda comanda_id) {
        this.comanda_id = comanda_id;
    }    
}
