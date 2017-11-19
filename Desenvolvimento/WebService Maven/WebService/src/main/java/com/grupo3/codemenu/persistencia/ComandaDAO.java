/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.persistencia;


import com.grupo3.codemenu.modelo.Comanda;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("comandaDao")
public class ComandaDAO{

    public void salvar(Comanda comanda) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(comanda);
    }
    
    public Comanda carregar(int id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return  (Comanda) sessao.get(Comanda.class, id);
    }   
    
    public void atualizar(Comanda comanda) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(comanda);
    }
    
    public void remover(Comanda comanda) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(comanda);
    }   
    
    public List<Comanda> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Comanda.class).list();
    }
}
