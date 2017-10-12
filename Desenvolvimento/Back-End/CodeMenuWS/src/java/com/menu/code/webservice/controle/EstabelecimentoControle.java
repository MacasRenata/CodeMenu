/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Estabelecimento;
import com.menu.code.webservice.persistencia.EstabelecimentoDAO;
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
public class EstabelecimentoControle {
    
    @Autowired
    EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAO();
    
    @GET
    @Path("/estabelecimentos")
    @RequestMapping(value = "/estabelecimentos", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Estabelecimento> getEstabelecimentos() throws Exception{       
        return estabelecimentoDAO.findAll();        
    }
    
    @POST
    @Path("/adicionaEstabelecimentos")
    @RequestMapping(value = "/adicionaEstabelecimentos", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity geAdicionaCliente(@RequestBody Estabelecimento estabelecimento) throws Exception{
        estabelecimentoDAO.persist(estabelecimento);
        return new ResponseEntity(estabelecimento, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaEstabelecimento")
    @RequestMapping(value = "/deletaCliente", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity getDeletaEstabelecimento(@PathVariable Long id, @RequestBody Estabelecimento estabelecimento) throws Exception {
        estabelecimentoDAO.remove(estabelecimento);
        if (null == estabelecimentoDAO) {
            return new ResponseEntity("Não existem estabelecimentos registrados com este ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/atualizaEstabelecimento")
    @RequestMapping(value = "/atualizaEstabelecimento", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity getAtualizaCliente(@PathVariable Long id, @RequestBody Estabelecimento estabelecimento) throws Exception {
        estabelecimentoDAO.merge(estabelecimento);             
        return new ResponseEntity(estabelecimento, HttpStatus.OK);
    }
}
