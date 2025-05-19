package Question2;

import java.awt.Color;

/**
 * Controller for the ColorPickerComponent in an MVC architecture.
 * Parses and validates input, updates the model, and exposes current color values.
 */
public class ColorPickerController {
    private final ColorPickerComponent model;

    public ColorPickerController(ColorPickerComponent model) {
        this.model = model;
    }

    public void setRedDecimal(String input) {
        model.setRedDecimal(parseDecimal(input));
    }

    public void setGreenDecimal(String input) {
        model.setGreenDecimal(parseDecimal(input));
    }

    public void setBlueDecimal(String input) {
        model.setBlueDecimal(parseDecimal(input));
    }

    public void setRedHex(String hex) {
        model.setRedHex(hex);
    }

    public void setGreenHex(String hex) {
        model.setGreenHex(hex);
    }

    public void setBlueHex(String hex) {
        model.setBlueHex(hex);
    }

    public void generateRandomColor() {
        model.setRandomColor();
    }

    public Color getCurrentColor() {
        return model.getColor();
    }

    public String getRgbString() {
        return model.getRgbString();
    }

    public int getRed() {
        return model.getRed();
    }

    public int getGreen() {
        return model.getGreen();
    }

    public int getBlue() {
        return model.getBlue();
    }

    private int parseDecimal(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid decimal input: " + input);
        }
    }
}
