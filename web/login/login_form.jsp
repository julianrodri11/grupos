<%-- 
    Document   : newjsp
    Created on : 20/11/2015, 04:37:20 AM
    Author     : JULIAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../resources/css/login.css" rel="stylesheet" type="text/css" /> 
        <style type="text/css" >
            
            
@import url(http://fonts.googleapis.com/css?family=Open+Sans:400,600,700);

*, *:after, *:before {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    font-weight: normal;
    margin: 0;
    outline: 0 none;
    font-family: "Open Sans";
    padding: 0;
}

#bodylogin {
  background: #007CC8;
  font-family: "Open Sans";
}
.loading {
    margin: 10% auto 15px;
    position: relative;

    height: 40px;
    width: 40px;
}
.loading .circle {
    border-radius: 100%;
    position: absolute;
}
.loading .circle.dark {
    background-color: #1F5BA9;
    height: 22px;
    left: 1px;
    top: 10px;
    width: 22px;
}
.loading .circle.light {
    background-color: #61B5E4;
    height: 25px;
    right: 1px;
    top: 8px;
    width: 25px;
}
.loading .branding {
    background: url("http://s18.postimg.org/8a4d3vj3p/db_loader.png") repeat scroll 0 0 transparent;    
    height: 40px;
    width: 40px;
    position: absolute;
}

.login {
    width: 300px;
    margin: 0 auto;
}
.login form {
  width: 100%;
}
input {
    background: none repeat scroll 0 0 rgba(0, 0, 0, 0.3);
    border: 1px solid rgba(0, 0, 0, 0.3);
    border-radius: 4px 4px 4px 4px;
    box-shadow: 0 -5px 45px rgba(100, 100, 100, 0.2) inset, 0 1px 1px rgba(255, 255, 255, 0.2);
    color: #FFFFFF;
    font-size: 13px;
    margin-bottom: 10px;
    outline: medium none;
    padding: 10px;
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.3);
    width: 100%;
}

#enviar {
    background: linear-gradient(to bottom, #009EFF 0px, #0075BC 100%) repeat scroll 0 0 transparent;
    border: 1px solid rgba(0, 0, 0, 0.3);
    border-bottom: 1px solid rgba(0, 0, 0, 0.55);
    border-radius: 6px 6px 6px 6px;
    box-shadow: 0 1px 0 #E6F5FF inset;
    color: #FFFFFF;
    cursor: pointer;
    display: block;
    margin: 0 auto;
    padding: 10px 25px;
    text-shadow: 0 1px rgba(0, 0, 0, 0.3);
    width: 100%;
}


        </style>
    </head>
    <body id="bodylogin">

    <head><title>Login</title></head>
    <h:outputStylesheet library="css" name="/resources/css/login.css"/>
    
        <body id="bodylogin">    
    
            
        <div class="loading">
          
       <div class="circle light"></div>
        <div class="circle dark"></div>
        <div class="branding"></div>
        
        </div>        
            
            
        
        <div class="login">
        <form method="post" action="j_security_check">
            <p>Correo : <input type="email" name="j_username" placeholder="correo@umariana.edu.co" required="required"></p>
            <p>Contraseña: <input type="password" name="j_password" placeholder="*****" required="required"> </p>           
            <input id="enviar" type="submit" value="Login..." class="btn btn-primary btn-block btn-large"/>
        </form>

  
        </div>        
       </body>        
</html>
