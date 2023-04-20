package prj5;

/**
 * A class representing a month with social media statistics, such as likes,
 * posts, followers, comments, and views.
 */
public class Month {
    private String month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    private double traditional;
    private double reach;

    /**
     * Constructs a Month object with the given statistics.
     *
     * @param month
     *            the name of the month
     * @param likes
     *            the number of likes in the month
     * @param posts
     *            the number of posts in the month
     * @param followers
     *            the number of followers in the month
     * @param comments
     *            the number of comments in the month
     * @param views
     *            the number of views in the month
     */
    public Month(
        String month,
        int likes,
        int posts,
        int followers,
        int comments,
        int views) {
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        if (followers == 0) {
            traditional = -1;
        }
        else {
            traditional = (1.0 * (comments + likes) / followers) * 100.0;
        }
        if (views == 0) {
            reach = -1;
        }
        else {
            reach = (1.0 * (comments + likes) / views) * 100.0;
        }
    }


    /**
     * Returns the name of the month.
     *
     * @return the name of the month
     */
    public String getMonth() {
        return month;
    }


    /**
     * Returns the number of likes in the month.
     *
     * @return the number of likes in the month
     */
    public int getLikes() {
        return likes;
    }


    /**
     * Returns the number of posts in the month.
     *
     * @return the number of posts in the month
     */
    public int getPosts() {
        return posts;
    }


    /**
     * Returns the number of followers in the month.
     *
     * @return the number of followers in the month
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * Returns the number of comments in the month.
     *
     * @return the number of comments in the month
     */
    public int getComments() {
        return comments;
    }


    /**
     * Returns the number of views in the month.
     *
     * @return the number of views in the month
     */
    public int getViews() {
        return views;
    }


    /**
     * Returns traditional engagement rate based on the given formula
     *
     * @return traditional engagement
     */
    public double getTraditional() {
        return traditional;
    }


    /**
     * Returns reach engagement rate based on the given formula
     *
     * @return reach engagement
     */
    public double getReach() {
        return reach;
    }


    /**
     * String format of data for month.
     *
     * @return the number of views in the month
     */
    @Override
    public String toString() {
        return month + ": " + followers + ", " + likes + ", " + comments + ", "
            + posts + ", " + views;
    }

}
