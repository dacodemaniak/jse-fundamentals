package fr.aelion.helpers.dto;

import fr.aelion.models.course.Media;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DtoMapper {
    /**
     * Transform the Object m to Object o
     * @param m Media Object i want to transform
     * @param o Dto Object i want to obtain
     * @return Object dto Object
     */
    public Object map(Object m, Object dto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Introspect a class to get declared fields
        Field[] oFields = dto.getClass().getDeclaredFields();
        // Field title + Field duration

        // Introspect dto class to get declared fields

        // Sets a String array (property names)
        String[] properties = new String[oFields.length];

        // Loop over all properties from oFields and store name of properties to fields array
        int i = 0;
        for (Field oField : oFields) {
            properties[i] = oField.getName();
            i++;
        }
        // String "title" + String "duration"

        // How to invoke dynamically a getter from a class ?
        // How to set dynamically an attribute of a class form a getter from another class ?
        // dto.fieldName = m.getFieldName();


        // Loop over properties
        // occ1 : property <- title
        // occ2 : property <- duration
        i = 0;
        for (String property : properties) {
            // Create a String that represents the get method of m Object
            String getter = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
            // occ1 : getter <- getTitle
            // occ2 : getter <- getDuration
            Method method = m.getClass().getSuperclass().getDeclaredMethod(getter, null);
            // Set the same property in dto from getter of m Object
            oFields[i].set(dto, method.invoke(m, null));
            // dto.title = video.getTitle()
            // dto.duration = video.getDuration()
            i++;
        }

        /**
         * for (int i = 0; i < properties.length; i++) {
         *  String property = properties[i];
         * }
         */
        return dto;
    }
}
