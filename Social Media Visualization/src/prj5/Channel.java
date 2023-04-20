package prj5;

/**
 * A class representing a social media channel with a list of monthly statistics
 * and other attributes such as username,
 * channel name, country, and topic.
 */
public class Channel {
    private DoublyLinkedList<Month> months;
    private String username;
    private String channelName;
    private String country;
    private String topic;
    private Month q1;
    private Month q2;
    private Month q3;
    private Month q4;

    /**
     * Constructs a Channel object with the given attributes.
     *
     * @param username
     *            the username of the channel
     * @param channelName
     *            the name of the channel
     * @param country
     *            the country where the channel is based
     * @param topic
     *            the topic of the channel
     */
    public Channel(
        String username,
        String channelName,
        String country,
        String topic) {
        this.months = new DoublyLinkedList<>();
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.topic = topic;
    }


    /**
     * Adds a month's statistics to the channel's list of months.
     *
     * @param month
     *            the month to be added
     */
    public void addMonth(Month month) {
        months.add(month);
    }


    /**
     * Adds a month's statistics to the channel's list of months in a specificed
     * position.
     * 
     * @param pos
     *            the position to add the month into
     * @param month
     *            the month to be added
     */
    public void addMonth(int pos, Month month) {
        months.add(pos, month);
    }


    /**
     * Returns the Month object for the given month name.
     *
     * @param monthName
     *            the name of the month to retrieve
     * @return the Month object for the given month name
     * @throws EmptyListException
     */
    public Month getMonth(String monthName) throws EmptyListException {
        // uses Object instead of Month to prevent class cast exception
        if (monthName.toLowerCase().contains("quarter")) {
            calQuarter(1);
            calQuarter(2);
            calQuarter(3);
            calQuarter(4);

        }
        for (Object month : months.toArray()) {
            if (((Month)month).getMonth().equals(monthName)) {
                return (Month)month;
            }
        }
        return null;
    }


    /**
     * Returns the username of the channel.
     *
     * @return the username of the channel
     */
    public String getUsername() {
        return username;
    }


    /**
     * Returns the name of the channel.
     *
     * @return the name of the channel
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Returns the country where the channel is based.
     *
     * @return the country where the channel is based
     */
    public String getCountry() {
        return country;
    }


    /**
     * Returns the topic of the channel.
     *
     * @return the topic of the channel
     */
    public String getTopic() {
        return topic;
    }


    /**
     * Returns an array of Month objects representing the channel's list of
     * months.
     *
     * @return an array of Month objects representing the channel's list of
     *         months
     */
    public Month[] toArray() {
        // prevents a class cast error
        Object[] monthsArray = months.toArray();
        Month[] out = new Month[monthsArray.length];
        for (int i = 0; i < monthsArray.length; i++) {
            out[i] = (Month)monthsArray[i];
        }

        return out;
    }


    /**
     * Returns the Month object for the given quarter (1, 2, 3, or 4).
     *
     * @param quarter
     *            the quarter (1, 2, 3, or 4) to retrieve
     * @return the Month object for the given quarter
     * @throws EmptyListException
     */
    public Month getQuarters(int quarter) throws EmptyListException {
        switch (quarter) {
            case 1:
                calQuarter(quarter);
                return q1;
            case 2:
                calQuarter(quarter);
                return q2;
            case 3:
                calQuarter(quarter);
                return q3;
            case 4:
                calQuarter(quarter);
                return q4;
            default:
                return null;
        }
    }


    /**
     * Calculates and sets the Month objects for each quarter based on the
     * channel's list of months.
     * 
     * @throws EmptyListException
     */
    public void calQuarter(int quarter) throws EmptyListException {
        int[] data = null;
        if (!months.isEmpty()) {
            switch (quarter) {

                case 1:
                    data = addMonthData(months.getEntry(0), months.getEntry(1),
                        months.getEntry(2));
                    q1 = new Month("Quarter 1", data[0], data[1], data[2],
                        data[3], data[4]);
                    addMonth(q1);
                    break;
                case 2:
                    data = addMonthData(months.getEntry(3), months.getEntry(4),
                        months.getEntry(5));
                    q2 = new Month("Quarter 2", data[0], data[1], data[2],
                        data[3], data[4]);
                    addMonth(q2);
                    break;
                case 3:
                    data = addMonthData(months.getEntry(6), months.getEntry(7),
                        months.getEntry(8));
                    q3 = new Month("Quarter 3", data[0], data[1], data[2],
                        data[3], data[4]);
                    addMonth(q3);
                    break;
                case 4:
                    data = addMonthData(months.getEntry(9), months.getEntry(10),
                        months.getEntry(11));
                    q4 = new Month("Quarter 4", data[0], data[1], data[2],
                        data[3], data[4]);
                    addMonth(q4);
                    break;
                default:
                    return;
            }
        }
        else {
            throw new EmptyListException();
        }

    }


    public String toString() {
        return (username + ", " + channelName + ", " + country + ", " + topic);
    }


    private int[] addMonthData(Month a, Month b, Month c) {
        int[] data = new int[5];
        data[0] = a.getLikes() + b.getLikes() + c.getLikes();
        data[1] = a.getPosts() + b.getPosts() + c.getPosts();
        if (c.getFollowers() != 0) {
            data[2] = c.getFollowers();
        }
        else if (b.getFollowers() != 0) {
            data[2] = b.getFollowers();
        }
        else {
            data[2] = a.getFollowers();
        }
        data[3] = a.getComments() + b.getComments() + c.getComments();
        data[4] = a.getViews() + b.getViews() + c.getViews();

        return data;
    }
}
