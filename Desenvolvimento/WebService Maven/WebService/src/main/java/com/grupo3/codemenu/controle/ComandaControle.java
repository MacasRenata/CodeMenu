/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.grupo3.codemenu.modelo.Comanda;
import com.grupo3.codemenu.modelo.Pedido;
import com.grupo3.codemenu.persistencia.ComandaDAO;
import com.grupo3.codemenu.persistencia.PedidoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
@Path("/comanda")
public class ComandaControle {
    
    @Autowired
    ComandaDAO comandaDAO = new ComandaDAO();       
    
    @GET
    @Path("/listaComandas")
    @Produces("application/json")
    public Comanda buscaComandaId(Comanda comanda) throws Exception{             
      //return comandaDAO.carregar(comanda.getId());
      return comandaDAO.carregar(comanda.getId());
    }
    
    @GET
    @Path("/comandaId")
    @Produces("application/json")
    public List<Comanda> listaComandas() throws Exception{       
        return comandaDAO.listar();
    }
    
    @POST
    @Path("/addComanda")
    @Consumes("application/json")
    public ResponseEntity adicionaComanda(@RequestBody Comanda comanda) throws Exception{
        comandaDAO.salvar(comanda);
        return new ResponseEntity(comanda, HttpStatus.OK);
    }          
    
    @PUT
    @Path("/updateComanda")
    @Consumes("application/json")
    public ResponseEntity atualizaComanda(@RequestBody Comanda comanda) throws Exception {
        comanda.setValor(somaPedidos(comanda));
        comandaDAO.atualizar(comanda);
        return new ResponseEntity(comanda, HttpStatus.OK);
    }    
   
    
    private double somaPedidos (Comanda comanda) {  
        PedidoDAO pedidosDao = new PedidoDAO();
        List<Pedido> pedidos = pedidosDao.listar();
        double valor = 0;
        for (Pedido pedido : pedidos) {
            if(pedido.getStatus() != 5){
                valor = valor + pedido.getValor(); 
            }
        }
        return valor;
    }    
}
