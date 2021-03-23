<%-- 
    Document   : register
    Created on : 14 mar. 2021, 19:28:48
    Author     : HectorLopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
     <video autoplay muted loop id="myVideo"style="position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;">
  <source src="./img/foodvideo.mp4" type="video/mp4">
</video>
    <head>
            <title>My Awesome Login Page</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c2acb75dc.js" crossorigin="anonymous"></script>
    </head>
    <!--Coded with love by Mutiullah Samim-->
    <body>
        <div class="container-fluid" class="container-fluid"
             style=" position: fixed;
             background: rgba(0, 0, 0, 0.25);
                    color: #f1f1f1;
                    padding: 150px;">
                    <div class="d-flex justify-content-center h-100">
                            <div class="user_card" style="background: rgba(0, 0, 0, 0.5); border-radius: 10px">
                                    <div class="d-flex justify-content-center" style="margin-top: 20px; margin-left: 20px; margin-right: 20px; margin-bottom: 5px;">
                                            <div class="brand_logo_container">
                                                <h1><i class="fas fa-utensils" ></i> Tasty Plates</h1>
                                            </div>
                                    </div>
                                    <div class="d-flex justify-content-center form_container">
                                        <form action="" method="POST">
                                            <div class="input-group mb-2">
                                                            <div class="input-group-append">
                                                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                                            </div>
                                                            <input type="text" name="nombre" class="form-control input_pass" value="" placeholder="nombre">
                                                    </div>
                                                    <div class="input-group mb-2">
                                                            <div class="input-group-append">
                                                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                                            </div>
                                                            <input type="text" name="apellido" class="form-control input_pass" value="" placeholder="apellido">
                                                    </div>
                                                    <div class="input-group mb-2">
                                                            <div class="input-group-append">
                                                                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                                                            </div>
                                                            <input type="email" name="email" class="form-control input_user" value="" placeholder="email">
                                                    </div>
                                                    <div class="input-group mb-2">
                                                            <div class="input-group-append">
                                                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                                            </div>
                                                            <input type="password" name="password" class="form-control input_pass" value="" placeholder="password">
                                                    </div>
                                                    
                                                    
                                                            <div class="d-flex justify-content-center mt-3 login_container">
                                                                <button type="submit" name="registerbtn" class="btn btn-dark">Registrarse</button>
                                                            </div>
                                                            <div class="d-flex justify-content-center mt-3 login_container">
                                                                <a href="login.jsp" class="ml-2">Volver</a>
                                                            </div>
                                            
                                            </form>
                                    </div>

                            </div>
                    </div>
            </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
