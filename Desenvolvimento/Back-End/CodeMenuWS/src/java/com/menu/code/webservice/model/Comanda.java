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
    private double valor;
    
    @OneToMany
    private List<Pedido>pedidos;
    PedidoDAO pedidosDAO = new PedidoDAO();

    public Comanda(Long id, Date hora, int status, double valor, List<Pedido> pedidos) {
        this.id = id;
        this.hora = hora;
        this.status = status;
        this.valor = valor;
        this.pedidos = pedidosDAO.listar();
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

  
    
    
    
    
}
