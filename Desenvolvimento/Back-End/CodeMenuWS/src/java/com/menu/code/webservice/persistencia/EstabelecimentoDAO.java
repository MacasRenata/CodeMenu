/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Estabelecimento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("estabelecimentoDao")
public class EstabelecimentoDAO{

protected EntityManager entityManager;

public EstabelecimentoDAO() {

}

@PersistenceContext

public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}

public Estabelecimento find(Long id) {
return entityManager.find(Estabelecimento.class, id);
}

@Transactional
public void persist(Estabelecimento estabelecimento) {
entityManager.persist(estabelecimento);
}

@Transactional
public void merge(Estabelecimento estabelecimento) {
entityManager.merge(estabelecimento);
}

@Transactional
public void remove(Estabelecimento estabelecimento) {
entityManager.remove(estabelecimento);
}

@SuppressWarnings("unchecked")
public List<Estabelecimento> findAll() {
return entityManager.createQuery("SELECT e FROM Estabelecimento e").getResultList();
}

}
