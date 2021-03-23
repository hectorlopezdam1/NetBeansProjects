/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.psp;

import datos.RecetaDaoJDBC;
import dominio.Receta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hecti
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Receta> recetas = new RecetaDaoJDBC().listar();
            System.out.println("recetas= " + recetas);
            request.setAttribute("recetas", recetas);
            request.getRequestDispatcher("recetas.jsp").forward(request, response);
    }
}

 
