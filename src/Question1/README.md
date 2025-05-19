#  Pinball Machine Components 

This project is a text based simulation of a pinball machine's key components using Java and object-oriented programming principles. It models three types of interactive playfield elements, with emphasis on polymorphism.

---

##  Components Modeled

### 1. `BashTarget`
- Represents toys or static targets on the board.
- Awards points when hit.

### 2. `Bumper`
- Can be **active** or **passive**.
- Active bumpers may influence ball movement.
- Passive bumpers simply award points.

### 3. `DropTarget`
- Drops when hit the first time, stays inactive until reset.
- Can be part of drop target banks.

All components implement a shared abstract class `PinballComponent`.

---

##  Testing Strategy

Unit tests are provided in `PinballComponentTest.java`. These tests:

-  Verify initial states (e.g., drop targets are not dropped)
-  Test score values of components
-  Simulate hits on components
-  Confirm correct behavior on multiple hits (e.g., drop target only drops once)

### Sample Test Case: Drop Target Hit

1. Instantiate a `DropTarget`.
2. Call `hit()` — assert it changes to dropped.
3. Call `hit()` again — assert it remains dropped.

**Expected:** Target drops only once and awards points once.

---

##  Design Considerations

| Decision                         | Impact on Testing                            |
|----------------------------------|----------------------------------------------|
| Use of inheritance     | Allowed use of polymorphic test suites       |
| Separation of component types    | Made unit testing specific behaviors easy    |
| Boolean state tracking in `DropTarget` | Required edge case testing for repeated hits |

---

##  How to Run

1. Compile and run the `Main.java` class to see demo behavior.
2. Run `PinballComponentTest` using JUnit 5 for validation.

```bash
javac *.java
java Main
```

Or run through IntelliJ using the test runner.

---

##  Author
**Kyle Taticek**  
Bachelor of Engineering (Software Engineering)  
Carleton University – Class of 2025

SRC Can Recruitment Project – Pinball Simulation
