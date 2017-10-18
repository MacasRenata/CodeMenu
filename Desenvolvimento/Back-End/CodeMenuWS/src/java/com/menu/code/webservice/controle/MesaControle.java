/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Mesa;
import com.menu.code.webservice.persistence.MesaDAO;
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
public class MesaControle {
    
    @Autowired
    MesaDAO mesaDAO = new MesaDAO();
    
    @GET
    @Path("/mesas")
    @RequestMapping(value = "/mesas", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Mesa> getMesaId(Mesa mesa) throws Exception{       
        return mesaDAO.buscar(mesa);        
    }
    
    @GET
    @Path("/mesas")
    @RequestMapping(value = "/mesas", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Mesa> getListaMesas() throws Exception{       
        return mesaDAO.buscarTudo();
    }
    
    @POST
    @Path("/adicionaMesa")
    @RequestMapping(value = "/adicionaMesa", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity getAdicionaMesa(@RequestBody Mesa mesa) throws Exception{
        mesaDAO.inserir(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaMesa")
    @RequestMapping(value = "/deletaMesa", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity getDeletaMesa(@RequestBody Mesa mesa) throws Exception {
        mesaDAO.deletar(mesa);
        if (null == mesaDAO) {
            return new ResponseEntity("Não existem mesas registradas com este ID ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/atualizaMesa")
    @RequestMapping(value = "/atualizaMesa", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity getAtualizaMesa(@RequestBody Mesa mesa) throws Exception {
        mesaDAO.atualizar(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }
}
