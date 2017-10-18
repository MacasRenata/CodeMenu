/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Marcio
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.menu.code.webservice.CodemenuResource.class);
        resources.add(com.menu.code.webservice.controle.ComandaControle.class);
        resources.add(com.menu.code.webservice.controle.EstabelecimentoControle.class);
        resources.add(com.menu.code.webservice.controle.ItemControle.class);
        resources.add(com.menu.code.webservice.controle.MesaControle.class);
    }
    
}
