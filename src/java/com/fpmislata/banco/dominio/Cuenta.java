
package com.fpmislata.banco.dominio;
import java.util.Date;

/**
 *
 * @author CycyCorp
 */
public class Cuenta {
    
    //Atributos
    int idCuenta,SucursalBancaria;
    String cliente;
    double saldo;
    Date fechaCreacion;

    //Constructor vacio
    public Cuenta() {
    }
    
    //Constructor con parametros
    public Cuenta(int idCuenta, String cliente, double saldo, Date fechaCreacion, int SucursalBancaria) {
        this.idCuenta = idCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.SucursalBancaria = SucursalBancaria;
    }
    
    
    //Metodos
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getSucursalBancaria() {
        return SucursalBancaria;
    }

    public void setSucursalBancaria(int SucursalBancaria) {
        this.SucursalBancaria = SucursalBancaria;
    }
    
    
}
