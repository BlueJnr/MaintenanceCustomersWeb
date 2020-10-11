package bluejnr.util;

import bluejnr.beans.CustomerTO;
import bluejnr.beans.daos.DaoFactory;
import bluejnr.service.CustomerService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;

public class Reporteador {

    DaoFactory factory;
    CustomerService service;

    public Reporteador() {
        factory = DaoFactory.getInstance();
        service = factory.getCustomerDao(Util.CST);
    }

    public void generaPDF(String nombre, ServletContext contexto) {
        try {

            //---------------------------------------------------------------------------------------------------------------------
            Document document = new Document(PageSize.A4, 20, 20, 20, 20);
            //document.set
            String ruta = contexto.getRealPath("/");//ruta de los JSPs

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(ruta + "/reporte.pdf"));

            System.out.println(ruta + "reporte.pdf");
            document.open();
            float[] widths = {0.25f, 0.50f, 0.50f, 0.50f, 0.50f, 0.50f};
            float[] cabecera = {1.20f, 0.23f, 0.20f};
            float[] rotulo = {1.00f};
            float[] footer = {0.27f, 0.70f, 0.13f, 0.13f, 0.2f, 0.2f};

            Paragraph p = null;
            PdfPTable table = null;
            PdfPCell cell = null;

            Font negrita = FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK);
            Font text = FontFactory.getFont("Arial", 9, Font.NORMAL, BaseColor.BLACK);
            Font normal = FontFactory.getFont("Arial", 10, Font.NORMAL, BaseColor.BLACK);

            Font linea = FontFactory.getFont("Arial", 10, Font.UNDERLINE, BaseColor.BLACK);
            /**
             * ***Insertando imagenes al PDF *************
             */
            Image logo = Image.getInstance(ruta + "/images/logo1.jpg");
            logo.scaleAbsolute(45, 50);
            logo.setAbsolutePosition(540, 790);
            document.add(logo);

            p = new Paragraph("                                                                       ");
            document.add(p);
            document.add(p);

            table = new PdfPTable(cabecera);

            p = new Paragraph("Señores", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph(nombre);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            //---------------------------------------------------------
            table = new PdfPTable(rotulo);

            p = new Paragraph("Listado de Clientes :", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            table.setTotalWidth(533);
            table.setLockedWidth(true);

            document.add(table);

            p = new Paragraph("                                                                       ");
            document.add(p);

            //---------------------------------------------------------
            table = new PdfPTable(widths);

            //idCustomer
            p = new Paragraph("ID", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            //surnames
            p = new Paragraph("Apellidos", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            //names
            p = new Paragraph("Nombres", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);
            
            //email
            p = new Paragraph("Correo", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);
            
            //telephone
            p = new Paragraph("Telefono", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);
            
            //totalPucharses
            p = new Paragraph("Total Compras", negrita);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.BLACK);
            cell.setBackgroundColor(new BaseColor(214, 214, 255));
            table.addCell(cell);

            document.add(table);

            p = new Paragraph("                                                                       ");
            document.add(p);

            //---------------------------------------------------------------------------------------------------
            for (CustomerTO customerTO : service.getCustomers()) {
                table = new PdfPTable(widths);

                //idCustomer
                p = new Paragraph(Integer.toString(customerTO.getIdCustomer()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //surnames
                p = new Paragraph(customerTO.getSurnames(), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //names
                p = new Paragraph(customerTO.getNames(), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);
                
                //email
                p = new Paragraph(customerTO.getEmail(), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //telephone
                p = new Paragraph(customerTO.getTelephone(), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                //totalpucharses
                p = new Paragraph(Double.toString(customerTO.getTotalPurchases()), text);
                cell = new PdfPCell(p);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderColor(BaseColor.BLACK);
                table.addCell(cell);

                document.add(table);
            }

            //-------------------------------------------------------------------------------
            p = new Paragraph("                                                                       ");
            document.add(p);

            table = new PdfPTable(footer);
            p = new Paragraph("Atentamente,     ", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            p = new Paragraph("", normal);
            cell = new PdfPCell(p);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderColor(BaseColor.WHITE);
            table.addCell(cell);

            table.setTotalWidth(533);
            table.setLockedWidth(true);

            document.add(table);

            document.close();

            //---------------------------------------------------------------------------------------------------------------------
        } catch (Exception de) {
            System.out.println("error: " + de.toString());
        }

    }

}
