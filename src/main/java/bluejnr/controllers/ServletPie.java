package bluejnr.controllers;

import bluejnr.beans.daos.DaoFactory;
import bluejnr.service.CustomerService;
import bluejnr.util.Util;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

@WebServlet(name = "ServletPie", urlPatterns = {"/sPie"})
public class ServletPie extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private PieDataset createDataset() {
        DefaultPieDataset datos = new DefaultPieDataset();

        DaoFactory factory = DaoFactory.getInstance();
        CustomerService service = factory.getCustomerDao(Util.CST);
        
        service.getCustomers().stream()
                .forEach(customer -> 
                        datos.setValue(customer.getNames(), 
                                        customer.getTotalPurchases()));

        return datos;
    }

    private JFreeChart createChart(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Gráfico Pie Total Compras", piedataset, true, true, false);
        PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();
        pieplot3d.setStartAngle(290D);
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        pieplot3d.setForegroundAlpha(0.5F);

        return jfreechart;
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        //--------------------------------------------------
        PieDataset pie = createDataset();
        JFreeChart grafico = createChart(pie);

        ChartUtilities.writeChartAsJPEG(out, grafico, 500, 300);
        //--------------------------------------------------
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
}
