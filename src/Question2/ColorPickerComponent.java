package Question2;

import java.awt.Color;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * The ColorPickerComponent class represents the model in the MVC pattern.
 * It encapsulates logic for handling RGB values, including validation,
 * conversion from hexadecimal, and random color generation.
 */
public class ColorPickerComponent {
    private int red;
    private int green;
    private int blue;

    private static final Pattern HEX_PATTERN = Pattern.compile("#?[0-9A-Fa-f]{2}");

    /**
     * Initializes a default color (black: RGB 0, 0, 0).
     */
    public ColorPickerComponent() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public void setRedDecimal(int value) {
        this.red = validateRange(value);
    }

    public void setGreenDecimal(int value) {
        this.green = validateRange(value);
    }

    public void setBlueDecimal(int value) {
        this.blue = validateRange(value);
    }

    public void setRedHex(String hex) {
        this.red = validateRange(parseHex(hex));
    }

    public void setGreenHex(String hex) {
        this.green = validateRange(parseHex(hex));
    }

    public void setBlueHex(String hex) {
        this.blue = validateRange(parseHex(hex));
    }

    public void setRandomColor() {
        Random rand = new Random();
        this.red = rand.nextInt(256);
        this.green = rand.nextInt(256);
        this.blue = rand.nextInt(256);
    }

    public Color getColor() {
        return new Color(red, green, blue);
    }

    public String getRgbString() {
        return String.format("RGB(%d, %d, %d)", red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    private int parseHex(String hex) {
        if (hex == null || !HEX_PATTERN.matcher(hex).matches()) {
            throw new IllegalArgumentException("Invalid hex input: " + hex);
        }
        return Integer.parseInt(hex.replace("#", ""), 16);
    }

    private int validateRange(int value) {
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException("RGB value out of range: " + value);
        }
        return value;
    }
}



