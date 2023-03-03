package fr.aelion.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cursor {
    private ResultSet resultSet;

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void next() throws Exception {
        if (!this.resultSet.next()) {
            throw new Exception("Plus de lignes à lire");
        }
    }
}
