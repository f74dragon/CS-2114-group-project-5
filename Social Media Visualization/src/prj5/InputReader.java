package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import prj5.DoublyLinkedList.Node;

/**
 * A class used to read a given input file and hold a list of channels.
 * 
 * @author Jon Church (Jrchurch02), Arian Assadzadeh (arian83@vt.edu), Kevin
 *         Xiong (kevxemail)
 * @version 04-18-2023
 */
public class InputReader {

    private DoublyLinkedList<Channel> channels;

    /**
     * Constructor for the class, reads the given file and
     * parses the info from the file
     * 
     * @param fileName
     *            the name of the file to read
     * @throws FileNotFoundException
     */
    public InputReader(String fileName) throws FileNotFoundException {
        channels = new DoublyLinkedList<Channel>();
        // set up file i/o
        Scanner file = new Scanner(new File(fileName));
        // temporary fields to create each channel
        Channel toAdd;
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
                if (curr.getData().getChannelName().equals(channelName)) {

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
        for (int i = 0; i < channels.getLength(); i++) {
            Channel curr = channels.getEntry(i);
            if (curr.getMonth("January") == null) {
                curr.addMonth(0, new Month("January", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("February") == null) {
                curr.addMonth(1, new Month("February", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("March") == null) {
                curr.addMonth(2, new Month("March", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("April") == null) {
                curr.addMonth(3, new Month("April", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("May") == null) {
                curr.addMonth(4, new Month("May", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("June") == null) {
                curr.addMonth(5, new Month("June", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("July") == null) {
                curr.addMonth(6, new Month("July", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("August") == null) {
                curr.addMonth(7, new Month("August", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("September") == null) {
                curr.addMonth(8, new Month("September", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("October") == null) {
                curr.addMonth(9, new Month("October", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("November") == null) {
                curr.addMonth(10, new Month("November", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("December") == null) {
                curr.addMonth(11, new Month("December", 0, 0, 0, 0, 0));
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
     * a sort method that sorts by traditional for a given month or
     * quarter
     * 
     * @param comp
     *            the comparator to use
     * @param month
     *            the month that is being compared
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void sort(CompareByTraditional comp, String month) {

        Node temp = channels.getFirstNode().getNext();
        while (temp != null) {

            Node temp2 = temp;
            while (temp2.getData() != null && temp2.getPrev().getData() != null
                && comp.compare((Channel)temp2.getPrev().getData(),
                    (Channel)temp2.getData(), month) > 0) {
                Channel data = (Channel)temp2.getData();
                temp2.setData(temp2.getPrev().getData());
                temp2.getPrev().setData(data);
                temp2 = temp2.getPrev();

            }
            temp = temp.getNext();
        }
    }


    /**
     * a sort method that sorts by a reach for a given month or
     * quarter
     * 
     * @param comp
     *            the comparator to use
     * @param month
     *            the month that is being compared
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void sort(CompareByReach comp, String month) {
        Node temp = channels.getFirstNode().getNext();
        while (temp != null) {
            Node temp2 = temp;
            while (temp2.getData() != null && temp2.getPrev().getData() != null
                && comp.compare((Channel)temp2.getPrev().getData(),
                    (Channel)temp2.getData(), month) > 0) {
                Channel data = (Channel)temp2.getData();
                temp2.setData(temp2.getPrev().getData());
                temp2.getPrev().setData(data);
                temp2 = temp2.getPrev();

            }
            temp = temp.getNext();
        }

    }


    /**
     * sorts the channels by a given comparator
     * 
     * @param comp
     *            the comparator to use
     */
    public void sort(CompareByName comp) {
        channels.sort(comp);

    }


    /**
     * @return a string representation of the list, which is the name of each
     *         channel in the list
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < channels.getLength(); i++) {
            s = s + channels.getEntry(i).toString() + "\n";
        }
        return s;
    }
}
