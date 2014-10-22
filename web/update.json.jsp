<%//IMPORTACIONES%>
<%@page import="com.fpmislata.banco.presentacion.json.impl.JsonConvertImplJackson"%>
<%@page import="com.fpmislata.banco.presentacion.json.JsonConvert"%>
<%@page import="java.util.Date"%>
<%@page import="com.fpmislata.banco.dominio.SucursalBancaria"%>
<%@page import="com.fpmislata.banco.persistencia.impl.jdbc.SucursalDAOImplJDBC"%>
<%@page import="com.fpmislata.banco.persistencia.SucursalDAO"%>

<%//CODIGO EMBEBIDO DE JAVA%>
<%
    //Creamos una sucursal y le pasamos los datos que queremos actualizar
    //pasandole el IdEntidadBancaria de la entidad a actualizar
        SucursalDAO sucursalDAO = new SucursalDAOImplJDBC();
        SucursalBancaria sucursalBancaria = new SucursalBancaria
            (Integer.parseInt(request.getParameter("idSucursal")),
             request.getParameter("localizacion"),
             request.getParameter("codigoSucursal"),
             request.getParameter("entidadBancaria"),
             request.getParameter("nombreSucursal"));

        
        sucursalDAO.update(sucursalBancaria);
        
        JsonConvert jsonConvert=new JsonConvertImplJackson();
        out.print(jsonConvert.toJson(sucursalBancaria));
%>