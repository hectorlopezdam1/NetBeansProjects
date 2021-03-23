<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c2acb75dc.js" crossorigin="anonymous"></script>   
        
        <title>Editar Receta</title>     
    </head>
    <body style="background: #ffedb5">
        <jsp:include page="/WEB-INF/paginas/comunes/encabezado.jsp"/>
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idReceta=${receta.idReceta}"
              method="POST" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header" style="background: #ffd452">
                                    <h4>Editar</h4>
                                </div>
                                <div class="card-body" style="background: #ffd97a">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${receta.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="ingredientes">Ingredientes</label>
                                        <textarea type="text" class="form-control" name="ingredientes" required >${receta.ingredientes}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="pasos">Pasos</label>
                                        <textarea type="text" class="form-control" name="pasos" required >${receta.pasos}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="puntuacion">Dificultad</label>
                                        <input type="number" class="form-control" name="puntuacion" required value="${receta.puntuacion}">
                                    </div>
                                    <div class="form-group">
                                        <label for="descripcion">Descripción</label>
                                        <textarea type="text" class="form-control" name="descripcion" required >${receta.descripcion}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="imagen">URL Imagen</label>
                                        <input type="text" class="form-control" name="imagen" required value="${receta.imagen}">
                                    </div>
                                    <div class="form-group">
                                        <label for="vegano">Vegano</label>
                                        <input class="form-check-input" type="checkbox" name="vegano" value="${receta.vegano}">
                                    </div>  
                                    
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEditar.jsp"/>
        </form>        
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
