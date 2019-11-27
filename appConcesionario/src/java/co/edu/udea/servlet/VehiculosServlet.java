package co.edu.udea.servlet;

import co.edu.udea.ejb.VehiculosFacadeLocal;
import co.edu.udea.ejb.VentasFacadeLocal;
import co.edu.udea.entity.Vehiculos;
import co.edu.udea.entity.Ventas;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Juan Diego
 */
@MultipartConfig(maxFileSize = 16177215)//16MB
public class VehiculosServlet extends HttpServlet {

    @EJB
    private VentasFacadeLocal ventasFacade;

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
            String url = "index.jsp";
            String action = request.getParameter("action");
            String codigo = request.getParameter("code"); //permite saber si se requiere texto !=1 o imagen ==1
            String vehmatricula = request.getParameter("matricula"); //Buscar el vehiculo para obtener su foto
            byte[] data = null;

            if (codigo != null && "1".equalsIgnoreCase(codigo)) {
                List<Vehiculos> listaVehiculos = vehiculosFacade.findAll(); //Obtiene todos los vehiculos en la BD

                //Busca el vehículo requerido
                for (Vehiculos vehiculo : listaVehiculos) {
                    String mat = vehiculo.getMatricula();
                    if (mat.equalsIgnoreCase(vehmatricula)) {
                        data = vehiculo.getImagen();
                    }
                }
                //Envía la imagen a la vista del vehículo            
                response.reset();
                response.setContentType("image/jpeg");
                response.getOutputStream().write(data);
                response.getOutputStream().flush();
                response.getOutputStream().close();

            } else {
                response.setContentType("text/html;charset=UTF-8");
            }
            if ("ingresar".equalsIgnoreCase(action)) {
                String matricula = request.getParameter("matricula");
                String marca = request.getParameter("marca");
                String modelo = request.getParameter("modelo");
                int precio = Integer.parseInt(request.getParameter("precio"));
                InputStream inputStream;
                //Obtiene la parte del archivo a cargar en la peticion (multipart)
                Part filePart = request.getPart("imagen");
                byte[] foto = null;
                //valida que no esté vacio el archivo
                if (filePart != null) {
                    //Obtiene el input stream del archivo cargado y lo almacena como un arreglo de bytes
                    inputStream = filePart.getInputStream();
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    for (int longitud = 0; (longitud = inputStream.read(buffer)) > 0;) {
                        output.write(buffer, 0, longitud);
                    }
                    foto = output.toByteArray();
                }
                Vehiculos vehiculo = new Vehiculos(matricula, marca, modelo, precio, foto);
                vehiculosFacade.create(vehiculo);
                url = "VehiculosServlet?action=list";
            } else if ("agregar".equalsIgnoreCase(action)) {
                url = "registrarVehiculos.jsp";
            } else if ("delete".equalsIgnoreCase(action)) {
                String id = request.getParameter("id");
                Vehiculos v = vehiculosFacade.find(id);
                List<Ventas> ventas = ventasFacade.findAll();
                for (Ventas venta : ventas) {
                    if (v.getMatricula().equals(venta.getMatriculaCoche().getMatricula())) {
                        ventasFacade.remove(venta);
                    }
                }
                vehiculosFacade.remove(v);
                url = "VehiculosServlet?action=list";
            } else if ("list".equalsIgnoreCase(action)) {
                List<Vehiculos> findAll = vehiculosFacade.findAll();
                request.getSession().setAttribute("vehiculos", findAll);
                url = "vehiculos.jsp";
            } else if ("listIndex".equalsIgnoreCase(action)) {
                List<Vehiculos> findAll = vehiculosFacade.findAll();
                request.getSession().setAttribute("vehiculos", findAll);
            } else if ("editar".equalsIgnoreCase(action)) {
                String id = request.getParameter("id");
                Vehiculos v = vehiculosFacade.find(id);
                request.getSession().setAttribute("vehiculo", v);
                url = "registrarVehiculos.jsp?editar=1";
            } else if ("edit".equalsIgnoreCase(action)) {
                String matricula = request.getParameter("matricula");
                String marca = request.getParameter("marca");
                String modelo = request.getParameter("modelo");
                int precio = Integer.parseInt(request.getParameter("precio"));
                byte[] foto = null;
                InputStream inputStream;
                //Obtiene la parte del archivo a cargar en la peticion (multipart)
                if (request.getPart("imagen").getSize() == 0) {
                    foto = vehiculosFacade.find(matricula).getImagen();
                } else {
                    Part filePart = request.getPart("imagen");
                    //valida que no esté vacio el archivo
                    if (filePart != null) {
                        //Obtiene el input stream del archivo cargado y lo almacena como un arreglo de bytes
                        inputStream = filePart.getInputStream();
                        ByteArrayOutputStream output = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        for (int longitud = 0; (longitud = inputStream.read(buffer)) > 0;) {
                            output.write(buffer, 0, longitud);
                        }
                        foto = output.toByteArray();
                    }
                }
                Vehiculos vehiculo = new Vehiculos(matricula, marca, modelo, precio, foto);
                vehiculosFacade.edit(vehiculo);
                url = "VehiculosServlet?action=list";
            } else if ("buscar".equalsIgnoreCase(action)) {
                Vehiculos v = vehiculosFacade.find(request.getParameter("buscar"));
                if (v != null) {
                    List<Vehiculos> findAll = new ArrayList();
                    findAll.add(v);
                    request.getSession().setAttribute("vehiculos", findAll);
                    url = "vehiculos.jsp";
                } else {
                    url = "vehiculos.jsp?error=1";
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
