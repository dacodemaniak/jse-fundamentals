package fr.aelion.dbal.postgres;

import fr.aelion.dbal.DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgConnect extends DbConnect {
    private static PgConnect instance;

    private Connection connection;

    private PgConnect() {}

    public static DbConnect getInstance() {
        if (PgConnect.instance == null) {
            PgConnect.instance = new PgConnect();
        }
        return PgConnect.instance;
    }

    @Override
    public Connection connect() throws SQLException {
        this.readProperties();
        this.connection = DriverManager.getConnection(this.dsn, this.username, this.password);
        return this.connection;
    }

    @Override
    public void disconnect() throws SQLException {
        this.connection.close();
    }
}
