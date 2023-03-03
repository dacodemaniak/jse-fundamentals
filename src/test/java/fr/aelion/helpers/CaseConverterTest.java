package fr.aelion.helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaseConverterTest {
    @Test
    @DisplayName("Should give last_name from lastName")
    void shouldConvertToSnake() {
        assertEquals("last_name", CaseConverter.camelToSnake("lastName"));
    }

    @Test
    @DisplayName("Should give lastName from last_name")
    void shouldConvertToCamel() {
        assertEquals("lastName", CaseConverter.snakeToCamel("last_name"));
    }
}