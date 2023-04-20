package prj5;

import java.io.FileNotFoundException;

public class Input {
    public static void main(String[] args)
        throws FileNotFoundException,
        EmptyListException {
        if (args.length == 0) {

            ChannelList channelList = new ChannelList("SampleInput1_2022.csv");
            System.out.println(channelList.toString());
            CompareByTraditional compareByTrads = new CompareByTraditional();
            CompareByReach compareByReachs = new CompareByReach();
            channelList.sort(compareByReachs, "March");
            System.out.println();
            System.out.println();
            System.out.println(channelList.toString());

        }
        else {
            ChannelList channelList = new ChannelList(args[0]);
            channelList.toString();
        }
    }


    public void writeToFile(ChannelList channelList) {

    }
}
