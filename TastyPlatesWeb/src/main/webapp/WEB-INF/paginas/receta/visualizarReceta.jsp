<%-- 
    Document   : visualizarReceta
    Created on : 11 mar. 2021, 11:37:42
    Author     : HectorLopez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasty Plates</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c2acb75dc.js" crossorigin="anonymous"></script>   
    </head>
    <body style="background: #ffedb5">
        <jsp:include page="/WEB-INF/paginas/comunes/encabezado.jsp"/>
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        <hr>
        <h1 style="margin-left: 30px">${receta.nombre}</h1>
        <hr>
        <div class="row">
            <div class="col-md-6">
            <img style="border-radius: 50px; width: 100%; max-width:600px; margin-left: 30px;" src="${receta.imagen}">
        </div>
        <div class="col-md-6" style="background: #ffd452; border-radius: 50px;">
            <h4 style="margin-left: 30px; margin-top: 5px;">Dificultad: <c:if test="${receta.puntuacion == 1}"><span class="fa fa-star"></span></c:if>
            <c:if test="${receta.puntuacion == 2}"><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if>
            <c:if test="${receta.puntuacion == 3}"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if>
            <c:if test="${receta.puntuacion == 4}"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if>
            <c:if test="${receta.puntuacion == 5}"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if></h4>
            
            <h4 style="margin-left: 30px;"><c:if test="${not receta.vegano}">Vegano: No</c:if><c:if test="${receta.vegano}">Vegano: Sí</c:if></h4>
            <h4 style="margin-top: 10px; margin-left: 30px;">Ingredientes:</h4>
            <pre style="font-family: sans-serif; margin-left: 30px;"><h4 style=" margin-right: 30px; white-space: pre-wrap;">${receta.ingredientes}</h4></pre>
        </div>
        </div>
            
        <hr>
        <h4 style="margin-bottom: 20px; margin-left: 30px">Elaboración:</h4>
        <pre style="margin-left: 30px; margin-right: 30px; white-space: pre-wrap; font-family: sans-serif;">${receta.pasos}</pre>
        
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
