package pages;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public final class Genres {
    private String genre;
    private Integer likes;

    public Genres(final String genre, final Integer likes) {
        this.genre = genre;
        this.likes = likes;
    }
}
