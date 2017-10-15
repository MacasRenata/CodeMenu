/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.persistence;

import com.menu.code.conexaoMysql.ConexaoMySQL;
import com.menu.code.webservice.model.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class MesaDAO {
    public void inserir(Mesa m) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("insert into mesa (qrcode, estabelecimento) values (?, ?)");
        pstmt.setString(1, m.getQrcode());
        pstmt.setLong(2, m.getEstabelecimentoId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public void atualizar(Mesa m) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("update mesa set qrcode = ?, estabelecimento = ? where id = ?");
        pstmt.setString(1, m.getQrcode());
        pstmt.setLong(2, m.getEstabelecimentoId());
        pstmt.setLong(2, m.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public List<Mesa> buscar(Mesa m) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from mesa where id like ?");
        pstmt.setLong(1, m.getId());
        ResultSet rs = pstmt.executeQuery();
        List<Mesa> lista = new ArrayList<Mesa>();
        while (rs.next() == true) {
            Mesa me = new Mesa();
            me.setQrcode(rs.getString("qrcode"));
            me.setEstabelecimento(rs.getLong("estabelecimento"));
            lista.add(me);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }

    public List<Mesa> buscarTudo() throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("select * from mesa");
        ResultSet rs = pstmt.executeQuery();
        List<Mesa> lista = new ArrayList<Mesa>();       
        while (rs.next() == true) {
            Mesa me = new Mesa();
            me.setId(rs.getLong("id"));
            me.setQrcode(rs.getString("qrcode"));           
            me.setEstabelecimento(rs.getLong("estabelecimento"));
            lista.add(me);
        }
        rs.close();
        pstmt.close();
        con.close();
        return lista;
    }
    
    public void deletar(Mesa m) throws Exception {
        Connection con = ConexaoMySQL.getConexaoMySQL();
        PreparedStatement pstmt = con.prepareStatement("delete from mesa where id = ?");
        pstmt.setLong(1, m.getId());
        pstmt.execute();
        pstmt.close();
        con.close();
    }
}
