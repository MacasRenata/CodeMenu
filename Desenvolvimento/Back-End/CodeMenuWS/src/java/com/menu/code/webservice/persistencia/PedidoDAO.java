/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("pedidoDao")
public class PedidoDAO{

protected EntityManager entityManager;

    public void salvar(Pedido p) {
    EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.saveOrUpdate(p);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }
    
    public Pedido carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Pedido) sessao.get(Pedido.class, id);
    }
    
    public void remover(Pedido p) {
        EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.delete(p);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }
    
    public List<Pedido> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Pedido.class).list();
    }
    
}
