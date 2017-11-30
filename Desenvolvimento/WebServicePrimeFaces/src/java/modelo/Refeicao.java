/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Duda
 */
@Entity
@Table(name = "refeicao")
public class Refeicao implements Serializable  {

    @Id
    @GeneratedValue
    private int id;
    private String nome; 
    @ManyToOne
    
    private double preco;
   
   
    
  
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setLocalChamado(double preco) {
        this.preco = preco;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    
}
    
