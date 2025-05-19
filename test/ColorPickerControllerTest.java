import Question2.ColorPickerComponent;
import Question2.ColorPickerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ColorPickerController class (Controller layer).
 * These tests ensure correct coordination between controller input and model behavior.
 */
public class ColorPickerControllerTest {
    private ColorPickerComponent model;
    private ColorPickerController controller;

    @BeforeEach
    public void setup() {
        model = new ColorPickerComponent();
        controller = new ColorPickerController(model);
    }

    @Test
    public void testSetRedDecimalThroughController() {
        controller.setRedDecimal("123");
        assertEquals(123, model.getRed());
    }

    @Test
    public void testSetGreenHexThroughController() {
        controller.setGreenHex("#7F");
        assertEquals(127, model.getGreen());
    }

    @Test
    public void testSetBlueHexWithoutHash() {
        controller.setBlueHex("80");
        assertEquals(128, model.getBlue());
    }

    @Test
    public void testRandomColorGenerationThroughController() {
        controller.generateRandomColor();
        assertTrue(model.getRed() >= 0 && model.getRed() <= 255);
        assertTrue(model.getGreen() >= 0 && model.getGreen() <= 255);
        assertTrue(model.getBlue() >= 0 && model.getBlue() <= 255);
    }

    @Test
    public void testInvalidDecimalThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.setBlueDecimal("300");
        });
        assertTrue(exception.getMessage().contains("RGB value out of range"));
    }

    @Test
    public void testInvalidDecimalStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> controller.setRedDecimal("abc"));
        assertThrows(IllegalArgumentException.class, () -> controller.setGreenDecimal("12#"));
    }

    @Test
    public void testRgbStringFromController() {
        controller.setRedDecimal("100");
        controller.setGreenDecimal("150");
        controller.setBlueDecimal("200");
        assertEquals("RGB(100, 150, 200)", controller.getRgbString());
    }

    @Test
    public void testHexParsingThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> controller.setRedHex("ZZ"));
        assertThrows(IllegalArgumentException.class, () -> controller.setGreenHex("#1"));
    }
}