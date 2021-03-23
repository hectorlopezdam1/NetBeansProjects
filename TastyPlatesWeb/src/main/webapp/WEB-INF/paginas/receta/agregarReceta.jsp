<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="agregarRecetaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header" style="background: #ffd452">
                <h5 class="modal-title">Agregar receta</h5>
                <button class="btn btn-dark" data-dismiss="modal">
                    <i class="fas fa-times"></i>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated" style="background: #ffedb5">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="ingredientes">Ingredientes</label>
                        <textarea type="text" class="form-control" name="ingredientes" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="pasos">Pasos</label>
                        <textarea type="text" class="form-control" name="pasos" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="puntuacion">Dificultad</label>
                        <input type="number" class="form-control" name="puntuacion" required>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <textarea type="text" class="form-control" name="descripcion" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="imagen">URL Imagen</label>
                        <input type="text" class="form-control" name="imagen" required>
                    </div>
                    <div class="form-group">
                        <label for="vegano">Vegano</label>
                        <input class="form-check-input" type="checkbox" name="vegano" value="true"> 
                    </div>                                     
                </div>
                <div class="modal-footer">
                    <button class="btn btn-dark" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>