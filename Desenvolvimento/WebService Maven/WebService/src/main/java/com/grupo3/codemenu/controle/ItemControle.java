/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.google.gson.Gson;
import com.grupo3.codemenu.modelo.Item;
import com.grupo3.codemenu.persistencia.ItemDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcio
 */
@RestController
@Path("item")
public class ItemControle {
    
    @Autowired
    ItemDAO itemDAO = new ItemDAO();
    
    @GET
    @Path("listaItens")
    @Produces("application/json")
    public List<Item> listaItens() throws Exception{       
        return itemDAO.listar();
    }
    
    @GET
    @Path("itemId/{param}")
    @Produces("application/json")
    public Item buscaItemId(@PathParam("param") int id) throws Exception{              
         return itemDAO.carregar(id);
    }         
    
    
    @POST
    @Path("addItem")
    @Produces("application/json")    
    public Response adicionaItem(String json) throws Exception{
        Gson gson = new Gson();
        Item item = new Item();
        item = gson.fromJson(json, Item.class);
        itemDAO.salvar(item);
        return Response.status(Response.Status.OK).build();  
    }        
    
    @DELETE
    @Path("deletaItem/{param}")
    @Produces("application/json")    
    public Response deletaItem(@PathParam("param") int id) throws Exception {
        Item item = new Item();
        item.setId(id);
        itemDAO.remover(item);        
        return Response.status(Response.Status.OK).build();             
    }        
    
    @PUT
    @Path("updateItem")
    @Consumes("application/json")
    public ResponseEntity atualizaItem(String json) throws Exception {
        Gson gson = new Gson();
        Item item = new Item();
        item = gson.fromJson(json, Item.class);
        itemDAO.atualizar(item);             
        return new ResponseEntity(item, HttpStatus.OK);
    }    
  
}
