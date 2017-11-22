/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.grupo3.codemenu.modelo.Estabelecimento;
import com.grupo3.codemenu.persistencia.EstabelecimentoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("estab")
public class EstabelecimentoControle {
    
    @Autowired
    EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
    
    @GET
    @Path("listaEstabs")
    @Produces("application/json")
    public List<Estabelecimento> listaEstabelecimentos() throws Exception{       
        return estabelecimentoDAO.listar();
    }
    
    @GET
    @Path("estabId/{param}")
    @Produces("application/json")
    public Estabelecimento buscaEstabelecimentoId(@PathParam("param") int id) throws Exception{       
        return estabelecimentoDAO.carregar(id);
    }        
    
    @POST
    @Path("/addEstab")
    @Consumes("application/json")
    public ResponseEntity adicionaEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception{
        estabelecimentoDAO.salvar(estabelecimento);
        return new ResponseEntity(estabelecimento, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaEstab")
    @Consumes("application/json")
    public ResponseEntity deletaEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception {
        estabelecimentoDAO.remover(estabelecimento);        
        return new ResponseEntity(estabelecimento,HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/updatEstab")
    @Consumes("application/json")
    public ResponseEntity atualizaEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception {
        estabelecimentoDAO.atualizar(estabelecimento);
        return new ResponseEntity(estabelecimento, HttpStatus.OK);
    }
}
