<%-- 
    Document   : clientes
    Created on : 22-sep-2016, 13:45:10
    Author     : ulises
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar clientes</title>
    </head>
    <body>
        <form action="ClienteController" method="post">
            <fieldset>
                <div>
                    <label>id de cliente: </label>
                    <input type="text" name="idCliente" value="${cliente.idCliente}"
                           placeholder="idCliente"
                           readonly="readonly"/>
                </div>
                <div>
                    <label>Numero cliente: </label>
                    <input type="text" name="Numero" value="${cliente.numeroCliente}"
                           placeholder="numeroCliente"/>
                </div>
                <div>       
                    <label>Nombre Cliente: </label>
                    <input type="text" name="nombre" value="${cliente.nombreCliente}"
                           placeholder="nombre Cliente"/>
                </div>
                <div>
                    <label>Apellido: </label>
                    <input type="text" name="apellido" value="${cliente.apellido}"
                           placeholder="Apellido del cliente"/>
                </div>
                  <div>
                    <label>Sexo </label>
                    <input type="text" name="sexo" value="${cliente.sexo}"
                           placeholder="sexo del cliente"/>
                </div>
                <div>
                    <label>Direccion: </label>
                    <input type="text" name="direccion" value="${cliente.direccion}"
                           placeholder="Direccion del cliente"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
