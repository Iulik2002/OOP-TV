package database;


import java.util.HashMap;
import java.util.List;


public final class Movies {
    private String name;
    private String year;
    private int duration;
    private List<String> genres;
    private List<String> actors;
    private List<String> countriesBanned;
    private long numLikes = 0;
    private double rating = 0;
    private long numRatings = 0;
    private HashMap<String, Integer> movieRates = new HashMap<>();

    /**
     *
     * @return
     */
    public HashMap<String, Integer> returnMovieRates() {
        return movieRates;
    }

    /**
     *
     * @return
     */
    public HashMap<String, Integer> retMovieRates() {
        return movieRates;
    }

    /**
     *
     * @param name
     * @param rate
     */
    public void addMovieRates(final String name, final Integer rate) {
        this.movieRates.put(name, rate);
    }

    /**
     *
     * @param name
     * @param rate
     */
    public void changeMovieRates(final String name, final Integer rate) {
        this.movieRates.replace(name, rate);
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(final String year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public List<String> getGenres() {
        return genres;
    }

    /**
     *
     * @param genres
     */
    public void setGenres(final List<String> genres) {
        this.genres = genres;
    }

    public List<String> getActors() {
        return actors;
    }

    /**
     *
     * @param actors
     */
    public void setActors(final List<String> actors) {
        this.actors = actors;
    }

    public List<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     *
     * @param countriesBanned
     */
    public void setCountriesBanned(final List<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public long getNumLikes() {
        return numLikes;
    }

    /**
     *
     * @param numLikes
     */
    public void setNumLikes(final long numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    public long getNumRatings() {
        return numRatings;
    }

    /**
     *
     * @param numRatings
     */
    public void setNumRatings(final long numRatings) {
        this.numRatings = numRatings;
    }

    @Override
    public String toString() {
        return "Movie{" + " name=" + name
                + ", year=" + year
                + ", duration=" + duration + '\''
                + ", genres=" + genres
                + '\'' + ", actors=" + actors + '\''
                + ", countriesBanned=" + countriesBanned
                + ", rating=" + rating
                + ", numRatings=" + numRatings
                + ", numLikes=" + numLikes + '}';
    }

}
