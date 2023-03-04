package fr.aelion.dbal.builder;

import fr.aelion.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryBuilder {
    private Repository repository;
    private String select;
    private List<String> order = new ArrayList<>();
    private String where;
    private boolean whereDone = false;
    private StringBuilder sb = new StringBuilder();

    public QueryBuilder(Repository repository) {
        this.repository = repository;
    }

    public QueryBuilder select() {
        select = repository.getSelectQuery();
        return this;
    }

    public QueryBuilder order(String column) {
        order.add(column);
        return this;
    }

    public QueryBuilder where(String column) {
        where = " WHERE " + column + " = ?";
        whereDone = true;
        return this;
    }

    public QueryBuilder where(String column, String operator) {
        where = column + operator + "?";
        whereDone = true;
        return this;
    }

    public QueryBuilder andWhere(String column) {
        if (whereDone) {
            where += " AND " + column + " = ?";
        } else {
            where = "WHERE " + column + " = ?";
        }
        return this;
    }

    public QueryBuilder andWhere(String column, String operator) {
        if (whereDone) {
            where += " AND " + column + " " + operator + " ?";
        } else {
            where = "WHERE " + column + " " + operator + " ?";
            whereDone = true;
        }
        return this;
    }

    public QueryBuilder orWhere(String column) {
        if (whereDone) {
            where += " OR " + column + " = ?";
        } else {
            where = "WHERE " + column + " = ?";
            whereDone = true;
        }
        return this;
    }

    public QueryBuilder orWhere(String column, String operator) {
        if (whereDone) {
            where += " OR " + column + " " + operator + " ?";
        } else {
            where = "WHERE " + column + " " + operator + " ?";
            whereDone = true;
        }
        return this;
    }

    public String build() {
        if (select != null) {
            sb.append(select);
        }

        if (where != null && where.length() > 0) {
            sb.append(where);
        }

        if (order.size() > 0) {
            sb.append(" ORDER BY ");
            int counter = 1;
            for (String o : order) {
                if (counter < order.size()) {
                    sb.append(o).append(", ");
                } else {
                    sb.append(o);
                }
                counter++;
            }
        }
        sb.append(";");

        return sb.toString();
    }
}
