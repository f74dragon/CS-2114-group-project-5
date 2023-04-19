package prj5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CompareByNameTest {
    private CompareByName comparing;
    private Channel c1;
    private Channel c2;

    /**
     * Sets up objects to be tested
     */
    @Before
    public void setUp() throws Exception {
        comparing = new CompareByName();
        c1 = new Channel("username1", "Achannel", "USA", "Minecraft");
        c2 = new Channel("username1", "Bchannel", "USA", "Finance");
    }


    @Test
    public void testCompare() {
        assertEquals(-1, comparing.compare(c1, c2));
        assertEquals(0, comparing.compare(c1, c1));
        assertEquals(1, comparing.compare(c2, c1));
    }

}
