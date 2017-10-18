/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Mesa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("mesaDao")
public class MesaDAO{

protected EntityManager entityManager;

    public void salvar(Mesa m) {
    EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.saveOrUpdate(m);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }
    
    public Mesa carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Mesa) sessao.get(Mesa.class, id);
    }
    
    public void remover(Mesa m) {
        EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.delete(m);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }
    
    public List<Mesa> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Mesa.class).list();
    }
    
}
