<%-- 
    Document   : areaAdmin
    Created on : 31/05/2018, 13:16:58
    Author     : jerick.gs
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">    

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area - Admin</title>        
    </head>
    <body>
        <c:if test="${sessionScope.status == null}">
            <jsp:forward page="controle?logica=Login&usuario=L&senha=S"></jsp:forward>                
        </c:if>

        <h1>Resultado Tipo de Session: ${sessionScope.status}</h1>
        <h1>Resultado Tipo de Usuário: ${admin.tipoDeUsuario}</h1>
        <h1>Resultado Senha: ${admin.senha}</h1>        

        <a href="controle?logica=Logout&status=${sessionScope.status}">Logout</a>
        <!--<input type="submit" name="logica" value="Logout" />-->                                       
    </body>
</html>
