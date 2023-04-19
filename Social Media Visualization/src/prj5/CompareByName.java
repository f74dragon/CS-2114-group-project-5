package prj5;

import java.util.Comparator;

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
        return -1 * c1.getChannelName().compareTo(c2.getChannelName());
        // Need to times -1 because of the unicode scale where A < B
    }

}
