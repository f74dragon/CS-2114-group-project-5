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
        channel2 = new Channel("user2", "channel2", "UK", "Art");
        channel3 = new Channel("user3", "channel3", "ES", "Tech");
    }
    
    /**
     * 
     */
    public void testAddMonth() {
        
    }
    
    /**
     * 
     */
    public void testGetMonth() {
        
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
