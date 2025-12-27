package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private static final String SUCCESS_MARK = "O";
    private static final String FAIL_MARK = "X";
    private static final String SUCCESS_PHRASE = "성공";
    private static final String FAIL_PHRASE = "실패";

    private final List<String> result = new ArrayList<>();
    private String gameSuccess = FAIL_PHRASE;

    public void addSuccessResult() {
        result.add(SUCCESS_MARK);
    }

    public void addFailResult() {
        result.add(FAIL_MARK);
    }

    public boolean isMove(int idx) {
        return result.get(idx).equals(SUCCESS_MARK);
    }

    public boolean checkSuccessGame(int idx) {
        return result.size() == idx;
    }

    public void updateSuccess() {
        gameSuccess = SUCCESS_PHRASE;
    }

    public String getGameSuccess() {
        return gameSuccess;
    }
}
