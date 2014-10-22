
package com.fpmislata.banco.presentacion.json;

public interface JsonConvert {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);

}
