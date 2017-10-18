/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author anderson
 */

@Entity
@Table(name="cliente")
public class Cliente implements Serializable { 
@Id
@GeneratedValue
private Long id;
private String telefone;    

    public Cliente(long id, String telefone) {
        this.id = id;
        this.telefone = telefone;
    }
    
    public Cliente() {
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	
}