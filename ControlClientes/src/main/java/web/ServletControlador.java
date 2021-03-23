package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author HectorLopez
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "editar":
                    this.editarCliente(request, response);
                default:
                    this.accionDefault(request, response);
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes){
        double saldoTotal = 0;
        for(Cliente cliente : clientes){
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                default:
                    this.accionDefault(request, response);
            }
        }
    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String mail = request.getParameter("mail");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if(saldoString != null && !"".equals(saldoString)){
            saldo = Double.parseDouble(saldoString);
        }
        Cliente cliente = new Cliente(nombre, apellido, mail, telefono, saldo);
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("Registros Modificados =>" + registrosModificados);
        this.accionDefault(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idCliente =Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String mail = request.getParameter("mail");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if(saldoString != null && !"".equals(saldoString)){
            saldo = Double.parseDouble(saldoString);
        }
        Cliente cliente = new Cliente(idCliente, nombre, apellido, mail, telefono, saldo);
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("Registros modificados =>" + registrosModificados);
        this.accionDefault(request, response);
    }

}
