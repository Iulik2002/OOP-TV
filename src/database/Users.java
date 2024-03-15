package database;


import java.util.ArrayList;
import java.util.List;

public final class Users {
    private Credentials credentials;
    private int tokensCount = 0;
    private int numFreePremiumMovies = 15;
    private List<Movies> purchasedMovies = new ArrayList<>();
    private List<Movies> watchedMovies = new ArrayList<>();
    private List<Movies> likedMovies = new ArrayList<>();
    private List<Movies> ratedMovies = new ArrayList<>();
    private List<Notifications> notifications = new ArrayList<>();
    private ArrayList<String> subscribedGenre = new ArrayList<>();

    /**
     *
     * @return
     */
    public ArrayList<String> returnSubscribedGenre() {
        return subscribedGenre;
    }

    /**
     *
     * @param gen
     */
    public void addGenres(final String gen) {
        subscribedGenre.add(gen);
    }

    /**
     *
     * @param notifications
     */
    public void addNotification(final Notifications notifications) {
        this.notifications.add(notifications);
    }

    /**
     *
     * @param movie
     */
    public void addPurchasedMovies(final Movies movie) {
        purchasedMovies.add(movie);
    }

    /**
     *
     * @param movie
     */
    public void addWatchedMovies(final Movies movie) {
        watchedMovies.add(movie);
    }

    /**
     *
     * @param movie
     */
    public void addLikedMovies(final Movies movie) {
        likedMovies.add(movie);
    }

    /**
     *
     * @param movie
     */
    public void addRatedMovies(final Movies movie) {
        ratedMovies.add(movie);
    }

    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public List<Movies> getPurchasedMovies() {
        return purchasedMovies;
    }

    public List<Movies> getWatchedMovies() {
        return watchedMovies;
    }

    public List<Movies> getLikedMovies() {
        return likedMovies;
    }

    public List<Movies> getRatedMovies() {
        return ratedMovies;
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }
}
