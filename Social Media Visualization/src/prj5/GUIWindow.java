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
    private String sortType;

    public GUIWindow(ChannelList channelList) {
        selectedMonth = "January";
        engagementType = "Traditional";
        sortType = "Name";
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


    /**
     * sets the sort type to by name and then calls sortByName to sort and
     * update the GUI
     * 
     * @param button
     *            the button pressed
     */
    public void clickedSortByName(Button button) {
        sortType = "Name";
        sortByName();
    }


    /**
     * sorts the list by name and then updates the GUI
     */
    private void sortByName() {
        CompareByName comp = new CompareByName();
        channelList.sort(comp);
        update();
    }


    /**
     * sets the sort type to by engagement and then calls sortBYEngagement to
     * sort and update the GUI
     * 
     * @param button
     *            the button pressed
     */
    public void clickedSortByEngagement(Button button) {
        sortType = "Engagement";
        sortByEngagement();
    }


    /**
     * sorts the list by the current engagement type during the selected month
     * and then updates the GUI
     */
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


    /**
     * sets the engagement type to be traditional and calls sortByEngagement to
     * sort and update the GUI
     * 
     * @param button
     *            the button pressed
     */
    public void clickedTraditional(Button button) {
        engagementType = "Traditional";
        sortByEngagement();
    }


    /**
     * sets the engagement type to be reach and calls sortByEngagement to
     * sort and update the GUI
     * 
     * @param button
     *            the button pressed
     */
    public void clickedReach(Button button) {
        engagementType = "Reach";
        sortByEngagement();
    }


    /**
     * sets the selected month based on which month button was pressed and then
     * calls either sortByName or sortByEngagement to sort and update the GUI
     * 
     * @param button
     *            the button pressed
     */
    public void clickedMonth(Button button) {
        selectedMonth = button.getTitle();
        if (sortType == "Name") {
            sortByName();
        }
        else {
            sortByEngagement();
        }
    }


    /**
     * should update the guys in the background, while the buttons just sort and
     * choose what to display
     */
    private void update() {

    }

}
