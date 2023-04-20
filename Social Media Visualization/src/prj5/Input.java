package prj5;

import java.io.FileNotFoundException;

public class Input {
    public static void main(String[] args)
        throws FileNotFoundException,
        EmptyListException {
        ChannelList channelList;
        if (args.length == 0) {

            channelList = new ChannelList("SampleInput1_2022.csv");

        }
        else {

            channelList = new ChannelList(args[0]);
            channelList.toString();
        }
        CompareByName name = new CompareByName();
        CompareByReach compareByReachs = new CompareByReach();

        channelList.sort(name);

        // Prints the needed stuff for intermediate submission

        // sort by name
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
        channelList.sort(compareByReachs, "Quarter 1");
        // sort by reach
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
