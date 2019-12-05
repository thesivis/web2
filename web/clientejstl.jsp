<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="aux" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="resources/js/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" />
    </head>
    <body>
        <h1>Cliente</h1>
        
        <div class="container">
            <form method="POST" action="clientejstl">
                <input type="hidden" name="id" value="${cliente.id}"/>
                <div class="form-group">
                    <label id="labelNome" for="nome">Nome:</label>
                    <input class="form-control" type="text" id="nome" name="nome" required value="${cliente.nome}" />
                </div>

                <div class="form-group">
                    <label for="cpf">CPF</label>
                    <aux:cpf classe="form-control" id="cpf" nome="cpf" 
                             valor="${cliente.cpf}" />
                </div>

                <div class="form-group">
                    <label for="telefone">Telefone</label>
                    <input class="form-control" type="text" id="telefone" name="telefone" required value="${cliente.telefone}"/>
                </div>

                <button id="salvar" class="btn btn-success" type="submit">Salvar</button>
            </form>
        </div>

        <div class="container">
            <table class="table">
                <thead class='thead-dark'>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="c" items="${lista}">
                        <tr>
                            <td>${c.nome}</td>
                            <td>${c.cpf}</td>
                            <td>
                                <a href="clientejstl?editar=${c.id}">
                                    <button class="btn btn-primary">Editar</button>
                                </a>
                                <a href="clientejstl?excluir=${c.id}">
                                    <button class="btn btn-danger">Excluir</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
