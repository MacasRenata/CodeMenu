/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

/**
 *
 * @author anderson
 */


public class Cliente {

public Long id;
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