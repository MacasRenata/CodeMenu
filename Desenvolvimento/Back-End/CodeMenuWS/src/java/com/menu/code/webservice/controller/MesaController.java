/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controller;

import com.menu.code.webservice.model.Mesa;
import com.menu.code.webservice.persistence.MesaDAO;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcio
 */
@RestController
public class MesaController {
    
    @Autowired
    private MesaDAO mesaDAO;
    
    @POST
    @Path("inserir")
    @Produces(MediaType.APPLICATION_JSON)	
    //@PostMapping(value = "Cliente")
    public ResponseEntity adicionaMesa(@RequestBody Mesa mesa) throws Exception{       
        //String reader = null;
        //Cliente cliente = gson.fromJson(reader, Cliente.class);
        mesaDAO.inserir(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }    
}
