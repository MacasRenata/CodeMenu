/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistence;

import com.menu.code.conexaoMysql.ConexaoMySQL;
import com.menu.code.webservice.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


        

/**
 *
 * @author anderson
 */


public class ClienteDAO {

   
   public void inserir(Cliente c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("insert into cliente (telefone) values (?)");
        pstmt.setString(1, c.getTelefone());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public void atualizar(Cliente c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("update cliente set telefone = ? where id = ?");
        pstmt.setString(1, c.getTelefone());
        pstmt.setLong(2, c.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public List<Cliente> buscar(Cliente c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from cliente where id like ?");
        pstmt.setLong(1, c.getId());
        ResultSet rs = pstmt.executeQuery();
        List<Cliente> lista = new ArrayList<Cliente>();
        while (rs.next() == true) {
            Cliente cli = new Cliente();
            cli.setTelefone(rs.getString("telefone"));
            lista.add(cli);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }

    public List<Cliente> buscarTudo() throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from cliente");
        //pstmt.setLong(1, c.getId());
       // pstmt.setString(2, c.getTelefone());
        ResultSet rs = pstmt.executeQuery();
        List<Cliente> lista = new ArrayList<Cliente>();
        while (rs.next() == true) {
            Cliente cli = new Cliente();
            cli.setId(rs.getLong("id"));
            cli.setTelefone(rs.getString("telefone"));
            lista.add(cli);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }
    
    public void deletar(Cliente c) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("delete from cliente where id = ?");
        pstmt.setLong(1, c.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }   
}
