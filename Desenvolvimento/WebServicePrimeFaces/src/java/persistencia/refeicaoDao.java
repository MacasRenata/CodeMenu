
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Refeicao;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Duda
 */
public class refeicaoDao {
    private final Session sessao;
    
    public refeicaoDao() {
        sessao = HibernateUtil.getSessionFactory().openSession();    
    }
    
    public void salvar(Refeicao l) {
        Transaction t = sessao.beginTransaction();
        sessao.saveOrUpdate(l);
        t.commit();
    }
    
    public Refeicao carregar(int id) {
        return (Refeicao) sessao.load(Refeicao.class, id);
    }
    
    public void remover(Refeicao l) {
        sessao.delete(l);
    }
    
    public List<Refeicao> listar() {
        return sessao.createCriteria(Refeicao.class).list();
    } 
    
    public void encerrar() {
        sessao.getSessionFactory().close();
       sessao.close(); 
    }   
}
