package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
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
    private int length;
    private Window window;
    private ChannelList channelList;
    private String selectedMonth;
    private String engagementType;
    private String sortType;

    /**
     * Constructor for the GUIWindow.
     * Creates a window that will display the contents of the channel list given
     * Places buttons for each month and quarter on the bottom side of the
     * window, buttons for the type of engagement on the left, buttons for
     * sorting by name or engagement rate on the top and finally a quit button
     * to exit the program.
     * 
     * @param channelList
     *            the list of channels to display
     */
    public GUIWindow(ChannelList channelList) {

        selectedMonth = "January";
        engagementType = "Traditional";
        sortType = "Name";
        this.channelList = channelList;
        window = new Window();
        length = channelList.getChannels().getLength();

        shapes = new Shape[length];
        // buttons for each month
        Button jan = new Button();
        jan.setTitle("January");
        jan.onClick(this, "clickedMonth");
        window.addButton(jan, WindowSide.SOUTH);
        Button feb = new Button();
        feb.setTitle("February");
        feb.onClick(this, "clickedMonth");
        window.addButton(feb, WindowSide.SOUTH);
        Button mar = new Button();
        mar.setTitle("March");
        mar.onClick(this, "clickedMonth");
        window.addButton(mar, WindowSide.SOUTH);
        Button apr = new Button();
        apr.setTitle("April");
        apr.onClick(this, "clickedMonth");
        window.addButton(apr, WindowSide.SOUTH);
        Button may = new Button();
        may.setTitle("May");
        may.onClick(this, "clickedMonth");
        window.addButton(may, WindowSide.SOUTH);
        Button jun = new Button();
        jun.setTitle("June");
        jun.onClick(this, "clickedMonth");
        window.addButton(jun, WindowSide.SOUTH);
        Button jul = new Button();
        jul.setTitle("July");
        jul.onClick(this, "clickedMonth");
        window.addButton(jul, WindowSide.SOUTH);
        Button aug = new Button();
        aug.setTitle("August");
        aug.onClick(this, "clickedMonth");
        window.addButton(aug, WindowSide.SOUTH);
        Button sep = new Button();
        sep.setTitle("September");
        sep.onClick(this, "clickedMonth");
        window.addButton(sep, WindowSide.SOUTH);
        Button oct = new Button();
        oct.setTitle("October");
        oct.onClick(this, "clickedMonth");
        window.addButton(oct, WindowSide.SOUTH);
        Button nov = new Button();
        nov.setTitle("November");
        nov.onClick(this, "clickedMonth");
        window.addButton(nov, WindowSide.SOUTH);
        Button dec = new Button();
        dec.setTitle("December");
        dec.onClick(this, "clickedMonth");
        window.addButton(dec, WindowSide.SOUTH);
        Button q1 = new Button();
        q1.setTitle("Quarter 1");
        q1.onClick(this, "clickedMonth");
        window.addButton(q1, WindowSide.SOUTH);
        Button q2 = new Button();
        q2.setTitle("Quarter 2");
        q2.onClick(this, "clickedMonth");
        window.addButton(q2, WindowSide.SOUTH);
        Button q3 = new Button();
        q3.setTitle("Quarter 3");
        q3.onClick(this, "clickedMonth");
        window.addButton(q3, WindowSide.SOUTH);
        Button q4 = new Button();
        q4.setTitle("Quarter 4");
        q4.onClick(this, "clickedMonth");
        window.addButton(q4, WindowSide.SOUTH);

        // buttons for choosing the sort method
        Button sortEngage = new Button();
        sortEngage.setTitle("Sort By Engagement Rate");
        sortEngage.onClick(this, "clickedSortByEngagement");
        window.addButton(sortEngage, WindowSide.NORTH);
        Button sortName = new Button();
        sortName.setTitle("Sort By Channel Name");
        sortName.onClick(this, "clickedSortByName");
        window.addButton(sortName, WindowSide.NORTH);

        // add quit button
        Button quit = new Button();
        quit.onClick(this, "clickedQuit");
        quit.setTitle("Quit");
        window.addButton(quit, WindowSide.NORTH);

        // buttons for choosing the type of engagment
        Button chooseTrad = new Button();
        chooseTrad.setTitle("Traditional Engagement Rate");
        chooseTrad.onClick(this, "clickedTraditional");
        window.addButton(chooseTrad, WindowSide.WEST);
        Button chooseReach = new Button();
        chooseReach.setTitle("Reach Engagement Rate");
        chooseReach.onClick(this, "clickedReach");
        window.addButton(chooseReach, WindowSide.WEST);

        // ==========================
        Shape xShape = new Shape(window.getWidth() / 10, (window.getHeight()
            * 2) / 3, 50, 300, Color.black);

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
     * sets the engagement type to be traditional and then sorts and updates the
     * GUI by calling sortByEngagement or simply updating the GUI
     * 
     * 
     * @param button
     *            the button pressed
     */
    public void clickedTraditional(Button button) {
        engagementType = "Traditional";
        if (sortType == "Engagement") {
            sortByEngagement();
        }
    }


    /**
     * sets the engagement type to be reach and and then sorts and updates the
     * GUI by calling sortByEngagement or simply updating the GUI
     * 
     * @param button
     *            the button pressed
     */
    public void clickedReach(Button button) {
        engagementType = "Reach";
        if (sortType == "Engagement") {
            sortByEngagement();
        }
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
        window.removeAllShapes();
        for (int i = 0; i < length; i++) {
            Month tempMonth = channelList.getChannels().getEntry(i).getMonth(
                selectedMonth);
            int xIncrement = (window.getWidth() / (1 + length));
            Color color = new Color((int)(Math.random() * 255), (int)(Math
                .random() * 255), (int)(Math.random() * 255));
            int height = 0;
            if (engagementType == "Traditional") {
                height = (int)tempMonth.getTraditional() * 5;
            }
            else {
                height = (int)tempMonth.getReach() * 5;
            }
            int width = 50;
            int bottomPlacement = window.getHeight() * 2 / 3;
            Shape tempShape = new Shape(50 + xIncrement * i, bottomPlacement
                - height, width, height, color);
            window.addShape(tempShape);

            TextShape text;
            if (engagementType == "Traditional") {
                if (tempMonth.getTraditional() < 0) {
                    text = new TextShape(50 + xIncrement * i, bottomPlacement + 20, "No Data");
                }
                else{
                    text = new TextShape(50 + xIncrement * i, bottomPlacement + 20, String.valueOf(tempMonth.getTraditional()));
                }
            }
            else {
                if (tempMonth.getReach() < 0) {
                    text = new TextShape(50 + xIncrement * i, bottomPlacement + 20, "No Data");
                }
                else{
                    text = new TextShape(50 + xIncrement * i, bottomPlacement + 20, String.valueOf(tempMonth.getReach()));
                }
            }
            TextShape text2 = new TextShape(50 + xIncrement * i,
                bottomPlacement, channelList.getChannels().getEntry(i)
                    .getChannelName());
            window.addShape(text);
            window.addShape(text2);

        }

    }

}
