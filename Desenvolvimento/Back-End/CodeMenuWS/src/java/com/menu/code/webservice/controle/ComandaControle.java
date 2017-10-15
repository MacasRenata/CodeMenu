/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Comanda;
import com.menu.code.webservice.persistence.ComandaDAO;
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
public class ComandaControle {
    
    @Autowired
    ComandaDAO comandaDAO = new ComandaDAO();
    
    @GET
    @Path("/comandas")
    @RequestMapping(value = "/comandas", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Comanda> getComandaId(Comanda comanda) throws Exception{       
        return comandaDAO.buscar(comanda);
    }
    
    @GET
    @Path("/comandas")
    @RequestMapping(value = "/comandas", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Comanda> getListaComandas() throws Exception{       
        return comandaDAO.buscarTudo();
    }
    
    @POST
    @Path("/adicionaComanda")
    @RequestMapping(value = "/adicionaComanda", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity getAdicionaComanda(@RequestBody Comanda comanda) throws Exception{
        comandaDAO.inserir(comanda);
        return new ResponseEntity(comanda, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaComanda")
    @RequestMapping(value = "/deletaComanda", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity getDeletaComanda(@RequestBody Comanda comanda) throws Exception {
        comandaDAO.deletar(comanda);
        if (null == comandaDAO) {
            return new ResponseEntity("Não existem comandas registradas com este ID ",  HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);             
    } 
    
    @PUT
    @Path("/atualizaComanda")
    @RequestMapping(value = "/atualizaComanda", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity getAtualizaComanda(@RequestBody Comanda comanda) throws Exception {
        comandaDAO.atualizar(comanda);
        return new ResponseEntity(comanda, HttpStatus.OK);
    }
}
