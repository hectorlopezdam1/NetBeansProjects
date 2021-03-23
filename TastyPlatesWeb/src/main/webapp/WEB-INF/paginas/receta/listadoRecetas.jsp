
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES"/>
<section id="recetas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header" style="background: #ffd452;">
                        <h4>Nuestras recetas<a style="float: right" href="#" class="btn btn-dark btn-block"
                        accesskey=""data-toggle="modal" data-target="#agregarRecetaModal">
                        <i class="fas fa-plus"></i> Agregar Receta
                        </a></h4>
                    </div>
                        <c:forEach var="receta" items="${recetas}" varStatus="status">
                        <div class="card mb-3" style="background: #ffd452;">
                            <img class="card-img-top" src="${receta.imagen}" alt="Imagen del plato">
                            <div class="card-body" style="background: #ffd452">
                              <h5 class="card-title">${receta.nombre}</h5>
                              <p class="card-text">Dificultad: <c:if test="${receta.puntuacion == 1}"><span class="fa fa-star"></span></c:if>
                                                                <c:if test="${receta.puntuacion == 2}"><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if>
                                                                <c:if test="${receta.puntuacion == 3}"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if>
                                                                <c:if test="${receta.puntuacion == 4}"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if>
                                                                <c:if test="${receta.puntuacion == 5}"><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span><span class="fa fa-star"></span></c:if></p>
                              <p class="card-text">${receta.descripcion}</p>
                              <a href="${pageContext.request.contextPath}/ServletControlador?accion=visualizar&idReceta=${receta.idReceta}" class="btn btn-dark">¡A cocinar!</a>
                              <a style="margin-left: 600px;"href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idReceta=${receta.idReceta}"
                                       class="btn btn-dark"><i class="fas fa-edit"></i>
                              </a>
                              <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idReceta=${receta.idReceta}"
                                       class="btn btn-dark"><i class="fas fa-trash"></i>
                              </a>   
                            </div>
                        </div>
                        </c:forEach>
                </div>
            </div>
            <div class="col-md-3">
                
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/receta/agregarReceta.jsp"/>
    
