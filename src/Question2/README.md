# Color Picker Component 

This Java Swing application allows users to create and manipulate RGB colors via decimal or hexadecimal input, generate random colors (locally or via REST API), and view their color as a swatch. This project follows an MVC (Model-View-Controller) architecture and includes unit tests for both the model and controller.

---

##  Features

- Input red, green, and blue values using **decimal or hex**.
- Use a **toggle switch** to change input format between decimal and hexadecimal.
- Generate a **random RGB color locally**.
- Fetch a **random RGB color from an external API**.
- View the selected RGB color as a **color swatch**.
- Strong **input validation** and user feedback via error messages.

---

##  Architecture

| Component                 | Description                                  |
|--------------------------|----------------------------------------------|
| `ColorPickerComponent`  | Model: logic for RGB parsing, validation     |
| `ColorPickerController` | Controller: mediates view and model          |
| `ColorService`          | REST client for fetching random RGB          |
| `ColorPickerGUI`        | View: Swing-based GUI interface              |

---

## ️ How to Run the Application

1. Open the project in IntelliJ or any Java IDE.
2. Ensure all Java files (`ColorPickerComponent`, `ColorPickerController`, `ColorPickerGUI`, `ColorService`) are in the same package or project structure.
3. Make sure you have Java 8+ installed.
4. Run the `ColorPickerGUI` class.
5. The GUI window will appear. You can:
    - Enter RGB values as decimals or hex based on the toggle
    - Click "Apply Color" to update the swatch
    - Click "Random Color (Local)" for a locally generated color
    - Click "Random Color (API)" to fetch one from a REST API 

---

## Test Strategy

###  Unit Testing

- **Component (Model):**
    - Decimal/hex parsing and validation
    - Random color generation range
    - Exception handling for invalid input
    - RGB string formatting

- **Controller:**
    - String-to-integer parsing from GUI
    - Hex forwarding logic
    - Model updates and error handling

###  Integration Testing

- Toggle input between decimal and hex and verify updates
- Simulate API integration using Mockoon with random RGB values
- Confirm color swatch and input fields update in sync

###  Manual UI Testing

- Validate input fields update based on toggle mode
- Enter valid and invalid values in both modes and test error handling
- Test all buttons (Apply, Random, API Random)

---

##  Sample Test Case Walkthrough

**Test Case: Toggle to Hex and Apply Color**

1. Toggle "Hex Input Mode" ON.
2. Enter `#FF` in red, `#80` in green, `#40` in blue.
3. Click Apply.
4. Controller parses and updates model.
5. Swatch updates to reflect `RGB(255, 128, 64)`.

 **Expected:** Swatch turns orange-toned, input values remain hex.

---

## ️Development Decisions That Impact Testing

| Decision                            | Impact                                                    |
|-------------------------------------|------------------------------------------------------------|
| MVC Separation                      | Enables clean unit testing of logic without GUI dependency |
| Hex/Decimal Toggle Support          | Required bidirectional input formatting and conversion     |
| Use of `JOptionPane` for feedback  | Simplifies error testing, but limits automation            |
| API integration via `ColorService` | Requires mocking or simulated endpoints like Mockoon       |
| Swing for GUI                       | UI tests are done manually or with advanced frameworks     |

---

##  Running Tests

1. Ensure JUnit 5 is in your project.
2. Place test files in the `test/` source root.
3. Run with IntelliJ or use CLI:
   ```bash
   ./gradlew test   # If using Gradle
   mvn test         # If using Maven
   ```

---

##  Mock API Testing with Mockoon

1. Install Mockoon: https://mockoon.com
2. Create a GET endpoint:
   ```
   /randomColor
   ```
   with JSON:
   ```json
   {
     "red": {{faker 'number.int' max=255}},
     "green": {{faker 'number.int' max=255}},
     "blue": {{faker 'number.int' max=255}}
   }
   ```
3. Start server at `http://localhost:3000`
4. Update `ColorService.java` with this URL

---

## Author
**Kyle Taticek**  
Bachelor of Engineering (Software Engineering)  
Carleton University – Class of 2025  
SRC Can Recruitment Project – Color Picker Component
