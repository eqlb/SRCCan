package Question1;

/**
 * A drop target is a target that drops below the playfield when hit.
 * Once dropped, it cannot be hit again until reset (not implemented here).
 */
public class DropTarget extends PinballComponent {
    private boolean isDropped;

    /**
     * Constructor for a drop target.
     *
     * @param name       The name of the drop target.
     * @param scoreValue Points awarded when the target is hit and drops.
     */
    public DropTarget(String name, int scoreValue) {
        super(name, scoreValue);
        this.isDropped = false;
    }

    /**
     * Simulates hitting the drop target.
     * If not already dropped, awards points and drops the target.
     * If already dropped, prints a message indicating so.
     */
    @Override
    public void hit() {
        if (!isDropped) {
            isDropped = true;
            System.out.println(name + " dropped! +" + scoreValue + " points.");
        } else {
            System.out.println(name + " already dropped.");
        }
    }

    /**
     * Indicates whether this target has been dropped.
     *
     * @return true if already dropped, false otherwise.
     */
    public boolean isDropped() {
        return isDropped;
    }
}
