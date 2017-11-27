/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.google.gson.Gson;
import com.grupo3.codemenu.modelo.Cliente;
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
    @Path("addEstab")
    @Produces("application/json")
    public Response adicionaEstabelecimento(String json) throws Exception{
        Gson gson = new Gson();
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento = gson.fromJson(json, Estabelecimento.class);
        estabelecimentoDAO.salvar(estabelecimento);
        return Response.status(Response.Status.OK).build();   
    }  
    
    @DELETE
    @Path("deletaEstab/{param}")
    @Produces("application/json")
    public Response deletaEstabelecimento(@PathParam("param") int id) throws Exception {        
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(id);      
        estabelecimentoDAO.remover(estabelecimento);        
        return Response.status(Response.Status.OK).build();          
    }  
    
    @PUT
    @Path("updateEstab")
    @Consumes("application/json")
    public Response atualizaEstabelecimento(String json) throws Exception {
        Gson gson = new Gson(); 
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento = gson.fromJson(json, Estabelecimento.class);
        estabelecimentoDAO.atualizar(estabelecimento);
        return Response.status(Response.Status.OK).build();   
    }
}
