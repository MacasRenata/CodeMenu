/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;



import com.menu.code.webservice.model.Cliente;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;


@Repository("clienteDao")
public class ClienteDAO{

//protected EntityManager entityManager;

   /*public void salvar(Cliente c) {
    EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.saveOrUpdate(c);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }*/
    
    public void salvar(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(cliente);
    }
    
    public Cliente carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Cliente) sessao.get(Cliente.class, id);
    }
    
    public void atualizar(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(cliente);
    }
    
    /*public void remover(Cliente c) {
        EntityTransaction utx = entityManager.getTransaction();
        try{
            utx.begin();
            Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            sessao.delete(c);
            utx.commit();
        } catch(HibernateException ex) {
        utx.rollback();
        throw ex;
    }
    }*/    
    
    public void remover(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(cliente);
    }      
    
    public List<Cliente> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Cliente.class).list();
    }
    
}





