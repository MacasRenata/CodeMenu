/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("clienteDao")
public class ClienteDAO{

protected EntityManager entityManager;

public ClienteDAO() {

}

@PersistenceContext

public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}

public Cliente find(Long id) {
return entityManager.find(Cliente.class, id);
}

@Transactional
public void persist(Cliente cliente) {
entityManager.persist(cliente);
}

@Transactional
public void merge(Cliente cliente) {
entityManager.merge(cliente);
}

@Transactional
public void remove(Cliente cliente) {
entityManager.remove(cliente);
}

@SuppressWarnings("unchecked")
public List<Cliente> findAll() {
return entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
}

}
