package prj5;

import student.TestCase;

/**
 * Test class for the Month class
 * 
 * @author Jon Church (Jrchurch02)
 * @version 2023.04.18
 */
public class MonthTest extends TestCase {

    private Month month1;
    private Month month2;

    /**
     * sets up the testing environment
     */
    public void setUp() {
        month1 = new Month("August", 1, 2, 3, 4, 5);
        month2 = new Month("March", 11, 22, 33, 44, 55);
    }


    /**
     * tests that getMonth returns the string of the month
     */
    public void testGetMonth() {
        assertEquals("August", month1.getMonth());
        assertEquals("March", month2.getMonth());
    }


    /**
     * tests that getLikes returns the likes field
     */
    public void testGetLikes() {
        assertEquals(1, month1.getLikes());
        assertEquals(11, month2.getLikes());
    }


    /**
     * tests that getPosts returns the posts field
     */
    public void testGetPosts() {
        assertEquals(2, month1.getPosts());
        assertEquals(22, month2.getPosts());
    }


    /**
     * tests that getFollowers returns the followers field
     */
    public void testGetFollowers() {
        assertEquals(3, month1.getFollowers());
        assertEquals(33, month2.getFollowers());
    }


    /**
     * tests that getComments returns the comments field
     */
    public void testGetComments() {
        assertEquals(4, month1.getComments());
        assertEquals(44, month2.getComments());
    }


    /**
     * test that getViews returns the views field
     */
    public void testGetViews() {
        assertEquals(5, month1.getViews());
        assertEquals(55, month2.getViews());
    }
}
