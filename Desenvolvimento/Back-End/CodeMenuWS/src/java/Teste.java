
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
import com.menu.code.webservice.persistencia.ClienteDAO;
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
       Cliente cliente = new Cliente(1, "53947889");
       ClienteDAO dao = new ClienteDAO();
       
       //INSERIR
       dao.salvar(cliente);
       
       //REMOVER
      // dao.remover(cliente);
       
       //LISTAR TUDO
       //dao.listar();
       
       //LISTAR POR ID
       //dao.carregar(cliente.getId());
       
   }   
}
