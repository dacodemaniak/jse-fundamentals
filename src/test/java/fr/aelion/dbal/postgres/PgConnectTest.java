package fr.aelion.dbal.postgres;

import fr.aelion.dbal.DbConnect;
import fr.aelion.helpers.properties.PropertiesUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class PgConnectTest {
    private DbConnect pgConnect = PgConnect.getInstance();
    private PropertiesUtil propertiesUtil = new PropertiesUtil();

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Should have an url")
    void propertiesHasUrlProperty() {
        Properties properties = propertiesUtil.loadProperties();
        assertEquals(true, properties.containsKey("url"));
    }

    @Test
    @DisplayName("pgConnect should be an instance of 'PgConnect'")
    public void isAPgConnectInstance() {
        assertEquals(true, pgConnect instanceof PgConnect);
    }

    @Test
    @DisplayName("Should get an instance of Connection")
    public void gotAConnectionInstance() {
        try {
            Connection connection = pgConnect.connect();
            assertEquals(true, connection instanceof Connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}