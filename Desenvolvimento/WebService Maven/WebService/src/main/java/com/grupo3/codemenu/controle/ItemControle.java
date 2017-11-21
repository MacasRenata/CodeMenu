/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.grupo3.codemenu.modelo.Item;
import com.grupo3.codemenu.persistencia.ItemDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
@Path("/Item")
public class ItemControle {
    
    @Autowired
    ItemDAO itemDAO = new ItemDAO();
    
    @GET
    @Path("/itemId")
    @Produces("application/json")
    public Item buscaItemId(Item item) throws Exception{              
         return itemDAO.carregar(item.getId());
    }
    
    /*@GET
    @Path("/itens")
    @RequestMapping(value = "/itens", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Item> getItemTipo(Item item) throws Exception{       
        return itemDAO.buscarPorTipo(item);
    }*/
    
    @GET
    @Path("/listaItens")
    @Produces("application/json")
    public List<Item> listaItens() throws Exception{       
        return itemDAO.listar();
    }
    
    @POST
    @Path("/addItem")
    @Consumes("application/json")
    public ResponseEntity adicionaItem(@RequestBody Item item) throws Exception{
        itemDAO.salvar(item);
        return new ResponseEntity(item, HttpStatus.OK);
    }        
    
    @DELETE
    @Path("/deletaItem")
    @Consumes("application/json")
    public ResponseEntity deletaItem(@RequestBody Item item) throws Exception {
        itemDAO.remover(item);        
        return new ResponseEntity(item, HttpStatus.OK);             
    }        
    
    @PUT
    @Path("/updateItem")
    @Consumes("application/json")
    public ResponseEntity atualizaItem(@RequestBody Item item) throws Exception {
        itemDAO.atualizar(item);             
        return new ResponseEntity(item, HttpStatus.OK);
    }    
  
}
