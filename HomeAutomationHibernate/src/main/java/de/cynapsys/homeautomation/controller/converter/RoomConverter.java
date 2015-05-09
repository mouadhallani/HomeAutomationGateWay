/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller.converter;

import de.cynapsys.homeautomation.entity.Room;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author mouadh
 */
@FacesConverter("roomConverter")
public class RoomConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string.trim().equals("")) {
            return null;
        } else {
            try {

                ObjectMapper mapper = new ObjectMapper();
                
                mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
                
                System.out.println(string);
                String roomString=string;
                roomString = roomString.replaceFirst("Room", "");
                roomString = roomString.replaceFirst("\r\n", "");
                roomString = roomString.replaceAll("=", ":\"");
                roomString = roomString.replaceAll(",", "\",");
                roomString = roomString.replaceAll("}", "\"}");
                Room r = mapper.readValue(roomString, Room.class);
                System.out.println("I am a converted room " + r);
                return r;

            } catch (Exception exception) {
                exception.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid room"));
            }
        }

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }

}
