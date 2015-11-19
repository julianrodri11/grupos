<%-- 
    Document   : login_form
    Created on : Mar 25, 2015, 4:48:08 PM
    Author     : dsilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:p="http://primefaces.org/ui">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Para esta seccion debes autenticarte</h1>
        <form method="post" action="j_security_check">
            User Id: <input name="j_username"/><br/>
            Password: <input name="j_password" type="password"/><br/>
            <input type="submit" value="Login..."/>
        </form>
    </body>
</html>
