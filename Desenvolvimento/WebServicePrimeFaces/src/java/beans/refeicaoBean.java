
package beans;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Atendimento;
import modelo.Refeicao;

import persistencia.AtendimentoDao;
import persistencia.refeicaoDao;

import modelo.Refeicao;



import persistencia.refeicaoDao;

/**
 *
 * @author Gabriel
 */
@ManagedBean(name="refeicaoBean")
@SessionScoped
public class refeicaoBean implements Serializable {
    
    private Refeicao ref = new Refeicao();
    private final  refeicaoDao dao = new refeicaoDao();
    private List<Refeicao> listaRefeicao;
    
    private Atendimento atendimento =new Atendimento();
    private AtendimentoDao atendimentoDao = new AtendimentoDao();
    private List<Atendimento> atendimentos;
    
  
    
   
    @PostConstruct
    public void init(){
        listaRefeicao = dao.listar(); 
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false); 
               
    } 
    
   

     public List<Refeicao> getListaRefeicao() {
        return listaRefeicao;
    }
     
    public Refeicao getRefeicao() {
        return ref;
    }

    public void setChamado(Refeicao ref) {
        this.ref = ref;
    }

  

   
    
   
    public void salvarNovaRefeicao() {
        
      
       
        dao.salvar(ref);   
        atendimento.setDescricaoAtendimento("Inicio chamado");
        atendimento.setRefeicao(ref);        
        atendimentoDao.salvar(atendimento);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Refeição cadastrada com sucesso!!!");
        
        
        this.listaRefeicao = dao.listar(); 
        this.ref = new Refeicao();
        
        this.atendimento =new Atendimento();
       
    }
    
    public String salvar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false); 
        //Servidor s =(Servidor) session.getAttribute("usuario");
        
  
            dao.salvar(ref);
            
           
           

            enviarMensagem(FacesMessage.SEVERITY_INFO, "Atendimento registrado com sucesso!!!");
            
            this.listaRefeicao = dao.listar(); 
            this.ref = new Refeicao();
            
            
            return "listaRefeicao";


    }
   
     
      public String cadastraRefeicaoForm(){
        ref =new Refeicao();
        return "cadastroRefeicao";    
    }
     public void carregar(int id) {
        ref = dao.carregar(id);
     
    }
     
     public void remover() {
        dao.remover(ref);
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Refeição removida com sucesso");
        listaRefeicao = dao.listar(); 
    }
     
    public void alteraStatusChamado(){
        dao.salvar(ref);
        listaRefeicao = dao.listar();       
    }
   
    public String cadastraChamadoForm(){
        ref = new Refeicao();
        return "cadastroRefeicao";    
    }
    
    public String listaRefeicaoFrom(){
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false); 
       // Servidor s =(Servidor) session.getAttribute("usuario");               
       // if(s!=null){
          return "listaRefeicao";
       // }
       // return "index";
    }
     
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
    
  
   
       
    @PreDestroy
    public void encerrar() {
        dao.encerrar();
    } 
}
