/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.controllers;

import bluejnr.beans.CustomerTO;
import bluejnr.beans.daos.DaoFactory;
import bluejnr.service.CustomerService;
import bluejnr.util.Util;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emaravi
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/cController"})
public class CustomerController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String names = request.getParameter("txtNombres");
        String surnames = request.getParameter("txtApellidos");
        String email = request.getParameter("txtCorreo");
        String telephone = request.getParameter("txtTelefono");
        double totalPurchases = Double.parseDouble(request.getParameter("txtTotalCompras"));
        String accion = request.getParameter("accion");
        
        DaoFactory factory = DaoFactory.getInstance();
        CustomerService service = factory.getCustomerDao(Util.CST);
        CustomerTO customerTO = new CustomerTO(0, surnames, names, email, telephone,totalPurchases);
        
        switch(accion){
            case "insertar": {
                service.createCustomer(customerTO);
                break;
            }
            case "eliminar":{
                customerTO.setIdCustomer(Integer.parseInt(request.getParameter("txtCodigo")));
                service.deleteCustomer(customerTO.getIdCustomer());
                break;
            }
            case "actualizar":{
                customerTO.setIdCustomer(Integer.parseInt(request.getParameter("txtCodigo")));
                service.updateCustomer(customerTO);
                break;
            }
        }
        response.sendRedirect("msg.jsp");
        
    }

   
    
}
