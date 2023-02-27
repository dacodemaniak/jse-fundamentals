package fr.aelion.helpers.dto;

import fr.aelion.helpers.dto.annotations.ClassInitial;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

        // Sets a String array (property names)
        String[] properties = new String[oFields.length];

        // Loop over all properties from oFields and store name of properties to fields array
        int i = 0;
        for (Field oField : oFields) {
            properties[i] = oField.getName();
            i++;
        }


        // Loop over properties
        i = 0;
        for (String property : properties) {
            Annotation annotation = oFields[i].getAnnotation(ClassInitial.class);
            if (annotation == null) {
                // Create a String that represents the get method of m Object
                String getter = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
                // occ1 : getter <- getTitle
                // occ2 : getter <- getDuration
                Method method = m.getClass().getSuperclass().getDeclaredMethod(getter, null);
                // Set the same property in dto from getter of m Object
                oFields[i].set(dto, method.invoke(m, null));
            } else {
                // Initial annotation is present so do the job
                String initial = m.getClass().getSimpleName().substring(0, 1);
                oFields[i].set(dto, initial);
            }

            i++;
        }
        return dto;
    }
}
