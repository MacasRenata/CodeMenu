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
    private Item item;    
        

    public Pedido(Long id, Date data, int status, double valor, int quantidade, Cliente cliente, Mesa mesa, Item item) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.valor = valor;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.mesa = mesa;
        this.item = item;
    }

    public Pedido() {
        
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

    public Item getItem() { 
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getClienteId() {
        return cliente.getId();
    }
    
    public Long getMesaId() {
        return mesa.getId();
    }
    
    public Long getItemId() {
        return item.getId();
    }
    
    public void setCliente(Long cliente_id) {
            this.cliente.setId(cliente_id);
    }
    
    public void setMesa(Long mesa_id) {
            this.mesa.setId(mesa_id);
    } 
    
    public void setItem(Long item_id) {
            this.item.setId(item_id);
    } 
}
