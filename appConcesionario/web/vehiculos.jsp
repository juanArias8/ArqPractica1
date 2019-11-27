<%-- 
    Document   : vehiculos
    Created on : 20/02/2017, 05:48:30 PM
    Author     : jnda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/vehiculosStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vehiculos</title>
    </head>
    <body>
        <div id="body">
            <nav id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
            </nav>
            <div id="contenido">
                <a class="a2" href="registrarVehiculos.jsp">AGREGAR CARRO</a>                    
                <form action="VehiculosServlet?action=buscar" method="post">
                        <input class="a2" type="submit" value="BUSCAR CARRO" />
                        <input type="text" name="buscar" placeholder="Ingrese matricula" class="it" required/>
                        <c:if test="${param.error == 1}">
                            <font id="msg" color="red">El registro no fue encontrado</font>
                        </c:if>
                    </form>
                <table id="tbl">
                    <thead id="thb">
                        <tr>
                            <th>Imagen</th>
                            <th>Descripción</th>
                            <th class="tv">¿Vender?</th>
                            <th class="tv">¿Editar?</th>
                            <th class="td">¿Eliminar?</th>
                        </tr>
                    </thead>
                    <tbody id="thb">
                        <c:forEach var="v" items="${vehiculos}">
                            <tr class="tr">
                                <td><img src="/appConcesionario/VehiculosServlet?code=1&matricula=${v.matricula}" alt="no hay" height="200" width="300"/></td>
                                <td class="ds" >Matricula:${v.matricula}<br/> Marca: ${v.marca}<br/>Modelo: ${v.modelo}<br/>Precio: ${v.precio}</td>      
                                <td class="tv"><a class="evt" href="ConcesionarioServlet?action=vender">Vender</a></td>
                                <td class="tv"><a class="evt" href="VehiculosServlet?action=editar&id=${v.matricula}">Editar</a></td>
                                <td class="td"><a class="evt" onclick="return confirm('Esta seguro?')" href="VehiculosServlet?action=delete&id=${v.matricula}">Eliminar</a></td>
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
