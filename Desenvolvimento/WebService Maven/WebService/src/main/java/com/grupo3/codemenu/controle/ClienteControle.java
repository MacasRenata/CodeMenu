/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.grupo3.codemenu.modelo.Cliente;
import com.grupo3.codemenu.persistencia.ClienteDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
@Path("cliente")
public class ClienteControle {   
    
    
    @Autowired
    ClienteDAO clienteDAO = new ClienteDAO();     
    
    @GET
    @Path("listaCliente")
    @Produces("application/json")
    public List<Cliente> listaClientes() throws Exception{        
        return clienteDAO.listar();        
    }            
  
    @GET
    @Path("clienteId/{param}")
    @Produces("application/json")
    public Cliente buscaClienteId(@PathParam("param") int id) throws Exception{       
        return clienteDAO.carregar(id);
    }       
    
    @POST
    @Path("/addCliente")
    @Consumes("application/json")
    public ResponseEntity adicionaCliente(@RequestBody Cliente cliente) throws Exception{      
        Cliente clienteBanco = clienteDAO.consultaPorTelefone(cliente.getTelefone()); 
        if(clienteBanco == null){
            clienteDAO.salvar(cliente);
            new ResponseEntity(cliente, HttpStatus.OK);
        }              
        return new ResponseEntity(cliente, HttpStatus.NOT_FOUND);
    }  
    
    @PUT
    @Path("/updateCliente")
    @Consumes("application/json")
    public ResponseEntity atualizaCliente(@RequestBody Cliente cliente) throws Exception {
        clienteDAO.atualizar(cliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }      
}
