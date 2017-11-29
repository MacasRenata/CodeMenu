/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.persistencia;



import com.grupo3.codemenu.modelo.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository("clienteDao")
public class ClienteDAO{

    
    public void salvar(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(cliente);
    }
    
    public Cliente carregar(int id) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Cliente) sessao.get(Cliente.class, id);
    }
    
    public void atualizar(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.merge(cliente);
    }             
    
    public List<Cliente> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Cliente.class).list();
    }
    
    public Cliente consultaPorTelefone(String telefone){
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Query consulta= sessao.createQuery("FROM Cliente WHERE telefone = :consulta"); 
        consulta.setString("consulta", telefone);        
        return (Cliente) consulta.uniqueResult();
    }                 
}





