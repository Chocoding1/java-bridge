package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<String> result = new ArrayList<>();
    private String gameSuccess = "실패";

    public void addMoveResult(String movingResult) {
        result.add(movingResult);
    }

    public boolean isMove(int idx) {
        return result.get(idx).equals("O");
    }

    public boolean checkSuccessGame(int idx) {
        return result.size() == idx;
    }

    public void updateSuccess() {
        gameSuccess = "성공";
    }

    public String getGameSuccess() {
        return gameSuccess;
    }
}
