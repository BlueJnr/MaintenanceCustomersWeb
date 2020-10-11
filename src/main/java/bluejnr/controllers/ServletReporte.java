package bluejnr.controllers;

import bluejnr.util.Reporteador;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletReporte", urlPatterns = {"/sPdf"})
public class ServletReporte extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
            throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        
        Reporteador reporteador = new Reporteador();
        reporteador.generaPDF("cjava",getServletContext());
        response.sendRedirect("reporte.pdf");
    }
}
