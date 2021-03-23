<section id="actions" class="py-4 mb-4" style="background: #ffd452">
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                 
                  <div class="collapse" id="collapseExample" >
                      <form action="${pageContext.request.contextPath}/UsuarioDao?accion=listar&idUser=${usuario.idUser}">
                          <input type="email" placeholder="email"><input type="password" placeholder="contraseña">
                      </form>
                        
                  </div>
            </div>
            <div class="col-md-4" style="margin-left: 100px">
               <h4 style=" color:white; background-color: #262626; text-align: center; border-radius: 10px">Tenemos ${totalRecetas} recetas a tu alcance</h4>
            </div>
            <div class="col-md-3" style="margin-left: 100px">
                <button class="btn btn-dark" onclick="buscar()">Buscar</button>
            <script>
            function buscar() {
                var search = prompt("Busca una receta:");
                    find(search);
            }
            </script>
            </div>
        </div>
    </div>
</section>