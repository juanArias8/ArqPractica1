<%-- 
    Document   : registraAdmins
    Created on : 20/02/2017, 09:30:56 PM
    Author     : jnda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/registroStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Administradores</title>
    </head>
    <body>
        <div id="body">
            <nav id="menu">
                <jsp:include page="menu.jsp"></jsp:include>
            </nav>
            <div class="contenido">
                <h1>Registro Administradores</h1>
                <hr color="black"/>
                <p id="pa">*Todos los campos son obligatorios</p>
                <hr color="black"/>
                <form action="ConcesionarioServlet?action=registroAdms" method="post">
                    <table>
                        <tr>
                            <th><label><b>Identificación:</b></label></th>
                            <th>
                                <input type="text" placeholder="ingrese identificación" class="it" name="id" required=""/>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Nombre:</b></label></th>
                            <th>
                                <input type="text" placeholder="ingrese nombre" class="it" name="nombre" required=""/>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Apellidos:</b></label></th>
                            <th>
                                <input type="text" placeholder="ingrese apellidos" class="it" name="apellidos" required=""/>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Username:</b></label></th>
                            <th>
                                <input type="text" placeholder="ingrese nombre de usuario" class="it" name="username" required=""/>
                            </th>
                        </tr>
                        <tr>
                            <th><label><b>Password:</b></label></th>
                            <th>
                                <input type="password" placeholder="ingrese password" class="it" name="password" required=""/>
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