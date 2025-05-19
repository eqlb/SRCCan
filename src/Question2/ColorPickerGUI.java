package Question2;

import javax.swing.*;
import java.awt.*;

/**
 * Swing-based GUI for the ColorPickerComponent using MVC.
 * Supports local and API-based random color generation with swatch preview.
 * Now includes a toggle to accept hexadecimal input and auto-format switching.
 */
public class ColorPickerGUI extends JFrame {
    private final ColorPickerController controller;
    private final JPanel swatchPanel;
    private final JTextField redField, greenField, blueField;
    private final JButton randomButton, applyButton, apiButton;
    private final JCheckBox hexInputToggle;

    public ColorPickerGUI() {
        ColorPickerComponent model = new ColorPickerComponent();
        controller = new ColorPickerController(model);

        setTitle("Color Picker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        redField = new JTextField("0");
        greenField = new JTextField("0");
        blueField = new JTextField("0");
        hexInputToggle = new JCheckBox("Hex Input Mode");

        inputPanel.add(new JLabel("Red:"));
        inputPanel.add(redField);
        inputPanel.add(new JLabel("Green:"));
        inputPanel.add(greenField);
        inputPanel.add(new JLabel("Blue:"));
        inputPanel.add(blueField);
        inputPanel.add(new JLabel("Input Mode:"));
        inputPanel.add(hexInputToggle);

        applyButton = new JButton("Apply Color");
        randomButton = new JButton("Random Color (Local)");
        apiButton = new JButton("Random Color (API)");

        inputPanel.add(applyButton);
        inputPanel.add(randomButton);
        inputPanel.add(apiButton);

        // Swatch Panel
        swatchPanel = new JPanel();
        swatchPanel.setBackground(controller.getCurrentColor());

        add(inputPanel, BorderLayout.NORTH);
        add(swatchPanel, BorderLayout.CENTER);

        // Apply Button Listener
        applyButton.addActionListener(e -> {
            try {
                if (hexInputToggle.isSelected()) {
                    controller.setRedHex(redField.getText());
                    controller.setGreenHex(greenField.getText());
                    controller.setBlueHex(blueField.getText());
                } else {
                    controller.setRedDecimal(redField.getText());
                    controller.setGreenDecimal(greenField.getText());
                    controller.setBlueDecimal(blueField.getText());
                }
                updateSwatch();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Local Random Button
        randomButton.addActionListener(e -> {
            controller.generateRandomColor();
            updateFieldsFromModel();
            updateSwatch();
        });

        // API Random Button
        apiButton.addActionListener(e -> {
            try {
                ColorPickerComponent apiColor = ColorService.fetchRandomColor();
                controller.setRedDecimal(String.valueOf(apiColor.getRed()));
                controller.setGreenDecimal(String.valueOf(apiColor.getGreen()));
                controller.setBlueDecimal(String.valueOf(apiColor.getBlue()));
                updateFieldsFromModel();
                updateSwatch();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "API Error: " + ex.getMessage(), "API Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Toggle Listener for Hex Input Mode
        hexInputToggle.addActionListener(e -> updateFieldsFromModel());

        setVisible(true);
    }

    private void updateSwatch() {
        swatchPanel.setBackground(controller.getCurrentColor());
        swatchPanel.repaint();
    }

    private void updateFieldsFromModel() {
        if (hexInputToggle.isSelected()) {
            redField.setText(String.format("#%02X", controller.getRed()));
            greenField.setText(String.format("#%02X", controller.getGreen()));
            blueField.setText(String.format("#%02X", controller.getBlue()));
        } else {
            redField.setText(String.valueOf(controller.getRed()));
            greenField.setText(String.valueOf(controller.getGreen()));
            blueField.setText(String.valueOf(controller.getBlue()));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorPickerGUI::new);
    }
}



