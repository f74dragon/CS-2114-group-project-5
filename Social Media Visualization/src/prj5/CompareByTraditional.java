package prj5;

import java.util.Comparator;

/**
 * CompareByTraditional that compares two channels my their traditional
 * engagement rate.
 *
 *
 * @author Arian, Kevin, Jon
 *
 * @version 04-18-2023
 * 
 */
public class CompareByTraditional implements Comparator<Month> {
    /**
     * Returns which Month has the greater amount of traditional engagement
     * rate.
     * 
     * @param m1
     *            The first month in question.
     * @param m2
     *            The second month in question.
     * @return A positive value if m1's total engagement rate is greater, a
     *         negative value if
     *         m1's total engagement rate is less, 0 if they have the same
     *         value.
     */
    public int compare(Month m1, Month m2) throws ArithmeticException {

        double m1Trad = m1.getTraditional();
        double m2Trad = m2.getTraditional();
        if (m1Trad < 0) {
            m1Trad = 0.0;
        }
        if (m2Trad < 0) {
            m2Trad = 0.0;
        }
        return -1 * (int)(m1Trad - m2Trad);

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
     * @
     */
    public double compare(Channel c1, Channel c2, String month) {
        if (c1.getMonth(month).getTraditional() < 0 && (Double)c2.getMonth(
            month).getTraditional() < 0) {
            return 0;
        }
        else if ((Double)c1.getMonth(month).getTraditional() < 0) {
            return -1 * c2.getMonth(month).getTraditional();
        }
        else if ((Double)c2.getMonth(month).getTraditional() < 0) {
            return -1 * c1.getMonth(month).getTraditional();
        }
        else {
            return -1 * c1.getMonth(month).getTraditional() - c2.getMonth(month)
                .getTraditional();
        }
    }

}
