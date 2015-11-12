/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converter;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mary
 */

@FacesConverter(value = "converterBoolean")
public class ConverterBoolean implements Converter, Serializable{

    //converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        if (string.equals("Sim")) {
            return true;
        }else{
            return false;
        }
    }

    //converte objeto para a tela
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
       Boolean b = (Boolean) o;
       return b ? "Sim" : "Não";
    }
    
    
}
