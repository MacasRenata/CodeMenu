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
    @Path("/buscaEstabelecimentoId")
    @RequestMapping(value = "/buscaEstabelecimentoId", method = RequestMethod.GET,headers="Accept=application/json")
    public Estabelecimento buscaEstabelecimentoId(Estabelecimento estabelecimento) throws Exception{       
        return estabelecimentoDAO.carregar(estabelecimento.getId());
    }
    
    @GET
    @Path("/listaEstabelecimentos")
    @RequestMapping(value = "/listaEstbalecimentos", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Estabelecimento> listaEstabelecimentos() throws Exception{       
        return estabelecimentoDAO.listar();
    }
    
    @POST
    @Path("/adicionaEstabelecimentos")
    @RequestMapping(value = "/adicionaEstabelecimentos", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity adicionaEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception{
        estabelecimentoDAO.salvar(estabelecimento);
        return new ResponseEntity(estabelecimento, HttpStatus.OK);
    }  
    
    @DELETE
    @Path("/deletaEstabelecimento")
    @RequestMapping(value = "/deletaEstabelecimento", method = RequestMethod.DELETE,headers="Accept=application/json")
    public ResponseEntity deletaEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception {
        estabelecimentoDAO.remover(estabelecimento);
        if (null == estabelecimentoDAO) {
            return new ResponseEntity("Não existem estabelecimentos registrados com este ID ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);             
    }    
    
    @PUT
    @Path("/atualizaEstabelecimento")
    @RequestMapping(value = "/atualizaEstabelecimento", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity atualizaEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception {
        estabelecimentoDAO.atualizar(estabelecimento);
        return new ResponseEntity(estabelecimento, HttpStatus.OK);
    }
}
