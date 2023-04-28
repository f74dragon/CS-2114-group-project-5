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
        InputReader channelList;
        if (args.length == 0) {

            channelList = new InputReader("SampleInput4_2022.csv");

        }
        else {

            channelList = new InputReader(args[0]);
            channelList.toString();
        }
        new GUIWindow(channelList);
    }
}
