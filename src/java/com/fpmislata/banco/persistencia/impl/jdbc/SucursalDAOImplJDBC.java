
package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.SucursalDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connection.ConnectionFactory;
import com.fpmislata.banco.persistencia.impl.jdbc.connection.impl.ConnectionFactoryImplDataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class SucursalDAOImplJDBC implements SucursalDAO{

    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSource();
    Connection connection;
    
    @Override
    public SucursalBancaria get(Integer idSucursal) {
        try {
            SucursalBancaria sucursal;
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM "
                                 + "sucursalbancaria WHERE idSucursal=?");
            preparedStatement.setInt(1, idSucursal);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sucursal = new SucursalBancaria(resultSet.getInt("idSucursal"),
                                                      resultSet.getString("localizacion"), 
                                                      resultSet.getString("codigoSucursal"), 
                                                      resultSet.getString("entidadBancaria"),
                                                      resultSet.getString("nombreSucursal"));
            } else {
                sucursal = null;
            }
            connectionFactory.close(connection);
            return sucursal;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public SucursalBancaria insert(SucursalBancaria sucursal) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement preparedStatement;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO sucursalbancaria VALUES(null,?,?,?,?)");
            preparedStatement.setString(1, sucursal.getLocalizacion());
            preparedStatement.setString(2, sucursal.getCodigoSucursal());
            preparedStatement.setString(3, sucursal.getEntidadBancaria());
            preparedStatement.setString(4, sucursal.getNombreSucursal());
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
            return sucursal;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public SucursalBancaria update(SucursalBancaria sucursal) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement preparedStatement;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE sucursalbancaria "
                    + "SET localizacion=?,codigoSucursal=?,entidadBancaria=?,nombreSucursal=? "
                    + "WHERE idSucursal=?");
            preparedStatement.setString(1, sucursal.getLocalizacion());
            preparedStatement.setString(2, sucursal.getCodigoSucursal());
            preparedStatement.setString(3, sucursal.getEntidadBancaria());
            preparedStatement.setString(4, sucursal.getNombreSucursal());
            preparedStatement.setInt(5, sucursal.getIdSucursal());
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
            return sucursal;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void delete(Integer idSucursal) {
        try {
            PreparedStatement preparedStatement;
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM sucursalbancaria"
                    + " WHERE idsucursal=?");
            preparedStatement.setInt(1, idSucursal);
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public List<SucursalBancaria> findAll() {
        List list=new ArrayList();
        try{
            SucursalBancaria sucursal;
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM sucursalbancaria");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(
                new SucursalBancaria(resultSet.getInt("idSucursal"),
                                                      resultSet.getString("localizacion"), 
                                                      resultSet.getString("codigoSucursal"), 
                                                      resultSet.getString("entidadBancaria"),
                                                      resultSet.getString("nombreSucursal"))
                    );
            }
            connectionFactory.close(connection);
            return list;  
        }catch(Exception ex){
            throw new RuntimeException(ex);   
        }
    }

}
