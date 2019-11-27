<%-- 
    Document   : acerca
    Created on : 20/02/2017, 05:56:07 PM
    Author     : jnda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" href="http://www.e02.es/cubic/datos/docs/doc_368/logo_doc_368_creacion_logo_imagen_visual_corporativa_05_marcel_ico.png" />
        <link rel="stylesheet" href="css/acercaStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acerca</title>
    </head>
    <body>
        <div id="body">
            <nav id="menu">
            <jsp:include page="menu.jsp"></jsp:include>
        </nav>
        <div id="contenido">
            <h1>Descripción de la aplicación</h1>
                <hr color="black"/>
                <p id="p1">La aplicación presentada se ha creado con el objetivo de satisfaccer las necesidades solicitadas en 
                la práctica número uno de la materia Arquitectura de Software dictada por el profesor Diego Botia en el
                semestre 2017-2.El objetivo general de la aplicación radica en implementar lo aprendido hasta el momento en clase, 
                hacer uso de las diferentes herramientas que nos provee Java para desarrollar aplicaciones de calidad, 
                utilizando patrones de diseño, programación por capas, entre otras cosas.</p>
                <hr color="black"/>
                <h2>Integrantes</h2>
                <p>Juan David Arias</p>
                <p>Jesús David Gómez</p>
                <p>Juan Diego Goez Durango</p>
                <p>Alejandro Castañeda Villa</p>
                <p>Juan David Arias</p>
                <hr color="black"/>
                <h2>Profesor</h2>
                <p>Diego José Luis Botia</p>
        </div>
        <footer id="fter">
                <p>Trabajo realizado para la materia Arquitectura de Software</p>
                <p>Código fuente: <a href="https://github.com/juanArias8/ArqPractica1">git</a></p>
            </footer>
        </div>
    </body>
</html>
