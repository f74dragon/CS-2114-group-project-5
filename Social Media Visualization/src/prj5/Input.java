package prj5;

import java.io.FileNotFoundException;

public class Input {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            int x =0;
            int y =1;
            x = y/x;
            
            ChannelList channelList = new ChannelList("SampleInput1_2022.csv");
            channelList.toString();
        }
        else {
            ChannelList channelList = new ChannelList(args[0]);
            channelList.toString();

        }
    }
}
