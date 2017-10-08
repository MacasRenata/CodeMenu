/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistencia;


import com.menu.code.webservice.model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("itemDao")
public class ItemDAO{

protected EntityManager entityManager;

public ItemDAO() {

}

@PersistenceContext

public void setEntityManager(EntityManager entityManager) {
this.entityManager = entityManager;
}

public Item find(Long id) {
return entityManager.find(Item.class, id);
}

@Transactional
public void persist(Item item) {
entityManager.persist(item);
}

@Transactional
public void merge(Item item) {
entityManager.merge(item);
}

@Transactional
public void remove(Item item) {
entityManager.remove(item);
}

@SuppressWarnings("unchecked")
public List<Item> findAll() {
return entityManager.createQuery("SELECT i FROM Item i").getResultList();
}

}
