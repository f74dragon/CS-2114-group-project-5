package prj5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CompareByReachTest {
    private CompareByReach comparing;
    private Channel c1;
    private Channel c2;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() throws Exception {
        comparing = new CompareByReach();
        c1 = new Channel("username1", "Achannel", "USA", "Minecraft");
        c2 = new Channel("username2", "Bchannel", "USA", "Finance");
    }


    /**
     * Compares the two channels by an individual month's reach
     * 
     * @
     */
    @Test
    public void testCompareMonth()  {
        c1.addMonth(new Month("January", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("January", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("February", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("February", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("March", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("March", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("April", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("April", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("May", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("May", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("June", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("June", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("July", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("July", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("August", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("August", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("September", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("September", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("October", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("October", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("November", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("November", 30, 30, 30, 30, 1));

        c1.addMonth(new Month("December", 50, 50, 50, 50, 1));
        c2.addMonth(new Month("December", 30, 30, 30, 30, 1));

        assertTrue(comparing.compare(c1, c2, "January") > 0);
        assertTrue(comparing.compare(c2, c1, "January") < 0);
        assertTrue(comparing.compare(c1, c1, "January") == 0);

        assertTrue(comparing.compare(c1.getMonth("January"), c2.getMonth(
            "January")) > 0);
        assertTrue(comparing.compare(c2.getMonth("January"), c1.getMonth(
            "January")) < 0);
        assertTrue(comparing.compare(c1.getMonth("January"), c1.getMonth(
            "January")) == 0);

    }

}
