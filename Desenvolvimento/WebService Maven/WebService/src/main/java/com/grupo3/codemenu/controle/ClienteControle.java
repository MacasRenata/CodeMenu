/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.google.gson.Gson;
import com.grupo3.codemenu.modelo.Cliente;
import com.grupo3.codemenu.persistencia.ClienteDAO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Path("addCliente")   
    @Produces("application/json")    
    public Response AdicionaCliente(String json) {  
        Gson gson = new Gson();
        Cliente cliente= new Cliente(); 
        cliente = gson.fromJson(json, Cliente.class);
        Cliente clienteBanco = clienteDAO.consultaPorTelefone(cliente.getTelefone());
        if(clienteBanco == null){
           clienteDAO.salvar(cliente);      
           return Response.status(Response.Status.OK).build();   
        }
        return Response.status(Response.Status.NO_CONTENT).build();             
    }
    
    @PUT
    @Path("updateCliente")    
    @Produces("application/json") 
    public Response atualizaCliente(String json) throws Exception {
        Gson gson = new Gson(); 
        Cliente cliente= new Cliente(); 
        cliente = gson.fromJson(json, Cliente.class);
        Cliente clienteBanco = clienteDAO.carregar(cliente.getId());
        Cliente clienteBanco2 = clienteDAO.consultaPorTelefone(cliente.getTelefone());
        if(clienteBanco != null && clienteBanco2 == null){
            clienteDAO.atualizar(cliente);
            return Response.status(Response.Status.OK).build();  
        }else{
            return Response.status(Response.Status.NO_CONTENT).build();
        }            
    }      
}
