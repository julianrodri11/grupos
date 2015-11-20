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

        <ui:define name="content">    
        <h1>Para esta seccion debes autenticarte</h1>
        <form method="post" action="j_security_check">
            <p>Correo : <input type="email" name="j_username" placeholder="correo@umariana.edu.co" required="required"></p>
            <p>Contraseña: <input type="password" name="j_password" placeholder="*****"> </p>           
            <input type="submit" value="Login..."/>
        </form>
    
            </ui:define>
        </ui:composition>
</html>
