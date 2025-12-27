package bridge.model;

public class BridgeGame {

    private static final int START_INDEX = 0;
    private static final int START_TRY_COUNT = 1;

    private final Bridge bridge;
    private GameResult gameResult;
    private int currentIdx;
    private int gameTryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameResult = new GameResult();
        this.currentIdx = START_INDEX;
        this.gameTryCount = START_TRY_COUNT;
    }

    public boolean isFinish() {
        return bridge.IsOutOfIdx(currentIdx);
    }

    public boolean move(String movingCommand) {
        if (bridge.canMove(currentIdx++, movingCommand)) {
            gameResult.addSuccessResult();
            if (isSuccessGame(currentIdx)) {
                gameResult.updateSuccess();
            }
            return true;
        }

        gameResult.addFailResult();
        return false;
    }

    public int getCurrentIdx() {
        return currentIdx;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public String getSuccessResult() {
        return gameResult.getGameSuccess();
    }

    public boolean isBridgeUp(int idx) {
        return !bridge.isDown(idx);
    }

    public boolean isBridgeDown(int idx) {
        return bridge.isDown(idx);
    }

    public boolean isMove(int idx) {
        return gameResult.isMove(idx);
    }

    public boolean isNotMove(int idx) {
        return !gameResult.isMove(idx);
    }

    public void retry() {
        gameTryCount++;
        currentIdx = START_INDEX;
        gameResult = new GameResult();
    }

    private boolean isSuccessGame(int currentIdx) {
        return gameResult.checkSuccessGame(currentIdx);
    }
}
