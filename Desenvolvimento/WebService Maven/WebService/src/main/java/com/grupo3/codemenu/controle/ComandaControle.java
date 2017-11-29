/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.google.gson.Gson;
import com.grupo3.codemenu.modelo.Comanda;
import com.grupo3.codemenu.modelo.Pedido;
import com.grupo3.codemenu.persistencia.ComandaDAO;
import com.grupo3.codemenu.persistencia.PedidoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
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
@Path("comanda")
public class ComandaControle {
    
    @Autowired
    ComandaDAO comandaDAO = new ComandaDAO();       
    
    
    @GET
    @Path("listacomandas")
    @Produces("application/json")
    public List<Comanda> listaComandas() throws Exception{       
        return comandaDAO.listar();
    }
    
    @GET
    @Path("comandaId/{param}")
    @Produces("application/json")
    public Comanda buscaComandaId(@PathParam("param") int id) throws Exception{            
      return comandaDAO.carregar(id);
    }       
    
    @POST
    @Path("addComanda")   
    @Produces("application/json")    
    public Response adicionaComanda(String json) {  
        Gson gson = new Gson();
        Comanda comanda = new Comanda(); 
        comanda = gson.fromJson(json, Comanda.class);    
        comandaDAO.salvar(comanda);      
        return Response.status(Response.Status.OK).build();              
    }         
    
    @PUT
    @Path("updateComanda")
    @Produces("application/json")
    public Response atualizaComanda(String json) throws Exception {
        Gson gson = new Gson();
        Comanda comanda= new Comanda(); 
        comanda = gson.fromJson(json, Comanda.class); 
        comanda.setValor(somaPedidos(comanda));
        comandaDAO.atualizar(comanda);
        return Response.status(Response.Status.OK).build();  
    }    
   
    
    private double somaPedidos (Comanda comanda) {  
        PedidoDAO pedidosDao = new PedidoDAO();
        List<Pedido> pedidos = pedidosDao.listarPorComanda(comanda.getId());
        double valor = 0;
        for (Pedido pedido : pedidos) {
            if(pedido.getStatus() !=5){
                valor = valor + pedido.getValor(); 
            }
        }
        return valor;
    }    
}
