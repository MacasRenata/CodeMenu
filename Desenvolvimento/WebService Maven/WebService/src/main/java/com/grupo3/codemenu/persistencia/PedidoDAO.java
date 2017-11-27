/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.persistencia;


import com.grupo3.codemenu.modelo.Pedido;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


//@Repository("pedidoDao")
public class PedidoDAO{

    public void salvar(Pedido pedido) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(pedido);
    }
    
    public Pedido carregar(int id) {
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
    
    public List<Pedido> listarPorComanda(int idAtual) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Query consulta= sessao.createQuery("FROM Pedido WHERE id_comanda = :consultaId");  
        consulta.setInteger("consultaId", idAtual);
        //consulta.setMaxResults(10);        
        List<Pedido> res = consulta.list();    
        return res;
    }       
}
