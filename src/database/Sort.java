package database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Sort {
    private String rating;
    private String duration;

    @Override
    public String toString() {
        return "sort{" + "rating=" + rating + ", duration=" + duration + '}';
    }
}
