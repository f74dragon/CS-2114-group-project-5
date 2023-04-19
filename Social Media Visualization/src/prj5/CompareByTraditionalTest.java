package prj5;

import student.TestCase;

public class CompareByTraditionalTest extends TestCase {

    private CompareByTraditional comparing;
    private Channel c1;
    private Channel c2;

    /**
     * sets up the testing environment
     */
    public void setUp() {
        comparing = new CompareByTraditional();
        c1 = new Channel("username1", "Achannel", "USA", "Minecraft");
        c2 = new Channel("username1", "Bchannel", "USA", "Finance");
        c1.addMonth(new Month("January", 5, 1, 1, 5, 1));
        c2.addMonth(new Month("January", 1, 1, 1, 1, 1));
        c1.addMonth(new Month("February", 2, 1, 1, 2, 1));
        c2.addMonth(new Month("February", 3, 1, 1, 3, 1));

    }


    /**
     * tests both compare methods return a positive value if the first channel
     * has a higher engagement rate, negative if the second has a higher
     * rate, and 0 if they are even
     */
    public void testCompare() {
        assertTrue(comparing.compare(c1, c2) > 0);
        assertTrue(comparing.compare(c1, c1) == 0);
        assertTrue(comparing.compare(c2, c1) < 0);
        assertTrue(comparing.compare(c1, c2, "January") > 0);
        assertTrue(comparing.compare(c1, c1, "January") == 0);
        assertTrue(comparing.compare(c2, c1, "January") < 0);
        assertTrue(comparing.compare(c1, c2, "February") < 0);
        assertTrue(comparing.compare(c1, c1, "February") == 0);
        assertTrue(comparing.compare(c2, c1, "February") > 0);
    }
}
