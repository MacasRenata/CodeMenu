<%@page import="com.menu.code.webservice.model.Cliente"%>
<%@page import="com.menu.code.webservice.persistencia.ClienteDAO"%>
<%@page import="com.menu.code.conexaoMysql.ConexaoMySQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TESTE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="../../test-resbeans.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <p>Cadastrar novo cliente</p>
        <%ClienteDAO dao = new ClienteDAO();%> 
        <%Cliente cliente = new Cliente(3,"0000000");%>
        
        <%Cliente cli = dao.carregar(cliente.getId());%>
        <%= cli.getTelefone()%>
        
        
        
        <p>Buscar e Editar cliente</p>
        
        
        
        
        
        
        <p>Listar clientes</p>
        
        
        
        
        
        
        
        <p>Remover cliente</p>
       
        
        <P>
        <%
 
            out.println(ConexaoMySQL.statusConection());
 
        %>
        </P>
        <P>
        <%
            ConexaoMySQL.getConexaoMySQL();
            out.println(ConexaoMySQL.statusConection());
        %>
        </P>
    </body>
</html>
