package prj5;

import java.io.FileNotFoundException;

/**
 * Input class/project runner. Takes in file names and prints out results.
 *
 * @author Jon Church (Jrchurch02), Arian Assadzadeh (arian83@vt.edu), Kevin
 *         Xiong (kevxemail)
 * @version 04-18-2023
 *
 */
public class Input {
    public static void main(String[] args) throws FileNotFoundException {
        ChannelList channelList;
        if (args.length == 0) {

            channelList = new ChannelList("SampleInput2_2022.csv");

        }
        else {

            channelList = new ChannelList(args[0]);
            channelList.toString();
        }
        CompareByName name = new CompareByName();
        new CompareByReach();

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
            else {
                System.out.println(curr.getChannelName());
                System.out.println("traditional: N/A");
                System.out.println("==========");
            }

        }
        channelList.sort(new CompareByReach(), "Quarter 1");
        // sort by reach
        System.out.println("**********");
        System.out.println("**********");
        for (int i = channelList.getChannels().getLength() - 1; i >= 0; i--) {
            Channel curr = channelList.getChannels().getEntry(i);
            if ((double)curr.getMonth("Quarter 1").getReach() >= 0) {
                System.out.println(curr.getChannelName());
                System.out.println("reach: " + String.valueOf(curr.getMonth(
                    "Quarter 1").getReach()));
                System.out.println("==========");
            }
            else {
                System.out.println(curr.getChannelName());
                System.out.println("reach: N/A");
                System.out.println("==========");
            }

        }
    }
}
