/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Mesa;
import com.menu.code.webservice.persistencia.MesaDAO;
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

/**
 *
 * @author Marcio
 */
public class MesaControle {
    
    @Autowired
    MesaDAO mesaDAO = new MesaDAO();
    
    @GET
    @Path("/buscaMesaId")
    @RequestMapping(value = "/buscaMesaId", method = RequestMethod.GET,headers="Accept=application/json")
    public Mesa buscaMesaId(Mesa mesa) throws Exception{       
        return mesaDAO.carregar(mesa.getId());
    }
    
    @GET
    @Path("/listaMesas")
    @RequestMapping(value = "/listaMesas", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Mesa> listaMesas() throws Exception{       
        return mesaDAO.listar();
    }
    
    @POST
    @Path("/adicionaMesa")
    @RequestMapping(value = "/adicionaMesa", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity adicionaMesa(@RequestBody Mesa mesa) throws Exception{
        mesaDAO.salvar(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaMesa")
    @RequestMapping(value = "/deletaMesa", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity deletaMesa(@RequestBody Mesa mesa) throws Exception {
        mesaDAO.remover(mesa);
        if (null == mesaDAO) {
            return new ResponseEntity("Não existem mesas registradas com este ID ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/atualizaMesa")
    @RequestMapping(value = "/atualizaMesa", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity atualizaMesa(@RequestBody Mesa mesa) throws Exception {
        mesaDAO.atualizar(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }
}
