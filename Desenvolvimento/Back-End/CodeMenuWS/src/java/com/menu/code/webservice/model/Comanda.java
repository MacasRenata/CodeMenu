/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

import com.menu.code.webservice.persistencia.PedidoDAO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora;
    private int status;
    private double valor = 0;
    
    @OneToMany
    private List<Pedido>pedidos;
    PedidoDAO pedidosDAO = new PedidoDAO();
    
    public Comanda(Date hora, int status, double valor) { 
        pedidos = pedidosDAO.listar();
        this.hora = hora;
        this.status = status;
        this.valor = valor;
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
    
    
    
    public void SomaPedidos () {
     for (Pedido pedido : pedidos) {
       if(pedido.getStatus() != 1) // o valor 1 se refere a um pedido que ja foi pago
          valor = valor + pedido.getValor(); // soma tds os pedidos em aberto para gerar valor total da comanda
     }
    }
}
