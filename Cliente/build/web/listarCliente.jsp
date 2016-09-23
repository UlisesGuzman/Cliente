<%-- 
    Document   : listarCliente
    Created on : 22-sep-2016, 13:38:50
    Author     : ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id Clientes</th>
                    <th>Numero Cliente</th>
                    <th>Nombre Cliente</th>
                    <th>Apellido</th>
                    <th>Sexo</th>
                    <th>Direccion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${cliente}">
                    <tr>
                        <td>${cliente.idCliente}</td>
                        <td>${cliente.numeroCliente}</td>
                        <td>${cliente.nombreCliente}</td>
                        <td>${cliente.apellido}</td>
                        <td>${cliente.sexo}</td>
                        <td>${cliente.direccion}</td>
                        <td><a href="ClienteController?action=cambiar&idCliente=${cliente.idCliente}">Cambiar</a></td>
                        <td><a href="ClienteController?action=borrar&idCliente=${cliente.idCliente}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ClienteController?action=agregar">Nuevo cliente</a>
        </p>
    </body>
</html>