package database;

import java.util.ArrayList;

public class Input {
    private static ArrayList<Movies> movies = new ArrayList<>();
    private static ArrayList<Users> users = new ArrayList<>();
    private static ArrayList<Actions> actions = new ArrayList<>();

    /**
     *
     * @return
     */
    public ArrayList<Movies> getMovies() {
        return movies;
    }

    /**
     *
     * @param movies
     */
    public void setMovies(final ArrayList<Movies> movies) {
        Input.movies = movies;
    }

    /**
     *
     * @return
     */
    public ArrayList<Users> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(final ArrayList<Users> users) {
        Input.users = users;
    }

    /**
     *
     * @return
     */
    public ArrayList<Actions> getActions() {
        return actions;
    }

    /**
     *
     * @param actions
     */
    public void setActions(final ArrayList<Actions> actions) {
        Input.actions = actions;
    }

    /**
     *
     * @param movies
     */
    public void addMovies(final Movies movies) {
        Input.movies.add(movies);
    }
    /**
     *
     * @param users
     */
    public void addUsers(final Users users) {
        Input.users.add(users);
    }
}
