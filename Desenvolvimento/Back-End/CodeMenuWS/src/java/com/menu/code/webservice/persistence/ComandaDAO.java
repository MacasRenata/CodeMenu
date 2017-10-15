/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistence;

import com.menu.code.conexaoMysql.ConexaoMySQL;
import com.menu.code.webservice.model.Comanda;
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
public class ComandaDAO {
    public void inserir(Comanda c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("insert into comanda (hora, status, valor, pedido_id) values (?, ?, ?, ?)");
        pstmt.setDate(1, (Date) c.getHora());
        pstmt.setInt(2, c.getStatus());
        pstmt.setDouble(3, c.getValor());
        pstmt.setLong(4, c.getPedidoId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public void atualizar(Comanda c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("update comanda set hora = ?, status = ?, valor = ?, pedido_id = ? where id = ?");
        pstmt.setDate(1, (Date) c.getHora());
        pstmt.setInt(2, c.getStatus());
        pstmt.setDouble(3, c.getValor());
        pstmt.setLong(4, c.getPedidoId());
        pstmt.setLong(5, c.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public List<Comanda> buscar(Comanda c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from comanda where id like ?");
        pstmt.setLong(1, c.getId());
        ResultSet rs = pstmt.executeQuery();
        List<Comanda> lista = new ArrayList<Comanda>();
        while (rs.next() == true) {
            Comanda com = new Comanda();
            com.setHora(rs.getDate("hora"));
            com.setStatus(rs.getInt("status"));
            com.setValor(rs.getDouble("valor"));
            com.setPedido(rs.getLong("pedido_id"));
            lista.add(com);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }    
    
    public List<Comanda> buscarTudo() throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from comanda");
        ResultSet rs = pstmt.executeQuery();
        List<Comanda> lista = new ArrayList<Comanda>();
        while (rs.next() == true) {
            Comanda com = new Comanda();
            com.setId(rs.getLong("id"));
            com.setHora(rs.getDate("hora"));
            com.setStatus(rs.getInt("status"));
            com.setValor(rs.getDouble("valor"));
            com.setPedido(rs.getLong("pedido_id"));
            lista.add(com);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }

    public void deletar(Comanda c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("delete from comanda where id = ?");
        pstmt.setLong(1, c.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
   
}
