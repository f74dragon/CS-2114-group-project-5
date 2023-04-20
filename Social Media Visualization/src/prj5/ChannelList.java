package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import prj5.DoublyLinkedList.Node;

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
     * @throws EmptyListException
     */
    public ChannelList(String fileName)
        throws FileNotFoundException,
        EmptyListException {
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
            if (curr.getMonth("November") == null) {
                curr.addMonth(8, new Month("November", 0, 0, 0, 0, 0));
            }
            if (curr.getMonth("December") == null) {
                curr.addMonth(8, new Month("December", 0, 0, 0, 0, 0));
            }
        }

        // adds dummy months with 0 for all fields so calQuarters works properly
// for (int i = 0; i < channels.getLength(); i++) {
// System.out.println(channels.getEntry(i).getQuarters(1));
// }
    }


    /**
     * @return the list of channels
     */
    public DoublyLinkedList<Channel> getChannels() {
        return channels;
    }


    @SuppressWarnings("unchecked")
    public void sort(CompareByTraditional comp, String month) {

        Node temp = channels.getFirstNode().getNext();
        while (temp != null) {
            temp = temp.getNext();
            Node temp2 = temp;
            while (temp2 != null && temp2.getData() != null && comp.compare(
                (Channel)temp2.getPrev().getData(), (Channel)temp2.getData(),
                month) > 0) {
                Channel data = (Channel)temp2.getData();
                temp2.setData(temp2.getPrev().getData());
                temp2.getPrev().setData(data);
                temp2 = temp2.getPrev();

            }
        }
    }


    @SuppressWarnings("unchecked")
    public void sort(CompareByReach comp, String month) {
        Node temp = channels.getFirstNode().getNext();
        while (temp != null) {
            temp = temp.getNext();
            Node temp2 = temp;
            while (temp2 != null && temp2.getData() != null && comp.compare(
                (Channel)temp2.getPrev().getData(), (Channel)temp2.getData(),
                month) > 0) {
                Channel data = (Channel)temp2.getData();
                temp2.setData(temp2.getPrev().getData());
                temp2.getPrev().setData(data);
                temp2 = temp2.getPrev();

            }
        }

    }


    public void sort(CompareByName comp) {
        channels.sort(comp);

    }


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < channels.getLength(); i++) {
            try {
                s = s + channels.getEntry(i).getQuarters(1) + "\n";
            }
            catch (EmptyListException e) {
                // TODO Auto-generated catch block
                return "did not work";
            }
        }
        return s;
    }
}
