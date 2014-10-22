
package com.fpmislata.banco.dominio;

/**
 *
 * @author Cycycorp
 */
public class EntidadBancaria {
    
    //Atributos
    int idEntidadBancaria;
    String nombre, codigo;

    //Constructor vacio
    public EntidadBancaria() {    
    }

    //Constructor con parametros
    public EntidadBancaria(int idEntidadBancaria, String nombre, String codigo) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    //Metodos
    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
