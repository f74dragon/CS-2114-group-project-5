package prj5;

import student.TestCase;

/**
 * test class for the channel class
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
     */
    public void testAddMonth() {
        channel2.addMonth(new Month("March", 1, 2, 3, 4, 5));
        assertNotNull(channel2.getMonth("March"));
    }
    
    /**
     * tests that getMonth returns the proper month.
     */
    public void testGetMonth() {
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
     * 
     */
    public void testToArray() {
        
    }
    
    /**
     * 
     */
    public void testGetQuarters() {
        
    }
    
    /**
     * 
     */
    public void testCalQuarter() {
        
    }
}
