/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Item;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("itemDao")
public class ItemDAO{
  
    public void salvar(Item item) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.saveOrUpdate(item);
    }
    
    public Item carregar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Item) sessao.get(Item.class, id);
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
