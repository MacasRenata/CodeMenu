/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Comanda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("comandaDao")
public class ComandaDAO{

protected EntityManager entityManager;

public ComandaDAO() {

}

@PersistenceContext

public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}

public Comanda find(Long id) {
return entityManager.find(Comanda.class, id);
}

@Transactional
public void persist(Comanda comanda) {
entityManager.persist(comanda);
}

@Transactional
public void merge(Comanda comanda) {
entityManager.merge(comanda);
}

@Transactional
public void remove(Comanda comanda) {
entityManager.remove(comanda);
}

@SuppressWarnings("unchecked")
public List<Comanda> findAll() {
return entityManager.createQuery("SELECT c FROM Comanda c").getResultList();
}

}
