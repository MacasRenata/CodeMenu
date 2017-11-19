/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3.codemenu.modelo;

import com.grupo3.codemenu.modelo.Estabelecimento;
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
    private int id;
    private String identificacao;
    private String qrcode;
    private int status;
    
    @ManyToOne
    @JoinColumn(name ="id_estabelecimento")
    private Estabelecimento estabelecimento;  

    public int getId() {
        return id;
    }    
    
    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
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
