package Question1;

/**
 * Abstract base class representing a generic component in a pinball machine.
 * All components have a name and a score value when hit.
 * This class enforces the implementation of the hit() behavior.
 */
public abstract class PinballComponent {
    protected String name;
    protected int scoreValue;

    /**
     * Constructor for a generic pinball component.
     *
     * @param name       The name of the component (e.g., "Bash Toy", "Left Question1.Bumper").
     * @param scoreValue The number of points awarded when this component is hit.
     */
    public PinballComponent(String name, int scoreValue) {
        this.name = name;
        this.scoreValue = scoreValue;
    }

    /**
     * Defines behavior when the component is hit by the ball.
     * Implementations must define their own effects.
     */
    public abstract void hit();

    // Getter for the component's score value
    public int getScoreValue() {
        return scoreValue;
    }

    // Getter for the component's name
    public String getName() {
        return name;
    }
}
