<%-- 
    Document   : recetas
    Created on : 9 mar. 2021, 12:32:42
    Author     : hecti
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasty Plates</title>
    </head>
    <body>
        <h1>Tasty Plates</h1>
        <ul>
            <c:forEach var="receta" items="${recetas}">
                <li>
                    &{receta.idReceta} &{receta.nombre} &{receta.ingredientes} &{receta.pasos} &{receta.puntuacion} &{receta.vegano}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
