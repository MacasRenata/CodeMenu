/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistence;

import com.menu.code.conexaoMysql.ConexaoMySQL;
import com.menu.code.webservice.model.Estabelecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class EstabelecimentoDAO {
  public void inserir(Estabelecimento e) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("insert into estabelecimento (nome, telefone, endereco, email) values (?, ?, ?, ?)");
        pstmt.setString(1, e.getNome());
        pstmt.setString(2, e.getTelefone());
        pstmt.setString(3, e.getEndereco());
        pstmt.setString(4, e.getEmail());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public void atualizar(Estabelecimento e) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("update cliente set nome = ?, telefone = ?, endereco = ?, email = ? where id = ?");
        pstmt.setString(1, e.getNome());
        pstmt.setString(2, e.getTelefone());
        pstmt.setString(3, e.getEndereco());
        pstmt.setString(4, e.getEmail());
        pstmt.setLong(5, e.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public List<Estabelecimento> buscar(Estabelecimento e) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from estabelecimento where id like ?");
        pstmt.setLong(1, e.getId());
        ResultSet rs = pstmt.executeQuery();
        List<Estabelecimento> lista = new ArrayList<Estabelecimento>();
        while (rs.next() == true) {
            Estabelecimento est = new Estabelecimento();
            est.setNome(rs.getString("nome"));
            est.setTelefone(rs.getString("telefone"));
            est.setEndereco(rs.getString("endereco"));
            est.setEmail(rs.getString("email"));
            lista.add(est);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }

    public void deletar(Estabelecimento e) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("delete from estabelecimento where id = ?");
        pstmt.setLong(1, e.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
     
}
