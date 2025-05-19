import Question1.BashTarget;
import Question1.Bumper;
import Question1.DropTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Question1.PinballComponent subclasses.
 */
public class PinballComponentTest {

    private BashTarget bashTarget;
    private Bumper activeBumper;
    private Bumper passiveBumper;
    private DropTarget dropTarget;

    @BeforeEach
    public void setUp() {
        bashTarget = new BashTarget("Alien Bash", 120);
        activeBumper = new Bumper("Top Question1.Bumper", 40, true);
        passiveBumper = new Bumper("Bottom Question1.Bumper", 25, false);
        dropTarget = new DropTarget("Left Drop", 90);
    }

    @Test
    public void testBashTargetScore() {
        Assertions.assertEquals("Alien Bash", bashTarget.getName());
        Assertions.assertEquals(120, bashTarget.getScoreValue());
    }

    @Test
    public void testBumperTypes() {
        Assertions.assertTrue(activeBumper.isActive());
        Assertions.assertFalse(passiveBumper.isActive());
    }

    @Test
    public void testDropTargetInitialState() {
        Assertions.assertFalse(dropTarget.isDropped());
    }

    @Test
    public void testDropTargetDropsOnce() {
        dropTarget.hit(); // should drop
        Assertions.assertTrue(dropTarget.isDropped());

        dropTarget.hit(); // should not drop again
        Assertions.assertTrue(dropTarget.isDropped());
    }
}
