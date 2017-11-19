/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.grupo3.codemenu.modelo.Mesa;
import com.grupo3.codemenu.persistencia.MesaDAO;
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
@Path("/mesa")
public class MesaControle {
    
    @Autowired
    MesaDAO mesaDAO = new MesaDAO();
    
    @GET
    @Path("/mesaId")
    @Produces("application/json")
    public Mesa buscaMesaId(Mesa mesa) throws Exception{       
        return mesaDAO.carregar(mesa.getId());
    }    
    
    @GET
    @Path("/listaMesas")
    @Produces("application/json")
    public List<Mesa> listaMesas() throws Exception{       
        return mesaDAO.listar();
    }       
    
    @POST
    @Path("/addMesa")
    @Consumes("application/json")
    public ResponseEntity adicionaMesa(@RequestBody Mesa mesa) throws Exception{
        mesaDAO.salvar(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }      
   
    @DELETE
    @Path("/deletaMesa")
    @Consumes("application/json")
    public ResponseEntity deletaMesa(@RequestBody Mesa mesa) throws Exception {
        mesaDAO.remover(mesa);                        
        return new ResponseEntity(mesa,HttpStatus.OK);             
    }        
   
    @PUT
    @Path("/updateMesa")
    @Consumes("application/json")
    public ResponseEntity atualizaMesa(@RequestBody Mesa mesa) throws Exception {
        mesaDAO.atualizar(mesa);
        return new ResponseEntity(mesa, HttpStatus.OK);
    }
}
