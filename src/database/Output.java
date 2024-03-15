package database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.Setter;
import pages.CurrentUser;

import java.util.ArrayList;

@Getter
@Setter
public final class Output {
    private ArrayList<Movies> movies = new Input().getMovies();
    private Users currentUser = new CurrentUser().getCurrentUser();

    public Output() {
    }

    /**
     *
     * @return
     */
    public ObjectNode getOutputError() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode output;
        output = mapper.createObjectNode();
        output.put("error", "Error");
        output.set("currentMoviesList", mapper.valueToTree(new ArrayList<>()));
        output.set("currentUser", mapper.valueToTree(null));
        return output;
    }

    /**
     *
     * @return
     */
    public ObjectNode getOutputMovies() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode output;
        output = mapper.createObjectNode();
        output.set("error", mapper.valueToTree(null));
        output.set("currentMoviesList", mapper.valueToTree(new CurrentUser().getMoviesArrayList()));
        output.set("currentUser", mapper.valueToTree(new CurrentUser().getCurrentUser()));
        return output;
    }

    /**
     *
     * @return
     */
    public ObjectNode getOutput() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode output;
        output = mapper.createObjectNode();
        output.set("error", mapper.valueToTree(null));
        output.set("currentMoviesList", mapper.valueToTree(new ArrayList<>()));
        output.set("currentUser", mapper.valueToTree(new CurrentUser().getCurrentUser()));
        return output;
    }
}

