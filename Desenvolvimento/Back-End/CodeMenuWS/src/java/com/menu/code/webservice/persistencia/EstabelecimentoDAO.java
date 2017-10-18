/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Estabelecimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("estabelecimentoDao")
public class EstabelecimentoDAO{

protected EntityManager entityManager;

public void salvar(Estabelecimento e) {
    EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.saveOrUpdate(e);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }
    
    public Estabelecimento carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Estabelecimento) sessao.get(Estabelecimento.class, id);
    }
    
    public void remover(Estabelecimento e) {
        EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.delete(e);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }
    
    public List<Estabelecimento> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Estabelecimento.class).list();
    }
    
}