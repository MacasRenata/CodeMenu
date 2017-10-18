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
import javax.persistence.Table;

/**
 *
 * @author Marcio
 */

@Entity
@Table(name="comanda")
public class Comanda implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Date hora;
    private int status;
    private double valor;
    private Pedido pedido;

    public Comanda(long id, Date hora, int status, double valor, Pedido pedido) {
        this.id = id;
        this.hora = hora;
        this.status = status;
        this.valor = valor;
        this.pedido = pedido;
    }
    
    public Comanda() {
        
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public Long getPedidoId() {
        return pedido.getId();
    }
    
    public void setPedido(Long pedido_id) {
            this.pedido.setId(pedido_id);
    }
}
