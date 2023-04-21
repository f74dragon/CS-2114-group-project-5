package prj5;

import java.util.Comparator;

/**
 * CompareByName class for comparing the channel list by channel names.
 *
 *
 * @author Arian, Kevin, Jon
 *
 * @version 04-18-2023
 * 
 */
public class CompareByName implements Comparator<Channel> {
    /**
     * Returns which object is "greater" based on which has the greater String
     * for their channel name.
     * 
     * @param c1
     *            The first channel in question.
     * @param c2
     *            The second channel in question.
     * @return A positive value if c1's channel name is greater than c2's, a
     *         negative
     *         value for vice versa, and 0 if they have the same name
     */
    public int compare(Channel c1, Channel c2) {
        if (c1 == null) {
            return -1;
        }
        if (c2 == null) {
            return 1;
        }
        return c1.getChannelName().toLowerCase().compareTo(c2.getChannelName()
            .toLowerCase());
    }

}
