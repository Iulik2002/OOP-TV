package database;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public final class FilterContent {
    private Movies filterContent;
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    @Override
    public String toString() {
        return "contains{" + filterContent + '}';
    }
}
