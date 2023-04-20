package prj5;

import java.io.FileNotFoundException;

public class Input {
    public static void main(String[] args)
        throws FileNotFoundException,
        EmptyListException {
        ChannelList channelList;
        if (args.length == 0) {

            channelList = new ChannelList("SampleInput1_2022.csv");

            CompareByTraditional compareByTrads = new CompareByTraditional();
            CompareByReach compareByReachs = new CompareByReach();
            channelList.sort(compareByReachs, "March");
            // System.out.println(channelList.toString());

        }
        else {

            channelList = new ChannelList(args[0]);
            channelList.toString();
        }

        // Prints the needed stuff for intermediate submission

        // TODO sort by name
        for (int i = 0; i < channelList.getChannels().getLength(); i++) {
            Channel curr = channelList.getChannels().getEntry(i);
            if ((double)curr.getMonth("Quarter 1")
                .getTraditional() > (double)0) {
                System.out.println(curr.getChannelName());
                System.out.println("traditional: " + String.valueOf(curr
                    .getMonth("Quarter 1").getTraditional()));
                System.out.println("==========");

            }

        }
        // TODO sort by reach
        System.out.println("**********");
        System.out.println("**********");
        for (int i = channelList.getChannels().getLength() - 1; i >= 0; i--) {
            Channel curr = channelList.getChannels().getEntry(i);
            if ((double)curr.getMonth("Quarter 1").getReach() >= 0) {
                System.out.println(curr.getChannelName());
                System.out.println("reach: " + String.valueOf(curr.getMonth(
                    "Quarter 1").getTraditional()));
                System.out.println("==========");
            }

        }
    }
}
