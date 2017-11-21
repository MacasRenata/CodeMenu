/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.grupo3.codemenu.modelo.Item;
import com.grupo3.codemenu.modelo.Pedido;
import com.grupo3.codemenu.persistencia.ItemDAO;
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
@Path("/pedido")
public class PedidoControle {
    
    @Autowired
    PedidoDAO pedidoDAO = new PedidoDAO();
    
    @GET
    @Path("/pedidoId")
    @Produces("application/json")
    public Pedido buscaPedidoId(Pedido pedido) throws Exception{       
        return pedidoDAO.carregar(pedido.getId());
    }
    
    @GET
    @Path("/listaPedidos")
    @Produces("application/json")
    public List<Pedido> listaPedidos() throws Exception{       
        return pedidoDAO.listar();
    }
    
    @POST
    @Path("/addPedido")
    @Consumes("application/json")
    public ResponseEntity adicionaPedido(@RequestBody Pedido pedido) throws Exception{  
        pedido.setValor(somaItens(pedido));
        pedidoDAO.salvar(pedido);
        return new ResponseEntity(pedido, HttpStatus.OK);
    }        
    
    @PUT
    @Path("/updatePedido")
    @Consumes("application/json")
    public ResponseEntity atualizaPedido(@RequestBody Pedido pedido) throws Exception { 
        pedido.setValor(somaItens(pedido));
        pedidoDAO.atualizar(pedido);             
        return new ResponseEntity(pedido, HttpStatus.OK);
    }    
    
    public double somaItens(Pedido pedido){        
        ItemDAO itemDao = new ItemDAO();
        Item valor = itemDao.carregar(pedido.getItens().getId());              
        return valor.getPreco() * pedido.getQuantidade();        
    }
}
