package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * A test class for the ChannelList class.
 * 
 * @author Jon Church (Jrchurch02), Arian Assadzadeh (arian83@vt.edu), Kevin
 *         Xiong (kevxemail)
 * @version 04-20-2023
 */
public class ChannelListTest extends TestCase {

    private ChannelList channelList;
    private ChannelList channelList2;
    private ChannelList channelList3;

    /**
     * sets up the testing environment
     * 
     * @throws FileNotFoundException
     */
    public void setUp() throws FileNotFoundException {
        channelList = new ChannelList("SampleInput1_2022.csv");
        channelList2 = new ChannelList("SampleInput1_2022.csv");
        channelList3 = new ChannelList("SampleInput3_2022.csv");
    }


    /**
     * tests that getChannels will return the list of channels properly
     */
    public void testGetChannels() {
        DoublyLinkedList<Channel> testList = channelList.getChannels();
        assertEquals("wizardHighSchool", testList.getEntry(0).toString());
        assertEquals("JustBeatz", testList.getEntry(1).toString());
        assertEquals("australian_wildlife", testList.getEntry(2).toString());
        assertEquals("ArtAllDay", testList.getEntry(3).toString());
        assertEquals(testList.getLength(), 4);
    }


    /**
     * tests that both sort methods will sort by the proper order.
     */
    public void testSorts() {
        channelList.sort(new CompareByName());
        assertEquals("ArtAllDay\r\n" + "australian_wildlife\r\n"
            + "JustBeatz\r\n" + "wizardHighSchool\r\n", channelList.toString());

        channelList.sort(new CompareByTraditional(), "January");
        assertEquals("australian_wildlife\r\n" + "ArtAllDay\r\n"
            + "wizardHighSchool\r\n" + "JustBeatz\r\n", channelList.toString());

        channelList2.sort(new CompareByReach(), "January");
        assertEquals("australian_wildlife\r\n" + "ArtAllDay\r\n"
            + "wizardHighSchool\r\n" + "JustBeatz\r\n", channelList2
                .toString());

        channelList.sort(new CompareByReach(), "January");
        assertEquals("australian_wildlife\r\n" + "ArtAllDay\r\n"
            + "wizardHighSchool\r\n" + "JustBeatz\r\n", channelList.toString());

    }


    /**
     * tests the toString method returns the proper string representation.
     */
    public void testToString() {
        assertEquals("wizardHighSchool\r\n" + "JustBeatz\r\n"
            + "australian_wildlife\r\n" + "ArtAllDay\r\n", channelList
                .toString());
    }
}
