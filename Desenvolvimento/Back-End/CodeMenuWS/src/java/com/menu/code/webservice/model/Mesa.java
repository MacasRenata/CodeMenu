/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

import com.menu.code.webservice.model.Estabelecimento;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author anderson
 */

@Entity
@Table(name="mesa")
public class Mesa implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String qrcode;
    private int status;
    
    @ManyToOne
    @JoinColumn(name ="id_estabelecimento")
    private Estabelecimento estabelecimento;

    public Mesa(Long id, String qrcode, Estabelecimento estabelecimento) {
        this.id = id;
        this.qrcode = qrcode;
        this.estabelecimento = estabelecimento;
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
    
   
}
