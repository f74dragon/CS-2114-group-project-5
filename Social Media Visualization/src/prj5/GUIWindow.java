package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * GUI window for front end.
 *
 *
 * @author Jon Church (Jrchurch02), Arian Assadzadeh (arian83@vt.edu), Kevin
 *         Xiong (kevxemail)
 * @version 04-18-2023
 * 
 */
public class GUIWindow {

    private Shape[] shapes;
    private Window window;
    private Button[] buttons;
    private ChannelList channelList;
    private String selectedMonth;
    private String engagementType;

    public GUIWindow(ChannelList channelList) {
        selectedMonth = "January";
        engagementType = "Traditional";

        this.channelList = channelList;
        window = new Window();

        Button quit = new Button();
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

    }


    /**
     * quits the program
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public void clickedSortByName(Button button) {
        CompareByName comp = new CompareByName();
        channelList.sort(comp);
        update();
    }
    
    public void clickedSortByEngagement(Button button) {
        sortByEngagement();
    }

    private void sortByEngagement() {
        if (engagementType == "Traditional") {
            CompareByTraditional comp = new CompareByTraditional();
            channelList.sort(comp, selectedMonth);
        }
        else {
            CompareByReach comp = new CompareByReach();
            channelList.sort(comp, selectedMonth);
        }
        update();
    }

    public void clickedTraditional(Button button) {
        engagementType = "Traditional";
        sortByEngagement();
    }


    public void clickedReach(Button button) {
        engagementType = "Reach";
        sortByEngagement();
    }


    public void clickedMonth(Button button) {
        //selectedMonth = ;
        update();
    }


    /**
     * should update the guys in the background, while the buttons just sort and
     * choose what to display
     */
    private void update() {
        
    }

}
