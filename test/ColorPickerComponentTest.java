import Question2.ColorPickerComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ColorPickerComponent (Model layer).
 * These tests verify color value parsing, validation, formatting, and random generation logic.
 */
public class ColorPickerComponentTest {
    private ColorPickerComponent component;

    @BeforeEach
    public void setup() {
        component = new ColorPickerComponent();
    }

    @Test
    public void testSetRedDecimal_ValidValue() {
        component.setRedDecimal(200);
        assertEquals(200, component.getRed());
    }

    @Test
    public void testSetGreenHex_ValidValue() {
        component.setGreenHex("#80");
        assertEquals(128, component.getGreen());
    }

    @Test
    public void testSetBlueHex_NoHash() {
        component.setBlueHex("FF");
        assertEquals(255, component.getBlue());
    }

    @Test
    public void testRandomColorWithinRange() {
        for (int i = 0; i < 100; i++) {
            component.setRandomColor();
            assertTrue(component.getRed() >= 0 && component.getRed() <= 255);
            assertTrue(component.getGreen() >= 0 && component.getGreen() <= 255);
            assertTrue(component.getBlue() >= 0 && component.getBlue() <= 255);
        }
    }

    @Test
    public void testHexParsing_InvalidFormatThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> component.setRedHex("ZZ"));
        assertThrows(IllegalArgumentException.class, () -> component.setRedHex("#1"));
        assertThrows(IllegalArgumentException.class, () -> component.setRedHex(null));
    }

    @Test
    public void testDecimalOutOfRangeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> component.setGreenDecimal(999));
        assertThrows(IllegalArgumentException.class, () -> component.setBlueDecimal(-10));
    }

    @Test
    public void testRgbStringFormat() {
        component.setRedDecimal(100);
        component.setGreenDecimal(150);
        component.setBlueDecimal(200);
        assertEquals("RGB(100, 150, 200)", component.getRgbString());
    }
}
