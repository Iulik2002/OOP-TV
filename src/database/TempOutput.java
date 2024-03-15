package database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public final class TempOutput {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static ArrayNode tempOut;
    public ArrayNode getTempOut() {
        return tempOut;
    }

    /**
     *
     * @param tempOut
     */
    public void addObjectNode(final ObjectNode tempOut) {
        TempOutput.tempOut.add(tempOut);
    }

    /**
     *
     */
    public void createTempOut() {
        TempOutput.tempOut = objectMapper.createArrayNode();
    }


}
