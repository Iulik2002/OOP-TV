package database;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class Actions {
    private String movie;
    private String type;
    private String page;
    private String feature;
    private Credentials credentials;
    private String startsWith;
    private int count;
    private int rate;
    private Filters filters;
    private String deletedMovie;
    private String subscribedGenre;
    private Movies addedMovie;

    @Override
    public String toString() {
        return "actions{" + "type=" + type
                + ", page=" + page
                + ", movie=" + movie
                + ", feature=" + feature
                + ", filters=" + filters
                + ", credentials=" + credentials
                + ", startsWith=" + startsWith
                + ", count=" + count
                + ", rate=" + rate + '}';
    }
}
