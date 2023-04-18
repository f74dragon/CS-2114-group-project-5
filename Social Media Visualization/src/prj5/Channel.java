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

    }


    /**
     * Returns the Month object for the given month name.
     *
     * @param monthName
     *            the name of the month to retrieve
     * @return the Month object for the given month name
     */
    public Month getMonth(String monthName) {
        for (Month month : months.toArray()) {
            if (month.getMonth().equals(monthName)) {
                return month;
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

    }


    /**
     * Returns the Month object for the given quarter (1, 2, 3, or 4).
     *
     * @param quarter
     *            the quarter (1, 2, 3, or 4) to retrieve
     * @return the Month object for the given quarter
     */
    public Month getQuarters(int quarter) {
        switch (quarter) {
            case 1:
                return q1;
            case 2:
                return q2;
            case 3:
                return q3;
            case 4:
                return q4;
            default:
                return null;
        }
    }


    /**
     * Calculates and sets the Month objects for each quarter based on the channel's list of months.
     */
    public void calQuarter() {

    }
}
