<%-- 
    Document   : ventas
    Created on : 20/02/2017, 06:57:11 PM
    Author     : jnda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/clientesStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
    </head>
    <body>
        <div id="body">
            <nav id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
            </nav>
            <div id="contenido">
                <a class="a2" href="VentasServlet?action=registrar">REGISTRAR VENTA</a>
                <form action="VentasServlet?action=buscar" method="post">
                    <input class="a2" type="submit" value="BUSCAR VENTA" />
                    <input type="text" name="buscar" placeholder="Ingrese codigo de venta" class="it" required/>
                    <c:if test="${param.error == 1}">
                        <font id="msg" color="red">El registro no fue encontrado</font>
                    </c:if>
                </form>
                <table id="tbl">
                    <thead id="thb">
                        <tr>
                            <th>Venta</th>
                            <th>Administrador</th>
                            <th>Cliente</th>
                            <th>Vehiculo</th>
                            <th>Precio</th>
                            <th class="tv">¿Editar?</th>
                            <th class="td">¿Eliminar?</th>
                        </tr>
                    </thead>
                    <tbody id="thb">
                        <c:forEach var="a" items="${ventas}">
                            <tr class="tr">
                                <td>${a.idVenta}</td>
                                <td>${a.idAdmin.id}</td>
                                <td>${a.idCliente.id}</td>
                                <td>${a.matriculaCoche.matricula}</td>
                                <td>${a.precio}</td>
                                <td><a class="ad" href="VentasServlet?action=editar&id=${a.idVenta}">Editar</a></td>
                                <td><a class="ad" onclick="return confirm('Esta seguro?')" href="VentasServlet?action=delete&id=${a.idVenta}">Eliminar</a></td>
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
