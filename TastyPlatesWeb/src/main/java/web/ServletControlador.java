
package web;

import datos.RecetaDaoJDBC;
import datos.UsuarioDao;
import dominio.Receta;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Hector Lopez
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    boolean check = true;

    private void accionDefault(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        List<Receta> recetas = new RecetaDaoJDBC().listar();
        System.out.println("recetas = " + recetas);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("recetas", recetas);
        sesion.setAttribute("totalRecetas", recetas.size());
        
        if(check){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("recetas.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        String email = req.getParameter("emailUser");
        String password = req.getParameter("passwordUser");
        System.out.println(email + password);
        UsuarioDao us = new UsuarioDao();
        System.out.println(us.checkLogin(email, password));
     
        if(us.checkLogin(email, password)){
            resp.sendRedirect("recetas.jsp");
            return;
        }
        
        String accion = req.getParameter("accion");
        if(accion != null){
            check = false;
            switch(accion){
                case "editar":
                    this.editarReceta(req,resp);
                    break;
                case "eliminar":
                    this.eliminarReceta(req,resp);
                    break;
                case "visualizar":
                    this.visualizarReceta(req, resp);
                    break;
                default:
                    this.accionDefault(req, resp);
            }
        }else{
            this.accionDefault(req, resp);
        }
    }
    
    private void editarReceta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int idReceta = Integer.parseInt(req.getParameter("idReceta"));
        Receta receta = new RecetaDaoJDBC().encontrar(new Receta(idReceta));
        System.out.println(receta);
        req.setAttribute("receta", receta);
        String jspEditar = "/WEB-INF/paginas/receta/editarReceta.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }
    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String accion = req.getParameter("accion");
        if(accion != null){
            check = false;
            switch(accion){
                case "insertar":
                    this.insertarReceta(req, resp);
                    break;
                case "modificar":
                    this.modificarReceta(req, resp);
                    break;
                default:
                    this.accionDefault(req, resp);
            }
        }else{
            this.accionDefault(req, resp);
        }
    }
    
    private void insertarReceta(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String ingredientes = req.getParameter("ingredientes");
        String pasos = req.getParameter("pasos");
        String puntuacionString = req.getParameter("puntuacion");
        float puntuacion = 0;
        if(puntuacionString != null && !"".equals(puntuacionString)){
            puntuacion = Float.parseFloat(puntuacionString);
        }
        String veganoString = req.getParameter("vegano");
        boolean vegano = false;
        if(veganoString != null && !"".equals(veganoString)){
            vegano = Boolean.parseBoolean(veganoString);
        }else{
            vegano = false;
        }
        
        String imagen = req.getParameter("imagen");
        String descripcion = req.getParameter("descripcion");
        
        
        Receta receta = new Receta(nombre, ingredientes, pasos, puntuacion, vegano, imagen, descripcion);
        
        int registrosModificados = new RecetaDaoJDBC().insertar(receta);
        System.out.println("Registros Modificados =>" + registrosModificados);
        
        this.accionDefault(req, resp);
    }
    
    private void modificarReceta(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String idString = req.getParameter("idReceta");
        String nombre = req.getParameter("nombre");
        String ingredientes = req.getParameter("ingredientes");
        String pasos = req.getParameter("pasos");
        String puntuacionString = req.getParameter("puntuacion");
        float puntuacion = 0;
        if(puntuacionString != null && !"".equals(puntuacionString)){
            puntuacion = Float.parseFloat(puntuacionString);
        }
        String veganoString = req.getParameter("vegano");
        boolean vegano = false;
        if(veganoString != null && !"".equals(veganoString)){
            vegano = Boolean.parseBoolean(veganoString);
        }else{
            vegano = false;
        }
        System.out.println(veganoString);
        System.out.println(vegano);
        String imagen = req.getParameter("imagen");
        String descripcion = req.getParameter("descripcion");
        int id = 0;
        if(idString != null && !"".equals(idString)){
            id = Integer.parseInt(idString);
        }
        
        
        Receta receta = new Receta(id, nombre, ingredientes, pasos, puntuacion, vegano, imagen, descripcion);
        
        int registrosModificados = new RecetaDaoJDBC().actualizar(receta);
        System.out.println("Registros Modificados => " + registrosModificados);
        
        this.accionDefault(req, resp);
    }
    
    private void eliminarReceta(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int idReceta = Integer.parseInt(req.getParameter("idReceta"));
        Receta receta = new Receta(idReceta);
        int registrosModificados = new RecetaDaoJDBC().eliminar(receta);
        System.out.println("Registros Modificados=> " + registrosModificados);
        
        this.accionDefault(req, resp);
    }
    
    private void visualizarReceta(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int idReceta = Integer.parseInt(req.getParameter("idReceta"));
        Receta receta = new RecetaDaoJDBC().encontrar(new Receta(idReceta));
        System.out.println(receta);
        req.setAttribute("receta", receta);
        String jspVisualizar = "/WEB-INF/paginas/receta/visualizarReceta.jsp";
        req.getRequestDispatcher(jspVisualizar).forward(req, resp);
    }
    
    
}