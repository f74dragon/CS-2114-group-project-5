package prj5;

import java.util.Comparator;

/**
 * CompareByReach that compares two channels my their reach
 * engagement rate.
 *
 *
 * @author Jon Church (Jrchurch02), Arian Assadzadeh (arian83@vt.edu), Kevin
 *         Xiong (kevxemail)
 * @version 04-18-2023
 * 
 */
public class CompareByReach implements Comparator<Month> {

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
    public int compare(Month m1, Month m2) {
        double m1Reach = m1.getReach();
        double m2Reach = m2.getReach();
        if (m1Reach < 0) {
            m1Reach = 0.0;
        }
        if (m2Reach < 0) {
            m2Reach = 0.0;
        }
        return (int)(m1Reach - m2Reach);

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
     * @
     */
    public double compare(Channel c1, Channel c2, String quarter) {
        double c1Reach = c1.getMonth(quarter).getReach();
        double c2Reach = c2.getMonth(quarter).getReach();
        if (c1Reach < 0) {
            c1Reach = 0.0;
        }
        if (c2Reach < 0) {
            c2Reach = 0.0;
        }
        return c1Reach - c2Reach;
    }

}
