/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistence;

import com.menu.code.conexaoMysql.ConexaoMySQL;
import com.menu.code.webservice.model.Item;
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
public class ItemDAO {
     public void inserir(Item i) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("insert into item (nome, tipo, preco, urlImagem) values (?, ?, ?, ?)");
        pstmt.setString(1, i.getNome());
        pstmt.setInt(2, i.getTipo());
        pstmt.setDouble(3, i.getPreco());
        pstmt.setString(4, i.getUrlImagem());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public void atualizar(Item i) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("update item set nome = ?, tipo = ?, preco = ?, urlImagem = ? where id = ?");
        pstmt.setString(1, i.getNome());
        pstmt.setInt(2, i.getTipo());
        pstmt.setDouble(3, i.getPreco());
        pstmt.setString(4, i.getUrlImagem());
        pstmt.setLong(5, i.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public List<Item> buscar(Item i) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from item where id like ?");
        pstmt.setLong(1, i.getId());
        ResultSet rs = pstmt.executeQuery();
        List<Item> lista = new ArrayList<Item>();
        while (rs.next() == true) {
            Item it = new Item();
            it.setNome(rs.getString("nome"));
            it.setTipo(rs.getInt("tipo"));
            it.setPreco(rs.getDouble("preco"));
            it.setUrlImagem(rs.getString("urlImagem"));
            lista.add(it);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }

    public List<Item> buscarPorTipo(Item i) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from item where tipo like ?");
        pstmt.setInt(1, i.getTipo());
        ResultSet rs = pstmt.executeQuery();
        List<Item> lista = new ArrayList<Item>();
        while (rs.next() == true) {
            Item it = new Item();
            it.setNome(rs.getString("nome"));
            it.setTipo(rs.getInt("tipo"));
            it.setPreco(rs.getDouble("preco"));
            it.setUrlImagem(rs.getString("urlImagem"));
            lista.add(it);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }
    
    public List<Item> buscarTudo() throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from item");
        ResultSet rs = pstmt.executeQuery();
        List<Item> lista = new ArrayList<Item>();
        while (rs.next() == true) {
            Item it = new Item();
            it.setId(rs.getLong("id"));
            it.setNome(rs.getString("nome"));
            it.setTipo(rs.getInt("tipo"));
            it.setPreco(rs.getDouble("preco"));
            it.setUrlImagem(rs.getString("urlImagem"));
            lista.add(it);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }
    
    public void deletar(Item i) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("delete from item where id = ?");
        pstmt.setLong(1, i.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
   
}
