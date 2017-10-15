/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistence;

import com.menu.code.conexaoMysql.ConexaoMySQL;
import com.menu.code.webservice.model.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class PedidoDAO {
  public void inserir(Pedido p) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("insert into pedidos (data, status, valor, quantidade, cliente_id, mesa_id, item_id) values (?, ?, ?, ?, ?, ?, ?)");
        pstmt.setDate(1, (Date) p.getData());
        pstmt.setInt(2, p.getStatus());
        pstmt.setDouble(3, p.getValor());
        pstmt.setInt(4, p.getQuantidade());
        pstmt.setLong(5, p.getClienteId());
        pstmt.setLong(6, p.getMesaId());
        pstmt.setLong(7, p.getItemId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public void atualizar(Pedido p) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("update pedidos set data = ?, status = ?, valor = ?, quantidade = ?, cliente_id = ?, mesa_id = ?, item_id = ? where id = ?");
        pstmt.setDate(1, (Date) p.getData());
        pstmt.setInt(2, p.getStatus());
        pstmt.setDouble(3, p.getValor());
        pstmt.setInt(4, p.getQuantidade());
        pstmt.setLong(5, p.getClienteId());
        pstmt.setLong(6, p.getMesaId());
        pstmt.setLong(7, p.getItemId());
        pstmt.setLong(8, p.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public List<Pedido> buscar(Pedido p) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from pedidos where id like ?");
        pstmt.setLong(1, p.getId());
        ResultSet rs = pstmt.executeQuery();
        List<Pedido> lista = new ArrayList<Pedido>();
        while (rs.next() == true) {
            Pedido ped = new Pedido();
            ped.setData(rs.getDate("data"));
            ped.setStatus(rs.getInt("status"));
            ped.setValor(rs.getDouble("valor"));
            ped.setQuantidade(rs.getInt("quantidade"));
            ped.setCliente(rs.getLong("cliente_id"));
            ped.setMesa(rs.getLong("mesa_id"));
            ped.setItem(rs.getLong("item_id"));
            lista.add(ped);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }

    public List<Pedido> buscarTudo() throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from pedidos");
        ResultSet rs = pstmt.executeQuery();
        List<Pedido> lista = new ArrayList<Pedido>();
        while (rs.next() == true) {
            Pedido ped = new Pedido();
            ped.setId(rs.getLong("id"));
            ped.setData(rs.getDate("data"));
            ped.setStatus(rs.getInt("status"));
            ped.setValor(rs.getDouble("valor"));
            ped.setQuantidade(rs.getInt("quantidade"));
            ped.setCliente(rs.getLong("cliente_id"));
            ped.setMesa(rs.getLong("mesa_id"));
            ped.setItem(rs.getLong("item_id"));
            lista.add(ped);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }
    
    public void deletar(Pedido p) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("delete from pedidos where id = ?");
        pstmt.setLong(1, p.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
     
}
