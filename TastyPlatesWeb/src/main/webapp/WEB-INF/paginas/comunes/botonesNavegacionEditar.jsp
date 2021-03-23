<section id="actions" style="background: #ffd97a; border-radius: 10px; margin-left: 100px; margin-right: 100px;" >
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <a href="index.jsp" class="btn btn-dark btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a> 
            </div>
            <div class="col-sm" >
                
            </div>
            <div class="col-sm" >
                <button style="margin-left: 48px" type="submit" class="btn btn-dark btn-block">
                    <i class="fas fa-check"></i> Guardar receta
                </button>
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idReceta=${receta.idReceta}"
                   class="btn btn-dark btn-block">
                    <i class="fas fa-trash"></i> Eliminar Receta
                </a>
            </div>
        </div>
    </div>
</section>