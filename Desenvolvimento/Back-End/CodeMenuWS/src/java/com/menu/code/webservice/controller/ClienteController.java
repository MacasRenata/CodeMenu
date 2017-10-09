/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controller;

import com.menu.code.webservice.model.Cliente;
import com.menu.code.webservice.persistence.ClienteDAO;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcio
 */
@RestController
public class ClienteController {
    
    @Autowired
    private ClienteDAO clienteDAO;
    
    @POST
    @Path("inserir")
    @Produces(MediaType.APPLICATION_JSON)	
    //@PostMapping(value = "Cliente")
    public ResponseEntity adicionaCliente(@RequestBody Cliente cliente) throws Exception{       
        clienteDAO.inserir(cliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }
    
    @DELETE
    @Path("deletar")
    @Produces(MediaType.APPLICATION_JSON)	
    //@DeleteMapping(value = "Cliente")
    public ResponseEntity deletaCliente(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {        
        clienteDAO.deletar(cliente);
        if (null == clienteDAO) {
            return new ResponseEntity("Não existem clientes registrados com este ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }   
    
    @PUT
    @Path("atualizar")
    @Produces(MediaType.APPLICATION_JSON)	
    //@GetMapping("/Cliente")
    public ResponseEntity atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {
        clienteDAO.atualizar(cliente);       
        return new ResponseEntity(cliente, HttpStatus.OK);
    }      
    
}
