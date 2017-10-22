/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Mesa;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("mesaDao")
public class MesaDAO{


    public void salvar(Mesa mesa) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(mesa);
    }
    
    public Mesa carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Mesa) sessao.get(Mesa.class, id);
    }    
    
    public void atualizar(Mesa mesa) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(mesa);
    }
    
    public void remover(Mesa mesa) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(mesa);
    }    
    
    public List<Mesa> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Mesa.class).list();
    }
    
}
