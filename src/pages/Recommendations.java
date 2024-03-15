package pages;

import database.Movies;
import database.Notifications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Recommendations {
    /**
     *
     */
    public void recommend() {
        ArrayList<Genres> genresArrayList = new ArrayList<>();
        ArrayList<String> stringsGenresArrayList = new ArrayList<>();
        for (Movies movie : new CurrentUser().getCurrentUser().getLikedMovies()) {
            for (String gen : movie.getGenres()) {
                if (!stringsGenresArrayList.contains(gen)) {
                    stringsGenresArrayList.add(gen);
                    genresArrayList.add(new Genres(gen, 1));
                } else {
                    for (Genres genres: genresArrayList) {
                        if (genres.getGenre().equals(gen)) {
                            genres.setLikes(genres.getLikes() + 1);
                            break;
                        }
                    }
                }
            }
        }
        Collections.sort(genresArrayList, new Comparator<Genres>() {
            @Override
            public int compare(final Genres o1, final Genres o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });
        Collections.sort(new CurrentUser().getMoviesArrayList(), new Comparator<Movies>() {
            @Override
            public int compare(final Movies o1, final Movies o2) {
                return (int) o2.getNumLikes() - (int) o1.getNumLikes();
            }
        });

        for (Movies movies : new CurrentUser().getMoviesArrayList()) {
            if (!new CurrentUser().getCurrentUser().getWatchedMovies().contains(movies)) {
                for (Genres genres: genresArrayList) {
                    if (movies.getGenres().contains(genres.getGenre())) {
                        new CurrentUser().getCurrentUser().addNotification(new Notifications(
                                movies.getName(), "Recommendation"));
                        return;
                    }
                }
            }
        }
        new CurrentUser().getCurrentUser().addNotification(new Notifications(
                "No recommendation", "Recommendation"));

    }
}
