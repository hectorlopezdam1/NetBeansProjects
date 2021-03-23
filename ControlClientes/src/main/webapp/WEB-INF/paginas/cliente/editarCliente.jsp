<%-- 
    Document   : editarCliente
    Created on : 8 mar. 2021, 8:58:44
    Author     : HectorLopez
--%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width-device-width" initial-scale=1, shrink-to-fit="no">
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d045f85363.js" crossorigin="anonymous"></script>
    
    <title>Editar Cliente</title>
</head>
<body>
    <jsp:include page="/WEB-INF/paginas/comunes/encabezado.jsp"/>
    <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
          method="POST" class="was-validated">
        <section id="details">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar</h4>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control" name="nombre" required
                                           value="${cliente.nombre}">
                                </div>
                                <div class="form-group">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" class="form-control" name="apellido" required
                                           value="${cliente.apellido}">
                                </div>
                                <div class="form-group">
                                    <label for="mail">Email</label>
                                    <input type="mail" class="form-control" name="mail" required
                                           value="${cliente.mail}">
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="tel" class="form-control" name="telefono" required
                                           value="${cliente.telefono}">
                                </div>
                                <div class="form-group">
                                    <label for="saldo">Saldo</label>
                                    <input type="step" class="form-control" name="saldo" required
                                           value="${cliente.saldo}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>
    </form>
   
    <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
</body>
