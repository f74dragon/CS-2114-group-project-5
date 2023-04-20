package prj5;

import java.util.Comparator;

public class CompareByTraditional implements Comparator<Month> {
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
    public int compare(Month m1, Month m2) throws ArithmeticException {

        int c1Comments = m1.getComments();
        int c1Likes = m1.getLikes();
        int c1Followers = m1.getFollowers();

        int c2Comments = m2.getComments();
        int c2Likes = m2.getLikes();
        int c2Followers = m2.getFollowers();

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
        if (c1.getMonth(month).getTraditional() < 0 && (Double)c2.getMonth(
            month).getTraditional() < 0) {
            return 0;
        }
        else if ((Double)c1.getMonth(month).getTraditional() < 0) {
            return c2.getMonth(month).getTraditional();
        }
        else if ((Double)c2.getMonth(month).getTraditional() < 0) {
            return c1.getMonth(month).getTraditional();
        }
        else {
            return c1.getMonth(month).getTraditional() - c2.getMonth(month)
                .getTraditional();
        }
    }


   
  

}
