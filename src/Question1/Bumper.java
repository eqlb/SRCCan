package Question1;

/**
 * A bumper is a round target on the playfield.
 * It can be active (kicks the ball) or passive (just registers the hit).
 */
public class Bumper extends PinballComponent {
    private boolean isActive;

    /**
     * Constructor for a bumper component.
     *
     * @param name       The name of the bumper.
     * @param scoreValue Points awarded when the bumper is hit.
     * @param isActive   True if the bumper kicks the ball; false if passive.
     */
    public Bumper(String name, int scoreValue, boolean isActive) {
        super(name, scoreValue);
        this.isActive = isActive;
    }

    /**
     * Simulates hitting the bumper.
     * Displays bounce behavior and score.
     */
    @Override
    public void hit() {
        String action = isActive ? "Ball is bounced!" : "No bounce.";
        System.out.println(name + " was hit! " + action + " +" + scoreValue + " points.");
    }

    /**
     * Returns whether the bumper is active.
     *
     * @return true if active, false if passive.
     */
    public boolean isActive() {
        return isActive;
    }
}
