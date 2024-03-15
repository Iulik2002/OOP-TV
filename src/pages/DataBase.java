package pages;

import database.Movies;
import database.Users;
import database.Actions;
import database.TempOutput;
import database.Output;
import database.Notifications;
import database.Input;

public final class DataBase {
    /**
     *
     * @param actions
     */
    public void add(final Actions actions) {
        for (Movies movies : new Input().getMovies()) {
            if (movies.getName().equals(actions.getAddedMovie().getName())) {
                TempOutput tempOutput = new TempOutput();
                tempOutput.addObjectNode(new Output().getOutputError());
                return;
            }
        }
        new Input().addMovies(actions.getAddedMovie());
        if (!actions.getAddedMovie().getCountriesBanned().contains(new CurrentUser()
                .getCurrentUser().getCredentials().getCountry())) {
            new CurrentUser().addMovieArrayList(actions.getAddedMovie());
        }
        for (Users user : new Input().getUsers()) {
            if (!actions.getAddedMovie().getGenres().contains(user
                    .getCredentials().getCountry())) {
                for (String genre : user.returnSubscribedGenre()) {
                    if (actions.getAddedMovie().getGenres().contains(genre)) {
                        user.addNotification(new Notifications(actions
                                .getAddedMovie().getName(), "ADD"));
                        break;
                    }
                }
            }
        }
    }

    /**
     *
     * @param actions
     */
    public void remove(final Actions actions) {
        int ok = 0;
        for (Movies movies : new Input().getMovies()) {
            if (movies.getName().equals(actions.getDeletedMovie())) {
                ok = 1;
            }
        }
        if (ok == 0) {
            TempOutput tempOutput = new TempOutput();
            tempOutput.addObjectNode(new Output().getOutputError());
            return;
        }
        Movies movieToDelete = new Movies();
        for (Movies movies : new Input().getMovies()) {
            if (movies.getName().equals(actions.getDeletedMovie())) {
                movieToDelete = movies;
                break;
            }
        }
        new Input().getMovies().remove(movieToDelete);
        for (Users user : new Input().getUsers()) {
            if (user.getPurchasedMovies().contains(movieToDelete)) {
                user.getPurchasedMovies().remove(movieToDelete);
                if (user.getCredentials().getAccountType().equals("premium")) {
                    user.setNumFreePremiumMovies(user.getNumFreePremiumMovies() + 1);
                } else {
                    user.setTokensCount(user.getTokensCount() + 2);
                }
                user.addNotification(new Notifications(actions
                        .getDeletedMovie(), "DELETE"));
            }
            if (user.getWatchedMovies().contains(movieToDelete)) {
                user.getWatchedMovies().remove(movieToDelete);
            }
            if (user.getRatedMovies().contains(movieToDelete)) {
                user.getRatedMovies().remove(movieToDelete);
            }
            if (user.getLikedMovies().contains(movieToDelete)) {
                user.getLikedMovies().remove(movieToDelete);
            }

        }
    }
}
