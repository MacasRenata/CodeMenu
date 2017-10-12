/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Item;
import com.menu.code.webservice.persistencia.ItemDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marcio
 */
public class ItemControle {
    
    @Autowired
    ItemDAO itemDAO = new ItemDAO();
    
    @GET
    @Path("/itens")
    @RequestMapping(value = "/itens", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Item> getItens() throws Exception{       
        return itemDAO.findAll();        
    }
    
    @POST
    @Path("/adicionaItem")
    @RequestMapping(value = "/adicionaItem", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity geAdicionaCliente(@RequestBody Item item) throws Exception{
        itemDAO.persist(item);
        return new ResponseEntity(item, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaItem")
    @RequestMapping(value = "/deletaItem", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity getDeletaCliente(@PathVariable Long id, @RequestBody Item item) throws Exception {
        itemDAO.remove(item);
        if (null == itemDAO) {
            return new ResponseEntity("Não existem itens registrados com este ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/atualizaItem")
    @RequestMapping(value = "/atualizaItem", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity getAtualizaCliente(@PathVariable Long id, @RequestBody Item item) throws Exception {
        itemDAO.merge(item);             
        return new ResponseEntity(item, HttpStatus.OK);
    }
}
