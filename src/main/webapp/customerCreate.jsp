<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Clientes! ::::: </title>
    </head>
    <body>
        <h1>Ingrese datos de un nuevo Curso!</h1>
        <form action="cController">
            Apellidos<input name="txtApellidos"/><br/>
            Nombres:<input name="txtNombres"/><br/>
            Correo:<input name="txtCorreo"/><br/>
            Telefono:<input name="txtTelefono"/><br/>
            Total Compras:<input name="txtTotalCompras"/><br/>
            <input name="accion" type="hidden" value="insertar"/><br/>
            <input type="submit" value="Insertar"/>
        </form>
    </body>
</html>