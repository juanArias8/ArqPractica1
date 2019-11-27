<%-- 
    Document   : ingreso
    Created on : 20/02/2017, 05:47:16 PM
    Author     : jnda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/ingresoStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso</title>
    </head>
    <body>
        <div id="body">
            <div id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
                </div>   
                <div class="contenido">
                    <h1>Inicio de sesión</h1>   
                    <hr color="black"/>
                <c:if test="${param.error==1}">
                    <font id="msg" color="red">Datos erroneos. Intentelo de nuevo</font>
                </c:if> 
                <br/>
                <form action="ConcesionarioServlet?action=login" method="post">
                    <table>
                        <tr class="tr">
                            <th><label><b>Username:</b></label></th>
                            <th>
                                <input type="text" placeholder="Enter Username" class="it" name="username" required=""/> 
                            </th>
                        </tr>
                        <tr class="tr">
                            <th><label><b>Password:</b></label></th>
                            <th>
                                <input type="password" placeholder="Enter Password" class="it" name="password" required=""/> 
                            </th>
                        </tr>
                    </table>   
                    <input class="is" type="submit" name="action" value="Ingresar">
                    <input class="is" type="reset" name="action" value="Limpiar">
                </form>
            </div> 
           <footer id="fter">
                <p>Trabajo realizado para la materia Arquitectura de Software</p>
                <p>Código fuente: <a href="https://github.com/juanArias8/ArqPractica1">git</a></p>
            </footer>
        </div>
    </body>
</html>
