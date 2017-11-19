/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.persistencia;


import com.grupo3.codemenu.modelo.Estabelecimento;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("estabelecimentoDao")
public class EstabelecimentoDAO{
    
    public void salvar(Estabelecimento estabelecimento) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(estabelecimento);
    }
    
    public Estabelecimento carregar(int id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Estabelecimento) sessao.get(Estabelecimento.class, id);
    }   
    
    public void atualizar(Estabelecimento estabelecimento) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(estabelecimento);
    }
    
     public void remover(Estabelecimento estabelecimento) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(estabelecimento);
    }   
    
    public List<Estabelecimento> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Estabelecimento.class).list();
    }
    
}