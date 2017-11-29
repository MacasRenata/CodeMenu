/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.google.gson.Gson;
import com.grupo3.codemenu.modelo.Estabelecimento;
import com.grupo3.codemenu.modelo.Mesa;
import com.grupo3.codemenu.persistencia.MesaDAO;
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
@Path("mesa")
public class MesaControle {
    
    @Autowired
    MesaDAO mesaDAO = new MesaDAO();
    
    @GET
    @Path("listaMesas")
    @Produces("application/json")
    public List<Mesa> listaMesas() throws Exception{       
        return mesaDAO.listar();
    }       
    
    @GET
    @Path("mesaId/{param}")
    @Produces("application/json")
    public Mesa buscaMesaId(@PathParam("param") int id) throws Exception{       
        return mesaDAO.carregar(id);
    }            
    
    @POST
    @Path("addMesa")
    @Produces("application/json")
    public Response adicionaMesa(String json) throws Exception{
        Gson gson = new Gson();
        Mesa mesa = new Mesa();
        mesa = gson.fromJson(json, Mesa.class);
        Mesa mesaBanco = mesaDAO.consultaPorMesaEstab(mesa.getIdentificacao(),
                                 mesa.getEstabelecimento().getId());
        if(mesaBanco != null){
                return Response.status(Response.Status.NO_CONTENT).build();
               
       }else{
            mesaDAO.salvar(mesa);
           return Response.status(Response.Status.OK).build();  
           
       }          
    }      
   
    @DELETE
    @Path("deletaMesa/{param}")
    @Produces("application/json")
    public Response deletaMesa(@PathParam("param") int id) throws Exception {
        Mesa mesa = new Mesa();
        mesa.setId(id);
        mesaDAO.remover(mesa);                        
        return Response.status(Response.Status.OK).build();                      
    }        
   
    @PUT
    @Path("updateMesa")
    @Produces("application/json")
    public Response atualizaMesa(String json) throws Exception {
        Gson gson = new Gson();
        Mesa mesa = new Mesa();
        mesa = gson.fromJson(json, Mesa.class);
        Mesa mesaBanco = mesaDAO.carregar(mesa.getId());         
        if(mesaBanco != null){
            mesaDAO.atualizar(mesa);
            return Response.status(Response.Status.OK).build();   
        }else{
            return Response.status(Response.Status.NO_CONTENT).build();
        }                        
    }
}
