/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Mary
 */
@FacesConverter(value = "converterCalendar")
public class ConverterCalendar implements Converter, Serializable{

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        Calendar retorno = Calendar.getInstance();
        try {
            retorno.setTime(sdf.parse(string));
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
       Calendar obj = (Calendar) o;
       return sdf.format(obj.getTime());
    }

    
}
