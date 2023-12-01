package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.isLicensePlate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    void isLicensePlateTest() {
        assertTrue(isLicensePlate("А123ВЕ777"));
        assertTrue(isLicensePlate("О777ОО177"));

        assertFalse(isLicensePlate("123АВЕ777"));
        assertFalse(isLicensePlate("А123ВГ77"));
        assertFalse(isLicensePlate("А123ВЕ7777"));

        assertThrows(IllegalArgumentException.class, () -> isLicensePlate(null));
    }
}
