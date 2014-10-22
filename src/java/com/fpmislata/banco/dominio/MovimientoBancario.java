
package com.fpmislata.banco.dominio;
import java.math.BigDecimal;

/**
 *
 * @author JuanPe
 */
public class MovimientoBancario {

    //Atributos
    int idMovimintoBancario,CuentaOrigen,CuentaDestino;
    BigDecimal cantidad;
    String motivo;

    //Constructor vacio
    public MovimientoBancario() {
    }
    
    //Constructor con parametros
    public MovimientoBancario(int CuentaOrigen, int CuentaDestino, BigDecimal cantidad, String motivo) {
        this.CuentaOrigen = CuentaOrigen;
        this.CuentaDestino = CuentaDestino;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }
    

    //Metodos
    public int getIdMovimintoBancario() {
        return idMovimintoBancario;
    }

    public void setIdMovimintoBancario(int idMovimintoBancario) {
        this.idMovimintoBancario = idMovimintoBancario;
    }

    public int getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(int CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public int getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(int CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }


    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
}
