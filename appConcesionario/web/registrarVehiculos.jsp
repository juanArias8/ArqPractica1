<%-- 
    Document   : registrarVehiculos
    Created on : 21-feb-2017, 20:30:43
    Author     : Juan Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/registraVehiculoStyle.css">
        <title>Registrar Vehiculo</title>
    </head>
    <body>
        <%! String action = "ingresar";%>
        <c:if test="${param.editar == 1}">
            <% action = "edit";%>
            <div id="imagenCargada">
                <img src="${vehiculo.getFotoBase64()}" alt="No se ha podido cargar la imagen" height="90%" width="90%" />
            </div>
        </c:if>
        <div id="body">
            <nav id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
                </nav>
                
            <div id="contenido">
                <h1>Registro Vehiculo</h1>
                <hr color="black"/>
                <p id="pa">Todos los campos son obligatorios</p>
                <hr color="black"/>
                <form action="./VehiculosServlet?action=<%=action%>" method="POST"  enctype="multipart/form-data">
                    <table>
                        <tr>
                            <th><label><b>Matrícula:</label></b></th>
                            <th><input type="text" name="matricula" class="it" required placeholder="Matrícula" value="${vehiculo.matricula}"/> </th>
                        </tr>
                        <tr>
                            <th><label><b>Marca:</label></b></th>
                            <th><input type="text" name="marca" class="it" placeholder="Marca" value="${vehiculo.marca}"/></th>
                        </tr>
                        <tr>
                            <th><label><b>Modelo:</label></b></th>
                            <th><input type="text" name="modelo" class="it" placeholder="Modelo" value="${vehiculo.modelo}"/> </th>
                        </tr>
                        <tr>
                            <th><label><b>Precio</label></b></th>
                            <th><input type="number" name="precio" class="it" placeholder="Precio" value="${vehiculo.precio}"  /></th>
                        </tr>
                        <tr>
                            <th><label><b>Foto</label></b></th>
                            <th><input id="inFile" type="file" name="imagen" class="it" value="${vehiculo.imagen}" required/> </th>
                        </tr>  
                    </table>
                    <input class="is" type="submit" name="ingresar" value="Agregar"/>
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
