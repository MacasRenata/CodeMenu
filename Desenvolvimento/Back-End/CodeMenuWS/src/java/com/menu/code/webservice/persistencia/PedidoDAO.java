/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Pedido;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository("pedidoDao")
public class PedidoDAO{

    public void salvar(Pedido pedido) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(pedido);
    }
    
    public Pedido carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Pedido) sessao.get(Pedido.class, id);
    }   
    
    public void atualizar(Pedido pedido) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(pedido);
    }    
    
    public List<Pedido> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Pedido.class).list();
    }
    
}
