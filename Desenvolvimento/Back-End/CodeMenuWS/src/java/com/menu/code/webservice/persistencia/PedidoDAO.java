/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("pedidoDao")
public class PedidoDAO{

protected EntityManager entityManager;

public PedidoDAO() {

}

@PersistenceContext

public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}

public Pedido find(Long id) {
return entityManager.find(Pedido.class, id);
}

@Transactional
public void persist(Pedido pedido) {
entityManager.persist(pedido);
}

@Transactional
public void merge(Pedido pedido) {
entityManager.merge(pedido);
}

@Transactional
public void remove(Pedido pedido) {
entityManager.remove(pedido);
}

@SuppressWarnings("unchecked")
public List<Pedido> findAll() {
return entityManager.createQuery("SELECT p FROM Pedido p").getResultList();
}

}
