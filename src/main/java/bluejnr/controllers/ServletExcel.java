package bluejnr.controllers;

import bluejnr.beans.CustomerTO;
import bluejnr.beans.daos.DaoFactory;
import bluejnr.service.CustomerService;
import bluejnr.util.Util;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.poi.hssf.usermodel.*;

@WebServlet(name = "ServletExcel", urlPatterns = {"/sExcel"})
public class ServletExcel extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        DaoFactory factory = DaoFactory.getInstance();
        CustomerService service = factory.getCustomerDao(Util.CST);

        response.setContentType("application/vnd.ms-excel");
        HSSFWorkbook wb = new HSSFWorkbook();				// crea libro
        HSSFSheet sheet = wb.createSheet("Hoja Clientes");	// crea hoja

        HSSFRow row1 = sheet.createRow((short) 0);			// crea fila1
        HSSFCell a1 = row1.createCell((short) 0);			// crea A1
        HSSFCell b1 = row1.createCell((short) 1);                       // crea B1
        HSSFCell c1 = row1.createCell((short) 2);			// crea C1
        HSSFCell d1 = row1.createCell((short) 3);                       // crea D1
        HSSFCell e1 = row1.createCell((short) 4);			// crea E1
        HSSFCell f1 = row1.createCell((short) 5);                       // crea F1
        
        a1.setCellValue("ID");
        b1.setCellValue("Apellidos");
        c1.setCellValue("Nombres");
        d1.setCellValue("Correo");
        e1.setCellValue("Telefono");
        f1.setCellValue("Total Compras");
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
        b1.setCellStyle(cellStyle);

        int i = 1;
        for (CustomerTO customerTO : service.getCustomers()) {
            HSSFRow row2 = sheet.createRow((short) i);			// crea filai
            row2.createCell((short) 0).setCellValue(customerTO.getIdCustomer());	// Ai
            row2.createCell((short) 1).setCellValue(customerTO.getSurnames());          // Bi
            row2.createCell((short) 2).setCellValue(customerTO.getNames());             // Ci
            row2.createCell((short) 3).setCellValue(customerTO.getEmail());             // Di
            row2.createCell((short) 4).setCellValue(customerTO.getTelephone());         // Ei
            row2.createCell((short) 5).setCellValue(customerTO.getTotalPurchases());    // Fi
            i++;
        }

        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Construye un Excel en Java y permite su edici�n!";
    }
}
