/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.controle;

import com.google.gson.Gson;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Path("listaPedidos")
    @Produces("application/json")
    public List<Pedido> listaPedidos() throws Exception{       
        return pedidoDAO.listar();
    }
    
    @GET
    @Path("pedidoId/{param}")
    @Produces("application/json")
    public Pedido buscaPedidoId(@PathParam("param") int id) throws Exception{       
        return pedidoDAO.carregar(id);
    }    
    
    
    @POST
    @Path("addPedido")
    @Consumes("application/json")
    public Response adicionaPedido(String json) throws Exception{  
        Gson gson = new Gson();
        Pedido pedido = new Pedido();
        pedido = gson.fromJson(json, Pedido.class);
        pedido.setValor(somaItens(pedido));
        pedidoDAO.salvar(pedido);
        return Response.status(Response.Status.OK).build(); 
    }        
    
    @PUT
    @Path("updatePedido")
    @Produces("application/json")
    public Response atualizaPedido(String json) throws Exception { 
        Gson gson = new Gson();
        Pedido pedido = new Pedido();
        pedido = gson.fromJson(json, Pedido.class);
        Pedido pedidoBanco = pedidoDAO.carregar(pedido.getId());
        if(pedidoBanco != null){
            pedido.setValor(somaItens(pedido));
            pedidoDAO.atualizar(pedido);             
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }    
    
    public double somaItens(Pedido pedido){        
        ItemDAO itemDao = new ItemDAO();
        Item valor = itemDao.carregar(pedido.getItens().getId());              
        return valor.getPreco() * pedido.getQuantidade();        
    }
}
