package prj5;

import student.TestCase;

/**
 * Test class for the Month class
 * 
 * @author Jon Church (Jrchurch02), Arian Assadzadeh (arian83@vt.edu), Kevin
 *         Xiong (kevxemail)
 * @version 04-18-2023
 */
public class MonthTest extends TestCase {

    private Month month1;
    private Month month2;
    private Month monthNoFollowers;
    private Month monthNoViews;

    /**
     * sets up the testing environment
     */
    public void setUp() {
        month1 = new Month("August", 1, 2, 3, 4, 5);
        month2 = new Month("March", 11, 22, 33, 44, 55);
        monthNoFollowers = new Month("March", 1, 1, 0, 1, 1);
        monthNoViews = new Month("March", 1, 1, 1, 1, 0);
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


    /**
     * tests that getReach returns the traditional engagement or -1 if the are
     * no followers
     */
    public void testGetTraditional() {
        assertEquals(166.7, month1.getTraditional(), 0.1);
        assertEquals(-1.0, monthNoFollowers.getTraditional(), 0.1);
    }


    /**
     * tests that getReach returns the reach engagement or -1 if the are no
     * views
     */
    public void testGetReach() {
        assertEquals(100.0, month1.getReach(), 0.1);
        assertEquals(-1.0, monthNoViews.getReach(), 0.1);
    }


    /**
     * 
     */
    public void testToString() {
        assertEquals(
            "August, likes:1, posts:2, followers:3, comments:4, views:5", month1
                .toString());
    }
}
