package Question1;

/**
 * A bash target is a toy or figure that scores points when hit.
 * Typically themed and may be part of a storyline in the game.
 */
public class BashTarget extends PinballComponent {

    /**
     * Constructor for a bash target.
     *
     * @param name       The name of the bash target.
     * @param scoreValue Points awarded when this target is hit.
     */
    public BashTarget(String name, int scoreValue) {
        super(name, scoreValue);
    }

    /**
     * Simulates hitting the bash target.
     * Prints the hit message and score.
     */
    @Override
    public void hit() {
        System.out.println(name + " was bashed! +" + scoreValue + " points.");
    }
}
