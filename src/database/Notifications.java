package database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Notifications {
    private String movieName;
    private String message;

    public Notifications(final String movieName, final String message) {
        this.movieName = movieName;
        this.message = message;
    }
}
