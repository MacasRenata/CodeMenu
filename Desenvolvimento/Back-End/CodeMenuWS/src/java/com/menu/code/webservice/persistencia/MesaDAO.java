/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Mesa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("mesaDao")
public class MesaDAO{

protected EntityManager entityManager;

public MesaDAO() {

}

@PersistenceContext

public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}

public Mesa find(Long id) {
return entityManager.find(Mesa.class, id);
}

@Transactional
public void persist(Mesa cliente) {
entityManager.persist(cliente);
}

@Transactional
public void merge(Mesa cliente) {
entityManager.merge(cliente);
}

@Transactional
public void remove(Mesa cliente) {
entityManager.remove(cliente);
}

@SuppressWarnings("unchecked")
public List<Mesa> findAll() {
return entityManager.createQuery("SELECT m FROM Mesa m").getResultList();
}

}
