package fr.aelion.repositories;

import fr.aelion.helpers.CaseConverter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Repository<T> {
    private Class<T> model;
    private String simpleName;

    protected Repository(Class<T> className) {
        this.model = className;
        this.simpleName = model.getSimpleName().toLowerCase();
    }
    protected String getTableName() {
        return simpleName.toLowerCase();
    }

    protected String getAliasedTableName() {
        return simpleName + " " + simpleName.substring(0,1);
    }

    protected String[] getFields() {
        var current = model;
        var stringFields = new ArrayList<String>();
        while(current.getSuperclass() != null) {
            // Let's do stuff
            stringFields.addAll(
                    Arrays.asList(
                            Arrays.stream(current.getDeclaredFields())
                                    .map(f -> f.getName())
                                    .collect(Collectors.toSet())
                                    .toArray(new String[0])
                    )
            );
            current = (Class<T>) current.getSuperclass();
        }

        return stringFields.toArray(new String[0]);
    }

    protected String getCommaSeparatedColumns() {
        String[] fieldNames = this.getFields();

        String[] columnNames = Arrays.stream(fieldNames)
                .map(f -> simpleName.substring(0, 1) + "." + CaseConverter.camelToSnake(f))
                .collect(Collectors.toList())
                .toArray(new String[0]);

        Arrays.sort(columnNames);

        return String.join(",", columnNames);
    }

    protected String getSelectQuery() {
        return "SELECT " + getCommaSeparatedColumns() + " FROM " + simpleName + " " + simpleName.substring(0, 1);
    }
}
