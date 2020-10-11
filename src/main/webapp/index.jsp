<%-- 
    Document   : cursoMan
    Created on : 24/09/2017, 08:10:08 AM
    Author     : emaravi
--%>
<%@page import="bluejnr.beans.CustomerTO"%>
<%@page import="bluejnr.service.CustomerService"%>
<%@page import="bluejnr.util.Util"%>
<%@page import="bluejnr.beans.daos.DaoFactory"%>
<%@page import="java.util.List"%>

<%
    // scriplet de java
    DaoFactory factory = DaoFactory.getInstance();
    CustomerService service = factory.getCustomerDao(Util.CST);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Clientes</title>
    </head>
    <body>
        <h1> ::::::: Mantenimiento de Clientes :::::::</h1>
        <a href="customerCreate.jsp">Nuevo Clientes</a>
        <table border>
            <tr>
                <th>id</th>
                <th>apellidos</th>
                <th>nombres</th>
                <th>correo</th>
                <th>telefono</th>
                <th>Total Compras</th>
                <th colspan="2">operaciones</th>
            </tr>
            <%for(CustomerTO customerTO : service.getCustomers()){%>
            <tr>
                <td><%= customerTO.getIdCustomer() %></td>
                <td><%= customerTO.getSurnames()%></td>
                <td><%= customerTO.getNames()%></td>
                <td><%= customerTO.getEmail()%></td>
                <td><%= customerTO.getTelephone()%></td>
                <td><%= customerTO.getTotalPurchases()%></td>
                <td><a href="customerDelete.jsp?cCodigo=<%= customerTO.getIdCustomer()%>">Borrar</a></td>
                <td><a href="customerUpdate.jsp?cCodigo=<%= customerTO.getIdCustomer() %>">Actualizar</a></td>
            </tr>
            <%}%>
        </table>
        <h1>Reportes</h1>
        <a href="sExcel">Generar Excel</a><hr>
        <a href="sPdf">Generar Pdf</a><hr>
	<a href="sPie">Ver gráfico de pie</a><hr>
    </body>
</html>
