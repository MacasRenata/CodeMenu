/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.persistencia;


import com.grupo3.codemenu.modelo.Item;
import java.util.List;
import org.hibernate.Session;



//@Repository("itemDao")
public class ItemDAO{
  
    public void salvar(Item item) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(item);
    }
    
    public Item carregar(int id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Item) sessao.get(Item.class, id);
    }   
    
    public void atualizar(Item item) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(item);
    }
    
    public void remover(Item item) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(item);
    }   
    
    public List<Item> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Item.class).list();
    }
    
}
