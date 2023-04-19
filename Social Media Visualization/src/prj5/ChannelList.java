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

        file.nextLine();

        while (file.hasNextLine()) {
            String l = file.nextLine();
            String[] datas = l.split(",");
            channelFound = false;
            month = datas[0];
            username = datas[1];
            channelName = datas[2];
            country = datas[3];
            mainTopic = datas[4];
            likes = Integer.parseInt(datas[5]);
            posts = Integer.parseInt(datas[6]);
            followers = Integer.parseInt(datas[7]);
            comments = Integer.parseInt(datas[8]);
            views = Integer.parseInt(datas[9]);

            DoublyLinkedList<Channel>.Node<Channel> curr = channels
                .getFirstNode();
            while (curr != null && curr.getData() != null) {
                if (curr.getData().getChannelName() == channelName) {
                    curr.getData().addMonth(new Month(month, likes, posts,
                        followers, comments, views));
                    channelFound = true;
                    break;
                }
                curr = curr.getNext();
            }
            // avoiding double channels
            if (!channelFound) {
                toAdd = new Channel(username, channelName, country, mainTopic);
                toAdd.addMonth(new Month(month, likes, posts, followers,
                    comments, views));
                channels.add(toAdd);
            }

        }
        // adds dummy months with 0 for all fields so calQuarters works properly
      for (int i=0; i <channels.getLength(); i++) {
          System.out.println(channels.getEntry(i));
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
        channels.sort(comp);
    }
}
