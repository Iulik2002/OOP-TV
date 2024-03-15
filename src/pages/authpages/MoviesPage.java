package pages.authpages;

import database.Movies;
import database.Output;
import database.Users;
import database.Actions;
import database.TempOutput;
import pages.CurrentPage;
import pages.CurrentUser;
import pages.MyPage;
import pages.authpages.seedetails.SeeDetails;
import pages.authpages.upgrades.UpgradesPage;
import pages.nonauthpages.NonAuthPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MoviesPage implements CurrentPage {
    private MyPage myPage = new MyPage();

    /**
     *
     * @param actions
     */
    public void changePage(final Actions actions) {
        myPage.setMyPage(new MoviesPage());
        TempOutput tempOutput = new TempOutput();
        switch (actions.getPage()) {
            case "see details":
                for (Movies movie : new CurrentUser().getMoviesArrayList()) {
                    if (movie.getName().equals(actions.getMovie())) {
                        new SeeDetails().setViewMovie(movie);
                        myPage.setMyPage(new SeeDetails());
                        ArrayList<Movies> oneMovieList = new ArrayList<>();
                        oneMovieList.add(movie);
                        new CurrentUser().setOneMoviesList(new CurrentUser().getMoviesArrayList());
                        new CurrentUser().resetMovieArrayList(oneMovieList);
                        tempOutput.addObjectNode(new Output().getOutputMovies());
                        new CurrentUser().resetMovieArrayList(new CurrentUser().getOneMoviesList());
                        break;
                    }
                }
                new CurrentUser().resetMovieArrayList(new CurrentUser().getCopyMoviesArrayList());
                if (myPage.getMyPage().getClass().getName().equals(MoviesPage.class.getName())) {
                    myPage.setMyPage(new MoviesPage());
                    tempOutput.addObjectNode(new Output().getOutputError());
                }
                break;
            case "upgrades":
                new CurrentUser().resetMovieArrayList(new CurrentUser().getCopyMoviesArrayList());
                myPage.setMyPage(new UpgradesPage());
                break;
            case "movies":
                new CurrentUser().resetMovieArrayList(new CurrentUser().getCopyMoviesArrayList());
                tempOutput.addObjectNode(new Output().getOutputMovies());
                myPage.setMyPage(new MoviesPage());
                break;
            case "logout":
                new CurrentUser().resetMovieArrayList(new ArrayList<>());
                myPage.setMyPage(new NonAuthPage());
                break;
            case "authPage":
                new CurrentUser().resetMovieArrayList(new ArrayList<>());
                myPage.setMyPage(new AuthPage());
                break;
            default:
                tempOutput.addObjectNode(new Output().getOutputError());
                myPage.setMyPage(new MoviesPage());
                break;
        }
    }

    /**
     *
     * @param actions
     * @param usersArrayList
     */
    public void onPage(final Actions actions, final ArrayList<Users> usersArrayList) {
        TempOutput tmpOutput = new TempOutput();

        switch (actions.getFeature()) {
            case "filter":
                ArrayList<Movies> movieArrayList = new CurrentUser().getMoviesArrayList();
                new CurrentUser().setCopyMoviesArrayList(new CurrentUser().getMoviesArrayList());
                if (actions.getFilters().getSort() != null) {
                    if (actions.getFilters().getSort().getRating() != null) {
                        if (actions.getFilters().getSort().getDuration() != null) {
                            //TO DO sortarea dupa rating si durata
                            ArrayList<Movies> moviesArrayList = new CurrentUser()
                                    .getMoviesArrayList();
                            if (actions.getFilters().getSort().getRating().equals("increasing")
                                    && actions.getFilters().getSort()
                                    .getDuration().equals("increasing")) {
                                Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                    @Override
                                    public int compare(final Movies o1, final Movies o2) {
                                        int ratingCompare = Integer.compare(o1
                                                .getDuration(), o2.getDuration());
                                        if (ratingCompare != 0) {
                                            return ratingCompare;
                                        } else {
                                            return Double.compare(o1.getRating(), o2.getRating());
                                        }
                                    }
                                });
                            }
                            if (actions.getFilters().getSort().getRating().equals("decreasing")
                                    && actions.getFilters().getSort().getDuration()
                                    .equals("decreasing")) {

                                Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                    @Override
                                    public int compare(final Movies o1, final Movies o2) {
                                        int ratingCompare = Integer.compare(o2
                                                .getDuration(), o1.getDuration());
                                        if (ratingCompare != 0) {
                                            return ratingCompare;
                                        } else {
                                            return Double.compare(o2.getRating(), o1.getRating());
                                        }
                                    }
                                });
                            }
                            if (actions.getFilters().getSort().getRating().equals("decreasing")
                                    && actions.getFilters().getSort().getDuration()
                                    .equals("increasing")) {
                                Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                    @Override
                                    public int compare(final Movies o1, final Movies o2) {
                                        int ratingCompare = Integer.compare(o1
                                                .getDuration(), o2.getDuration());
                                        if (ratingCompare != 0) {
                                            return ratingCompare;
                                        } else {
                                            return Double.compare(o2.getRating(), o1.getRating());
                                        }
                                    }
                                });
                            }
                            if (actions.getFilters().getSort().getRating().equals("increasing")
                                    && actions.getFilters().getSort()
                                    .getDuration().equals("decreasing")) {
                                Collections.sort(movieArrayList, new Comparator<Movies>() {
                                    @Override
                                    public int compare(final Movies o1, final Movies o2) {
                                        int ratingCompare = Integer.compare(o2
                                                .getDuration(), o1.getDuration());
                                        if (ratingCompare != 0) {
                                            return ratingCompare;
                                        } else {
                                            return Double.compare(o1
                                                    .getRating(), o2.getRating());
                                        }
                                    }
                                });
                            }
                        } else {
                            //TO DO sortarea dupa rating
                            CurrentUser currentUser = new CurrentUser();
                            ArrayList<Movies> moviesArrayList = new CurrentUser()
                                    .getMoviesArrayList();
                            if (actions.getFilters().getSort().getRating().equals("increasing")) {
                                Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                    public int compare(final Movies o1, final Movies o2) {
                                        return Double.compare(o1.getRating(), o2.getRating());
                                    }
                                });
                            } else {
                                Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                    public int compare(final Movies o1, final Movies o2) {
                                        return Double.compare(o2.getRating(), o1.getRating());
                                    }
                                });
                            }
                        }


                    } else {
                        //TO DO sortarea dupa durata
                        CurrentUser currentUser = new CurrentUser();
                        ArrayList<Movies> moviesArrayList = new CurrentUser().getMoviesArrayList();
                        if (actions.getFilters().getSort().getDuration().equals("increasing")) {
                            Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                public int compare(final Movies o1, final Movies o2) {
                                    return Integer.compare(o1.getDuration(), o2.getDuration());
                                }
                            });
                        } else {
                            Collections.sort(moviesArrayList, new Comparator<Movies>() {
                                public int compare(final Movies o1, final Movies o2) {
                                    return Integer.compare(o2.getDuration(), o1.getDuration());
                                }
                            });
                        }
                    }
                }
                ArrayList<Movies> filteredMovieList = new ArrayList<>();
                int ok = 0;
                    if (actions.getFilters().getContains() != null) {
                    if (actions.getFilters().getContains().getActors() != null) {
                        for (Movies movie : movieArrayList) {
                            if (movie.getActors().containsAll(actions.getFilters()
                                    .getContains().getActors())) {
                                filteredMovieList.add(movie);
                                ok = 1;
                            }
                        }
                    }
                    if (actions.getFilters().getContains().getGenre() != null) {
                        if (ok == 1) {
                            ArrayList<Movies> secondFilteredMovieList = new ArrayList<>();
                            for (Movies movie : filteredMovieList) {
                                if (movie.getGenres().containsAll(actions.getFilters()
                                        .getContains().getGenre())) {
                                    secondFilteredMovieList.add(movie);
                                }
                            }
                            filteredMovieList = secondFilteredMovieList;
                        } else {
                            ArrayList<Movies> secondFilteredMovieList = new ArrayList<>();
                            for (Movies movie : movieArrayList) {
                                if (movie.getGenres().containsAll(actions.getFilters()
                                        .getContains().getGenre())) {

                                    secondFilteredMovieList.add(movie);
                                }
                            }
                            filteredMovieList = secondFilteredMovieList;
                        }
                    }

                }
                    if (!filteredMovieList.equals(new ArrayList<>()) || ok == 1) {
                        new CurrentUser().resetMovieArrayList(filteredMovieList);
                        tmpOutput.addObjectNode(new Output().getOutputMovies());
                    } else {
                        new CurrentUser().resetMovieArrayList(movieArrayList);
                        tmpOutput.addObjectNode(new Output().getOutputMovies());
                    }

                break;

            case "search":
                ArrayList<Movies> moviesArrayList = new ArrayList<>();
                ArrayList<Movies> userMovie = new CurrentUser().getMoviesArrayList();
                for (Movies movie : userMovie) {
                    if (movie.getName().startsWith(actions.getStartsWith())) {
                        moviesArrayList.add(movie);
                    }
                }
                new CurrentUser().resetMovieArrayList(moviesArrayList);
                tmpOutput.addObjectNode(new Output().getOutputMovies());
                new CurrentUser().resetMovieArrayList(userMovie);
                break;
            default:
                myPage.setMyPage(new MoviesPage());
                tmpOutput.addObjectNode(new Output().getOutputError());
                break;
        }
    }
}
