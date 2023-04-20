package prj5;

import student.TestCase;

/**
 * test class for the channel class
 * 
 * @author Jon Church (Jrchurch02)
 * @version 2023.04.18
 */
public class ChannelTest extends TestCase {

    private Channel channel1;
    private Channel channel2;
    private Channel channel3;

    /**
     * sets up the testing environment
     */
    public void setUp() {
        channel1 = new Channel("user1", "channel1", "US", "Sports");
        channel1.addMonth(new Month("March", 1, 2, 3, 4, 5));
        channel2 = new Channel("user2", "channel2", "UK", "Art");
        channel3 = new Channel("user3", "channel3", "ES", "Tech");
    }


    /**
     * 
     * tests that addMonth adds a month to the DLL of months
     * @ 
     */
    public void testAddMonth()  {
        channel2.addMonth(new Month("March", 1, 2, 3, 4, 5));
        assertNotNull(channel2.getMonth("March"));
    }


    /**
     * tests that getMonth returns the proper month.
     * @ 
     */
    public void testGetMonth()  {
        assertNotNull(channel1.getMonth("March"));
        Month march = channel1.getMonth("March");
        assertEquals(1, march.getLikes());
        assertEquals(2, march.getPosts());
        assertEquals(3, march.getFollowers());
        assertEquals(4, march.getComments());
        assertEquals(5, march.getViews());
        channel1.addMonth(new Month("August", 2, 3, 4, 5, 6));
        assertNotNull(channel1.getMonth("August"));
        Month august = channel1.getMonth("August");
        assertEquals(2, august.getLikes());
        assertEquals(3, august.getPosts());
        assertEquals(4, august.getFollowers());
        assertEquals(5, august.getComments());
        assertEquals(6, august.getViews());
    }


    /**
     * tests that getUsername returns the username field
     */
    public void testGetUsername() {
        assertEquals("user1", channel1.getUsername());
        assertEquals("user2", channel2.getUsername());
        assertEquals("user3", channel3.getUsername());
    }


    /**
     * tests that getChannelName returns the channelName field
     */
    public void testGetChannelName() {
        assertEquals("channel1", channel1.getChannelName());
        assertEquals("channel2", channel2.getChannelName());
        assertEquals("channel3", channel3.getChannelName());
    }


    /**
     * tests that getGetCountry returns the country field
     */
    public void testGetCountry() {
        assertEquals("US", channel1.getCountry());
        assertEquals("UK", channel2.getCountry());
        assertEquals("ES", channel3.getCountry());
    }


    /**
     * tests that toArray returns a proper array with each month
     */
    public void testToArray() {
        channel3.addMonth(new Month("January", 1, 1, 1, 1, 1));
        channel3.addMonth(new Month("February", 1, 1, 1, 1, 1));
        channel3.addMonth(new Month("March", 1, 1, 1, 1, 1));
        channel3.addMonth(new Month("April", 1, 1, 1, 1, 1));
        channel3.addMonth(new Month("May", 1, 1, 1, 1, 1));
        Month[] testArr = channel3.toArray();
        assertEquals("January", testArr[0].getMonth());
        assertEquals("February", testArr[1].getMonth());
        assertEquals("March", testArr[2].getMonth());
        assertEquals("April", testArr[3].getMonth());
        assertEquals("May", testArr[4].getMonth());
    }


    /**
     * tests that getQuarters returns the proper quarter
     * 
     * @
     */
    public void testGetQuarters()  {
        channel2.addMonth(new Month("January", 1, 1, 1, 1, 1));
        channel2.addMonth(new Month("Febuary", 1, 1, 1, 1, 1));
        channel2.addMonth(new Month("March", 1, 1, 1, 1, 1));
        channel2.addMonth(new Month("April", 2, 2, 2, 2, 2));
        channel2.addMonth(new Month("May", 2, 2, 2, 2, 2));
        channel2.addMonth(new Month("June", 2, 2, 2, 2, 2));
        channel2.addMonth(new Month("July", 3, 3, 3, 3, 3));
        channel2.addMonth(new Month("August", 3, 3, 3, 3, 3));
        channel2.addMonth(new Month("Septeber", 3, 3, 3, 3, 3));
        channel2.addMonth(new Month("October", 4, 4, 4, 4, 4));
        channel2.addMonth(new Month("November", 4, 4, 4, 4, 4));
        channel2.addMonth(new Month("December", 4, 4, 4, 4, 4));

        Month q1 = channel2.getQuarters(1);
        assertEquals(3, q1.getComments());
        assertEquals(1, q1.getFollowers());
        assertEquals(3, q1.getLikes());
        assertEquals(3, q1.getPosts());
        assertEquals(3, q1.getViews());
        
        Month q2 = channel2.getQuarters(2);
        assertEquals(6, q2.getComments());
        assertEquals(2, q2.getFollowers());
        assertEquals(6, q2.getLikes());
        assertEquals(6, q2.getPosts());
        assertEquals(6, q2.getViews());
        
        Month q3 = channel2.getQuarters(3);
        assertEquals(9, q3.getComments());
        assertEquals(3, q3.getFollowers());
        assertEquals(9, q3.getLikes());
        assertEquals(9, q3.getPosts());
        assertEquals(9, q3.getViews());
        
        Month q4 = channel2.getQuarters(4);
        assertEquals(12, q4.getComments());
        assertEquals(4, q4.getFollowers());
        assertEquals(12, q4.getLikes());
        assertEquals(12, q4.getPosts());
        assertEquals(12, q4.getViews());
    }
}
