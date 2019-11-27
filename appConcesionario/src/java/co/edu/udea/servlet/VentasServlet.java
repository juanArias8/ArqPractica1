package co.edu.udea.servlet;

import co.edu.udea.ejb.AdministradoresFacadeLocal;
import co.edu.udea.ejb.ClientesFacadeLocal;
import co.edu.udea.ejb.VehiculosFacadeLocal;
import co.edu.udea.ejb.VentasFacadeLocal;
import co.edu.udea.entity.Administradores;
import co.edu.udea.entity.Clientes;
import co.edu.udea.entity.Vehiculos;
import co.edu.udea.entity.Ventas;
import java.io.IOException;
import javax.ejb.EJB;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Diego
 */
public class VentasServlet extends HttpServlet {
    
    @EJB
    private VentasFacadeLocal ventasFacade;
    
    @EJB
    private AdministradoresFacadeLocal administradoresFacade;
    
    @EJB
    private ClientesFacadeLocal clientesFacade;
    
    @EJB
    private VehiculosFacadeLocal vehiculosFacade;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action =request.getParameter("action");
            String url="index.jsp";
            if("list".equals(action)){
                List<Ventas> findAll = ventasFacade.findAll();
                request.getSession().setAttribute("ventas",findAll);
                url = "ventas.jsp";
            }else if ("ingresar".equals(action)){
                Ventas v= new Ventas();
                v.setIdAdmin(administradoresFacade.find(request.getParameter("administrador")));
                v.setIdCliente(clientesFacade.find(request.getParameter("cliente")));
                v.setMatriculaCoche(vehiculosFacade.find(request.getParameter("vehiculo")));
                v.setPrecio(Integer.parseInt(request.getParameter("precio")));
                ventasFacade.create(v);
                url="VentasServlet?action=list";
            } else if ("delete".equals(action)){
                String id = request.getParameter("id");
                Ventas a = ventasFacade.find(Integer.valueOf(id));
                ventasFacade.remove(a);
                url="VentasServlet?action=list";
            }else if("editar".equalsIgnoreCase(action)){
                String id = request.getParameter("id");
                Ventas v = ventasFacade.find(Integer.parseInt(id));
                Administradores a = administradoresFacade.find(v.getIdAdmin().getId());
                Clientes c = clientesFacade.find(v.getIdCliente().getId());
                Vehiculos ve = vehiculosFacade.find(v.getMatriculaCoche().getMatricula());
                request.getSession().setAttribute("venta",v);
                request.getSession().setAttribute("administrador",a);
                request.getSession().setAttribute("cliente",c);
                request.getSession().setAttribute("vehiculo",ve);
                List<Administradores> administradores = administradoresFacade.findAll();
                List<Clientes> clientes = clientesFacade.findAll();
                List<Vehiculos> vehiculos = vehiculosFacade.findAll();
                administradores.remove(a);
                clientes.remove(c);
                vehiculos.remove(ve);
                request.getSession().setAttribute("administradores",administradores);
                request.getSession().setAttribute("clientes",clientes);
                request.getSession().setAttribute("vehiculos",vehiculos);
                url="registrarVentas.jsp?editar=1";
            } else if("edit".equalsIgnoreCase(action)){
                Ventas v = ventasFacade.find(Integer.parseInt(request.getParameter("id")));
                v.setIdAdmin(administradoresFacade.find(request.getParameter("administrador")));
                v.setIdCliente(clientesFacade.find(request.getParameter("cliente")));
                v.setMatriculaCoche(vehiculosFacade.find(request.getParameter("vehiculo")));
                v.setPrecio(Integer.parseInt(request.getParameter("precio")));
                ventasFacade.edit(v);
                url="VentasServlet?action=list";
            }else if("registrar".equalsIgnoreCase(action)){
                List<Administradores> administradores = administradoresFacade.findAll();
                List<Clientes> clientes = clientesFacade.findAll();
                List<Vehiculos> vehiculos = vehiculosFacade.findAll();
                request.getSession().setAttribute("administradores",administradores);
                request.getSession().setAttribute("clientes",clientes);
                request.getSession().setAttribute("vehiculos",vehiculos);
                url="registrarVentas.jsp";
            }else if("buscar".equalsIgnoreCase(action)){
                Ventas v = ventasFacade.find(Integer.parseInt(request.getParameter("buscar")));
                if (v!=null) {
                    List<Ventas> findAll = new ArrayList();
                    findAll.add(v);
                    request.getSession().setAttribute("ventas", findAll);
                    url = "ventas.jsp";
                }else{
                    url = "ventas.jsp?error=1";
                }
            }
            response.sendRedirect(url);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
