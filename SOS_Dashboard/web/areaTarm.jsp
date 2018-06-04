<%-- 
    Document   : areaTarm
    Created on : 30/05/2018, 19:20:39
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Area - Tarm</title>
    </head>
    <body>

        <c:if test="${sessionScope.status == null}">
            <jsp:forward page="controle?logica=Login&usuario=L&senha=S"></jsp:forward>                
        </c:if>       
        
        <h1>Resultado Tipo de Session: ${sessionScope.status}</h1>
        <h1>Resultado Tipo de Usuário: ${tarm.tipoDeUsuario}</h1>
        <h1>Resultado Senha: ${tarm.senha}</h1>
        
        <a href="controle?logica=Logout&status=${sessionScope.status}">Logout</a>
    </body>             
</html>