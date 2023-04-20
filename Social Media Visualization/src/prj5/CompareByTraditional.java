package prj5;

import java.util.Comparator;

public class CompareByTraditional implements Comparator<Channel> {
    /**
     * Returns which Channel has the greater amount of traditional engagement
     * rate
     * based on the provided formula for ALL months.
     * 
     * @param c1
     *            The first channel in question.
     * @param c2
     *            The second channel in question.
     * @return A positive value if c1's total engagement rate is greater, a
     *         negative value if
     *         c1's total engagement rate is less, 0 if they have the same
     *         value.
     */
    public int compare(Channel c1, Channel c2) throws ArithmeticException {
        Month[] c1Months = c1.toArray();
        int c1Comments = 0;
        int c1Likes = 0;
        int c1Followers = 0;
        for (int i = 0; i < c1Months.length; i++) {
            c1Comments += c1Months[i].getComments();
            c1Likes += c1Months[i].getLikes();
            c1Followers += c1Months[i].getFollowers();
        }

        Month[] c2Months = c2.toArray();
        int c2Comments = 0;
        int c2Likes = 0;
        int c2Followers = 0;
        for (int i = 0; i < c2Months.length; i++) {
            c2Comments += c2Months[i].getComments();
            c2Likes += c2Months[i].getLikes();
            c2Followers += c2Months[i].getFollowers();
        }

        int c1Final = ((c1Comments + c1Likes) / c1Followers) * 100;
        int c2Final = ((c2Comments + c2Likes) / c2Followers) * 100;
        return c1Final - c2Final;
    }


    /**
     * Returns which Channel has the greater amount of traditional reach
     * based on the provided formula for a specific month
     * 
     * @param c1
     *            The first channel in question.
     * @param c2
     *            The second channel in question.
     * @param month
     *            The month we want to compare for them
     * @return A positive value if c1's total engagement rate is greater, a
     *         negative value if
     *         c1's total engagement rate is less, 0 if they have the same
     *         value.
     */
    public double compare(Channel c1, Channel c2, String month) {
        return c1.getMonth(month).getTraditional() - c2.getMonth(month)
            .getTraditional();
    }

}
