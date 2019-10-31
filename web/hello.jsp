<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
    </head>
    <body>
        <h1>Clientes</h1>

        <%
            List<Cliente> lista = (List<Cliente>) session
                    .getAttribute("lista");

            if (lista == null) {
                lista = new ArrayList<Cliente>();
            }
        %>

        <table class="table">
            <thead class='thead-dark'>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">CPF</th>
                </tr>
            </thead>
            <tbody>
                <% for(Cliente c : lista){ %>
                <tr>
                    <td><%= c.getNome() %></td>
                    <td><%= c.getCpf() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>

    </body>
</html>
