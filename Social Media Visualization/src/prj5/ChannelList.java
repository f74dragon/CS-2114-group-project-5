package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

/**
 * A class used to read a given input file and hold a list of channels.
 * 
 * @author Jon Church (Jrchurch02)
 * @version 2023.04.18
 */
public class ChannelList {

    private DoublyLinkedList<Channel> channels;

    /**
     * Constructor for the class, reads the given file and
     * parses the info from the file
     * 
     * @param fileName
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    public ChannelList(String fileName) throws FileNotFoundException {
        channels = new DoublyLinkedList<Channel>();
        // set up file i/o
        Scanner file = new Scanner(new File(fileName));
        Scanner line;
        // temporary fields to create each channel
        Channel toAdd;
        String thisLine;
        String month;
        String username;
        String channelName;
        String country;
        String mainTopic;
        int likes;
        int posts;
        int followers;
        int comments;
        int views;
        boolean channelFound;
        while (file.hasNextLine()) {
            thisLine = file.nextLine();
            line = new Scanner(thisLine).useDelimiter(",\\s+");
            // set fields for this month
            channelFound = false; // used to avoid double channels
            month = line.next();
            username = line.next();
            channelName = line.next();
            country = line.next();
            mainTopic = line.next();
            likes = Integer.valueOf(line.next());
            posts = Integer.valueOf(line.next());
            followers = Integer.valueOf(line.next());
            comments = Integer.valueOf(line.next());
            views = Integer.valueOf(line.next());

            DoublyLinkedList<Channel>.Node<Channel> curr = 
                channels.getFirstNode();
            while (curr.getData() != null) {
                if (curr.getData().getChannelName() == channelName) {
                    curr.getData().addMonth(new Month(month, likes, posts,
                        followers, comments, views));
                    channelFound = true;
                    break;
                }
            }
            // avoiding double channels
            if (!channelFound) {
                toAdd = new Channel(username, channelName, country, mainTopic);
                toAdd.addMonth(new Month(month, likes, posts,
                    followers, comments, views));
                channels.add(toAdd);
            }
        }
    }


    /**
     * @return the list of channels
     */
    public DoublyLinkedList<Channel> getChannels() {
        return channels;
    }


    /**
     * sorts the channel list by a given comparator
     * 
     * @param comp
     *            the comparator to use to sort
     */
    public void sort(Comparator<Channel> comp) {
        
    }
}
