package Question1;

/**
 * Demonstrates hitting various pinball machine components.
 */
public class Main {
    public static void main(String[] args) {
        // Create components
        BashTarget bashTarget = new BashTarget("Robot Bash", 100);
        Bumper activeBumper = new Bumper("Right Question1.Bumper", 50, true);
        Bumper passiveBumper = new Bumper("Left Question1.Bumper", 30, false);
        DropTarget dropTarget = new DropTarget("Center Drop", 75);

        // Simulate game hits
        System.out.println("=== Pinball Component Demo ===");

        bashTarget.hit();       // Expect: Hit and score 100
        activeBumper.hit();     // Expect: Bounces and score 50
        passiveBumper.hit();    // Expect: No bounce and score 30

        dropTarget.hit();       // Expect: Drops and score 75
        dropTarget.hit();       // Expect: Already dropped

        System.out.println("=== End of Demo ===");
    }
}
