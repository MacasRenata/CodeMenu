/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Comanda;
import com.menu.code.webservice.model.Pedido;
import com.menu.code.webservice.persistencia.ComandaDAO;
import com.menu.code.webservice.persistencia.PedidoDAO;
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
public class ComandaControle {
    
    @Autowired
    ComandaDAO comandaDAO = new ComandaDAO();
    
    @GET
    @Path("/buscaComandaId")
    @RequestMapping(value = "/buscaComandaId", method = RequestMethod.GET,headers="Accept=application/json")
    public Comanda buscaComandaId(Comanda comanda) throws Exception{       
        return comandaDAO.carregar(comanda.getId());
    }
    
    @GET
    @Path("/listaComandas")
    @RequestMapping(value = "/listaComandas", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Comanda> listaComandas() throws Exception{       
        return comandaDAO.listar();
    }
    
    @POST
    @Path("/adicionaComanda")
    @RequestMapping(value = "/adicionaComanda", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity adicionaComanda(@RequestBody Comanda comanda) throws Exception{
        comandaDAO.salvar(comanda);
        return new ResponseEntity(comanda, HttpStatus.OK);
    }          
    
    @PUT
    @Path("/atualizaComanda")
    @RequestMapping(value = "/atualizaComanda", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity atualizaComanda(@RequestBody Comanda comanda) throws Exception {
        comanda.setValor(somaPedidos(comanda));
        comandaDAO.atualizar(comanda);
        return new ResponseEntity(comanda, HttpStatus.OK);
    }
    
    /*public Comanda SomaPedidos (Comanda comanda) {
       List<Pedido> pedidos = comanda.getPedidos();
       double valor = 0;
       for (Pedido pedido : pedidos) {
       if(pedido.getStatus() != 5) // o valor 5 se refere a um pedido que foi cancelado
          valor = valor + pedido.getValor(); // soma tds os pedidos validos para gerar o valor total da comanda
     }
       comanda.setValor(valor);
       return comanda;
    }*/    
    
    public double somaPedidos (Comanda comanda) {
        List<Pedido> pedidos = comanda.getPedidos();
        double valor = 0;
        for (Pedido pedido : pedidos) {
            if(pedido.getStatus() != 5){
                valor = valor + pedido.getValor(); 
            }
        }
        return valor;
    }    
}
