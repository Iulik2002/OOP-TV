package pages;

import database.Input;
import database.Movies;
import database.Users;


import java.util.ArrayList;

public final class CurrentUser {
    private static Users currentUser;
    private static ArrayList<Movies> moviesArrayList;
    private static ArrayList<Movies> copyMoviesArrayList;

    private static ArrayList<Movies> oneMoviesList;

    /**
     *
     * @param movies
     */
    public void addMovieArrayList(final Movies movies) {
        moviesArrayList.add(movies);
    }

    public ArrayList<Movies> getOneMoviesList() {
        return oneMoviesList;
    }

    public void setOneMoviesList(final ArrayList<Movies> oneMoviesList) {
        CurrentUser.oneMoviesList = oneMoviesList;
    }

    public ArrayList<Movies> getCopyMoviesArrayList() {
        return copyMoviesArrayList;
    }
    /**
     *
     * @param copyMoviesArrayList
     */
    public void setCopyMoviesArrayList(final ArrayList<Movies> copyMoviesArrayList) {
        CurrentUser.copyMoviesArrayList = copyMoviesArrayList;
    }

    public CurrentUser() {
    }

    public Users getCurrentUser() {
        return currentUser;
    }

    /**
     *
     * @param currentUser
     */
    public void setCurrentUser(final Users currentUser) {
        CurrentUser.currentUser = currentUser;
    }

    public ArrayList<Movies> getMoviesArrayList() {
        return moviesArrayList;
    }

    /**
     *
     */
    public void setMoviesArrayList() {
        ArrayList<Movies> initialMoviesList = new Input().getMovies();
        moviesArrayList = new ArrayList<>();
        for (Movies movie: initialMoviesList) {

            if (!movie.getCountriesBanned().contains(currentUser.getCredentials().getCountry())) {
                moviesArrayList.add(movie);
            }
        }
    }

    /**
     *
     * @param arrayList
     */
    public void resetMovieArrayList(final ArrayList<Movies> arrayList) {
        CurrentUser.moviesArrayList = arrayList;
    }
}
