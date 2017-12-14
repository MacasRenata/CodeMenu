
package beans;

import entidade.Item;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="itenBeans")
public class NomesBeans {
    
    private String nome; 
    private String tipo; 
    private double preco; 
    
    private Item iten = new Item(); 
    private List<Item> itens = new ArrayList<>(); 
    
    public void adicionar(){
         iten = new Item(); 
        itens.add(iten); 
        iten = new Item(); 
    }

    public Item getIten() {
        return iten;
    }

    public void setIten(Item iten) {
        this.iten = iten;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    
    
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    private String  mensagem; 
    
    public void dizernomepreco(){
        mensagem = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
