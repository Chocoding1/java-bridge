package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<String> result = new ArrayList<>();

    public void addMoveResult(String movingResult) {
        result.add(movingResult);
    }
}
