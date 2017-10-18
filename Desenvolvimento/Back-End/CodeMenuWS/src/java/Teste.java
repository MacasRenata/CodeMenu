
import com.menu.code.webservice.controle.ClienteControle;
import com.menu.code.webservice.controle.ComandaControle;
import com.menu.code.webservice.controle.EstabelecimentoControle;
import com.menu.code.webservice.controle.ItemControle;
import com.menu.code.webservice.controle.MesaControle;
import com.menu.code.webservice.controle.PedidoControle;
import com.menu.code.webservice.model.Cliente;
import com.menu.code.webservice.model.Comanda;
import com.menu.code.webservice.model.Estabelecimento;
import com.menu.code.webservice.model.Item;
import com.menu.code.webservice.model.Mesa;
import com.menu.code.webservice.model.Pedido;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcio
 */
public class Teste {
   public static void main(String[] args) throws Exception{
       ClienteControle cl = new ClienteControle();
       ComandaControle com = new ComandaControle();
       EstabelecimentoControle est = new EstabelecimentoControle();
       ItemControle i = new ItemControle();
       MesaControle m = new MesaControle();
       PedidoControle p = new PedidoControle();
       
       //LISTAR TUDO
       
       /*List<Cliente> lista = cl.getListaClientes();       
       for(Cliente c: lista){
           System.out.println("ID: "+c.getId()+" - "+"TELEFONE: "+c.getTelefone());
       }*/
       
       /*List<Comanda> lista2 = com.getListaComandas();
       for(Comanda c: lista2){
           System.out.println("ID: "+c.getId()+" - "+"HORA: "+c.getHora());
       }*/
       
       /*List<Estabelecimento> lista2 = est.getListaEstabelecimentos();
       for(Estabelecimento c: lista2){
           System.out.println("ID: "+c.getId()+" - "+"NOME: "+c.getNome());
       }*/
       
       /*List<Item> lista2 = i.getListaItens();
       for(Item c: lista2){
           System.out.println("ID: "+c.getId()+" - "+"NOME: "+c.getNome());
       }*/
       
       /*List<Mesa> lista2 = m.getListaMesas();
       for(Mesa c: lista2){
           System.out.println("ID: "+c.getId()+" - "+"ESTABELECIMENTO_ID: "+c.getEstabelecimento());
       }*/
       
       /*List<Pedido> lista2 = p.getListaPedidos();
       for(Pedido c: lista2){
           System.out.println("ID: "+c.getId());
       }*/  
       
       //INSERÇÃO
       
       Cliente cliente = new Cliente("59184821313");
       Comanda comanda = new Comanda();
       Estabelecimento estab = new Estabelecimento();
       Item item = new Item();
       Mesa mesa = new Mesa();
       Pedido pedido = new Pedido();    
       
       //cl.getAdicionaCliente(cliente);
       com.getAdicionaComanda(comanda);
   }   
}
