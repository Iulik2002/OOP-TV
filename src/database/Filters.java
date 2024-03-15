package database;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public final class Filters {
    private Sort sort;
    private FilterContent contains;

    @Override
    public String toString() {
        return "filters{" + "sort=" + sort + ", contains=" + contains + '}';
    }
}
