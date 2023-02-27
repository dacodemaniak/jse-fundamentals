package fr.aelion.helpers.dto;

import java.lang.reflect.Field;
import java.util.*;

public class DtoMapper {
    /**
     * Transform the Object m to Object o
     * @param m Media Object i want to transform
     * @param o Dto Object i want to obtain
     * @return Object dto Object
     */
    public String[] map(Object m, Object dto) {
        // Introspect a class to get declared fields
        Field[] oFields = dto.getClass().getDeclaredFields();

        // Sets a String array (property names)
        String[] properties = new String[oFields.length];

        // Loop over all properties from oFields and store name of properties to fields array
        int i = 0;
        for (Field oField : oFields) {
            properties[i] = oField.getName();
            i++;
        }


        // Mutate the fields array in reverse order of String (mean from Z to A)
        Arrays.sort(properties, Collections.reverseOrder());

        return properties;
    }
}
