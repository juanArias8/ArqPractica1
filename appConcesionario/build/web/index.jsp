<%-- 
    Document   : index
    Created on : 20/02/2017, 05:47:08 PM
    Author     : jnda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/indexStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <div id="body">
            <nav id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
            </nav>
            <div id="contenido">         
                    <a id="tt"  href="VehiculosServlet?action=listIndex">MOSTRAR VEHICULOS</a>
                    <hr color="black"/>
                    <table id="tbl">
                        <thead id="thb">
                            <tr>
                                <th>Imagen</th>
                                <th>Descripción</th>
                            </tr>
                        </thead>
                        <tbody id="thb">
                            <c:forEach var="v" items="${vehiculos}">
                            <tr class="tr">
                                <td><img src="/appConcesionario/VehiculosServlet?code=1&matricula=${v.matricula}" alt="no hay" height="200" width="300"/></td>
                                <td class="ds" > Marca: ${v.marca}<br/>Modelo: ${v.modelo}<br/>Precio: ${v.precio}</td>      
                            </tr>
                        </c:forEach> 
                    </tbody>          
                </table>
            </div>
            <footer id="fter">
                <p>Trabajo realizado para la materia Arquitectura de Software</p>
                <p>Código fuente: <a href="https://github.com/juanArias8/ArqPractica1">git</a></p>
            </footer>
        </div>
    </body>
</html>
