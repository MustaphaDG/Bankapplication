package net.mustapha;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datatransformation {
    public static String Tojson(Object o)  {
        ObjectMapper Objectmapper=new ObjectMapper();
        String Json = null;
        try {
            Json = Objectmapper.writeValueAsString(o);
            return Json;
        } catch (JsonProcessingException e) {
            return "{";
        }




    }

}
