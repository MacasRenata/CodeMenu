/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {
    @Id
    @GeneratedValue
    private int id;
   
    private String descricaoAtendimento;
    
   
    
    @OneToOne
    @JoinColumn(name="id_chamado")
    private Refeicao ref;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

   

    public Refeicao getRefeicao() {
        return ref;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.ref = ref;
    }
    
}
