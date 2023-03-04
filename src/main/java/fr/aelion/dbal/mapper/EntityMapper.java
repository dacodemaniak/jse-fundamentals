package fr.aelion.dbal.mapper;

import fr.aelion.models.Student;

import javax.sql.RowSet;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityMapper<T> {
    private Class<T> entity;
    private List<Field> fields = new ArrayList<>();

    public EntityMapper(Class<T> entity) {
        this.entity = entity;
    }

    public Object map(ResultSet rs) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object realEntity = entity.getConstructor().newInstance();
        this.loadFields().forEach(f -> {
            var fieldType = f.getGenericType();
            var getter = "get" + typeOf(fieldType.getTypeName());
            try {
                Method method = this.getClass().getDeclaredMethod(getter, ResultSet.class, Field.class);
                // Make entity field temporary "visible"
                f.setAccessible(true);
                f.set(realEntity, method.invoke(this, rs, f));
                f.setAccessible(false);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        return realEntity;
    }

    protected int getInt(ResultSet rs, Field field) throws SQLException {
        return rs.getInt(field.getName());
    }

    protected String getString(ResultSet rs, Field field) throws SQLException {
        return rs.getString(field.getName());
    }
    protected List<Field> loadFields() {
        var current = entity;
        while(current.getSuperclass() != null) {
            // Let's do stuff
            for (Field field : current.getDeclaredFields()) {
                fields.add(field);
            }
            current = (Class<T>) current.getSuperclass();
        }
        return this.fields;
    }

    private String typeOf(String type) {
        if (type.indexOf(".") > 0) {
            var classPackage = type.split("\\.");
            return classPackage[classPackage.length - 1];
        }

        return type.substring(0, 1).toUpperCase() + type.substring(1);
    }
}
