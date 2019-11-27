<%-- 
    Document   : registrarVentas
    Created on : 26-feb-2017, 12:29:09
    Author     : Juan Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/registroStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Venta</title>
    </head>
    <body>
        <%! String action = "ingresar"; %>
        <c:if test="${param.editar == 1}">
            <% action = "edit"; %>
        </c:if>
        <div id="body">
            <nav id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
            </nav>
            <div class="contenido">
                <h1>Registro Ventas</h1>
                <hr color="black"/>
                <p id="pa">Todos los campos son obligatorios</p>
                <hr color="black"/>
                <form action="VentasServlet?action=<%=action%>&id=${venta.idVenta}" method="post">
                    <table>
                        <tr>
                            <th><label><b>Administrador:</b></label></th>
                            <th>
                                <select name="administrador">
                                    <c:if test="${param.editar==1}">
                                        <option value="${administrador.id}">${administrador.id}</option>
                                    </c:if>
                                    <c:forEach var="admin" items="${administradores}">
                                        <option value="<c:out value="${admin.id}"/>">
                                            <c:out value="${admin.id}"/>
                                        </option>
                                    </c:forEach>    
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Cliente:</b></label></th>
                            <th>
                                <select name="cliente">
                                    <c:if test="${param.editar==1}">
                                        <option value="${cliente.id}">${cliente.id}</option>
                                    </c:if>
                                    <c:forEach var="cliente" items="${clientes}">
                                        <option value="<c:out value="${cliente.id}"/>">
                                            <c:out value="${cliente.id}"/>
                                        </option>
                                    </c:forEach>    
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Vehiculo:</b></label></th>
                            <th>
                                <select name="vehiculo">
                                    <c:if test="${param.editar==1}">
                                        <option value="${vehiculo.matricula}">${vehiculo.matricula}</option>
                                    </c:if>
                                    <c:forEach var="vehiculo" items="${vehiculos}">
                                        <option value="<c:out value="${vehiculo.matricula}"/>">
                                            <c:out value="${vehiculo.matricula}"/>
                                        </option>
                                    </c:forEach>    
                                </select>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Precio:</b></label></th>
                            <th>
                                <input type="number" placeholder="ingrese precio" class="it" name="precio" required value="${venta.precio}"/>
                            </th>
                        </tr>
                    </table> 
                    <input class="is" type="submit" name="action" value="Registrar"> 
                    <input class="is" type="reset" name="action" value="Limpiar">           
                </form> 
                <br>
            </div>
            <footer id="fter">
                <p>Trabajo realizado para la materia Arquitectura de Software</p>
                <p>Código fuente: <a href="https://github.com/juanArias8/ArqPractica1">git</a></p>
            </footer>
        </div>
    </body>
</html>
