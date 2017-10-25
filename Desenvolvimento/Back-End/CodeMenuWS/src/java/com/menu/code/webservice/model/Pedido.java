/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Marcio
 */

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    private int status;
    private double valor;
    private int quantidade;
    @OneToOne
    @JoinColumn(name ="id_cliente")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name ="id_mesa")
    private Mesa mesa;    
    @ManyToOne
    @JoinColumn(name ="id_item")
    private Item[] itens;    
    @OneToOne
    @JoinColumn(name ="id_comanda")
    private Comanda comanda;  

    public Pedido(Long id, Date data, int status, double valor, int quantidade, Cliente cliente, Mesa mesa, Item[] itens, Comanda comanda) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.mesa = mesa;
        this.itens = itens;
        this.comanda = comanda;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }
      
}
