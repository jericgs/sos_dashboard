<%-- 
    Document   : areaMedico
    Created on : 31/05/2018, 13:09:37
    Author     : jerick.gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area - Médico</title>
    </head>
    <body>

        <c:if test="${sessionScope.status == null}">
            <jsp:forward page="controle?logica=Login&usuario=L&senha=S"></jsp:forward>                
        </c:if>

        <h1>Resultado Tipo de Session: ${sessionScope.status}</h1>
        <h1>Resultado Tipo de Usuário: ${medico.tipoDeUsuario}</h1>
        <h1>Resultado Senha: ${medico.senha}</h1>
        
        <a href="controle?logica=Logout&status=${sessionScope.status}">Logout</a>
        
    </body>
</html>
