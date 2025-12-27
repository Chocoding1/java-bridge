package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<String> result = new ArrayList<>();

    public void addMoveResult(String movingResult) {
        result.add(movingResult);
    }

    public boolean isMove(int idx) {
        return result.get(idx).equals("O");
    }
}
