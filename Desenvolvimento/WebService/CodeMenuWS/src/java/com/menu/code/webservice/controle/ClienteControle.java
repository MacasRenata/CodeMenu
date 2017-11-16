/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Cliente;
import com.menu.code.webservice.persistencia.ClienteDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcio
 */

@RestController
public class ClienteControle {   
    
    
    @Autowired
    ClienteDAO clienteDAO = new ClienteDAO();
    
    @GET
    @Path("/buscaClienteId")
    @RequestMapping(value = "/clientes", method = RequestMethod.GET,headers="Accept=application/json")
    public Cliente buscaClienteId(Cliente cliente) throws Exception{       
        return clienteDAO.carregar(cliente.getId());
    }
    
    @GET
    @Path("/clientes")
    @RequestMapping(value = "/clientes", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Cliente> listaClientes() throws Exception{       
        return clienteDAO.listar();
    }
    
    @POST
    @Path("/adicionaCliente")
    @RequestMapping(value = "/adicionaCliente", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity adicionaCliente(@RequestBody Cliente cliente) throws Exception{
        clienteDAO.salvar(cliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaCliente")
    @RequestMapping(value = "/deletaCliente", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity deletaCliente(@RequestBody Cliente cliente) throws Exception {
        clienteDAO.remover(cliente);
        if (null == clienteDAO) {
            return new ResponseEntity("Não existem clientes registrados com este ID ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/atualizaCliente")
    @RequestMapping(value = "/atualizaCliente", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity atualizaCliente(@RequestBody Cliente cliente) throws Exception {
        clienteDAO.atualizar(cliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }
}