/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.controller;

import Cliente.dao.ClienteDAOImp;
import Cliente.model.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ulises
 */
public class ClienteController extends HttpServlet {
    private static final String LISTA_CLIENTES = "/listarCliente.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/clientes.jsp";
    private ClienteDAOImp dao;
    
    public ClienteController() {
        dao = new ClienteDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_CLIENTES;
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            dao.borrarCliente(idCliente);
            request.setAttribute("clientes", dao.desplegarClientes());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            Cliente cliente = dao.elegirCliente(idCliente);
            request.setAttribute("Cliente", cliente);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_CLIENTES;
            request.setAttribute("clientes", dao.desplegarClientes());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        String idCliente = request.getParameter("idCliente");
        cliente.setNumeroCliente(request.getParameter("numeroCliente"));
        cliente.setNombreCliente(request.getParameter("nombreCliente"));
        cliente.setApellido(request.getParameter("apellido"));
         cliente.setSexo(request.getParameter("sexo"));
        cliente.setDireccion(request.getParameter("direccion"));
        if (idCliente == null || idCliente.isEmpty()) {
            dao.agregarCliente(cliente);
        } else {
            cliente.setIdCliente(Integer.parseInt(idCliente));
            dao.cambiarCliente(cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_CLIENTES);
        request.setAttribute("clientes", dao.desplegarClientes());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
