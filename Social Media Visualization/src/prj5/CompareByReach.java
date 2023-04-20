package prj5;

public class CompareByReach {

    /**
     * Returns which Channel has the greater amount of "reach" engagement rate
     * based on the provided formula for ALL months.
     * 
     * @param c1
     *            The first channel in question.
     * @param c2
     *            The second channel in question.
     * @return A positive value if c1's total reach engagement rate is greater,
     *         a
     *         negative value if
     *         c1's total reach engagement rate is less, 0 if they have the same
     *         value.
     */
    public int compare(Channel c1, Channel c2) {
        Month[] c1Months = c1.toArray();
        int c1Comments = 0;
        int c1Likes = 0;
        int c1Views = 0;
        for (int i = 0; i < c1Months.length; i++) {
            c1Comments += c1Months[i].getComments();
            c1Likes += c1Months[i].getLikes();
            c1Views += c1Months[i].getViews();
        }

        Month[] c2Months = c2.toArray();
        int c2Comments = 0;
        int c2Likes = 0;
        int c2Views = 0;
        for (int i = 0; i < c2Months.length; i++) {
            c2Comments += c2Months[i].getComments();
            c2Likes += c2Months[i].getLikes();
            c2Views += c2Months[i].getViews();
        }

        int c1Final = ((c1Comments + c1Likes) / c1Views) * 100;
        int c2Final = ((c2Comments + c2Likes) / c2Views) * 100;
        return c1Final - c2Final;
    }


    /**
     * Returns which Channel has the greater amount of "reach" engagement rate
     * based on the provided formula for a specific month or quarter
     * 
     * @param c1
     *            The first channel in question.
     * @param c2
     *            The second channel in question.
     * @return A positive value if c1's total reach engagement rate is greater,
     *         a
     *         negative value if
     *         c1's total reach engagement rate is less, 0 if they have the same
     *         value.
     */
    public double compare(Channel c1, Channel c2, String quarter) {
        double c1Reach = c1.getMonth(quarter).getReach();
        double c2Reach = c2.getMonth(quarter).getReach();
        if (c1Reach < 0){
            c1Reach = 0.0;
        }
        if (c2Reach < 0){
            c2Reach = 0.0;
        }
        return c1Reach - c2Reach;
    }

}
