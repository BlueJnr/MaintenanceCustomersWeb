<%@page import="bluejnr.service.CustomerService"%>
<%@page import="bluejnr.service.CustomerService"%>
<%@page import="bluejnr.beans.CustomerTO"%>
<%@page import="bluejnr.util.Util"%>
<%@page import="bluejnr.beans.daos.DaoFactory"%>
<%@page import="bluejnr.beans.daos.DaoFactory"%>
<%@page import="java.util.List"%>

<%
    // scriplet de java
    DaoFactory factory = DaoFactory.getInstance();
    CustomerService service = factory.getCustomerDao(Util.CST);
    CustomerTO customerTO = service.findCustomer(Integer.parseInt(request.getParameter("cCodigo")));
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Clientes! ::::: </title>
    </head>
    <body>
        <h1>Ingrese datos del cliente a eliminar!</h1>
        <form action="cController">
            Codigo:<input name="txtCodigo" value="<%= customerTO.getIdCustomer()%>" readonly="true" /><br/>
            Apellidos<input name="txtApellidos"  value="<%= customerTO.getSurnames()%>" readonly="true"/><br/>
            Nombres:<input name="txtNombres"  value="<%= customerTO.getNames()%>" readonly="true"/><br/>
            Correo:<input name="txtCorreo"  value="<%= customerTO.getEmail()%>" readonly="true"/><br/>
            Telefono:<input name="txtTelefono"  value="<%= customerTO.getTelephone()%>" readonly="true"/><br/>
            Total Compras:<input name="txtTotalCompras"  value="<%= customerTO.getTotalPurchases()%>" /><br/>
            <input name="accion" type="hidden" value="eliminar"/><br/>
            <input type="submit" value="eliminar"/>
        </form>
    </body>
</html>