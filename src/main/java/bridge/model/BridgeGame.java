package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private int currentIdx = 0;
    private GameResult gameResult;
    private int gameTryCount = 1;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.gameResult = new GameResult();
    }

    public boolean isFinish() {
        return bridge.IsOutOfIdx(currentIdx);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movingCommand) {
        if (!movingCommand.equals("U") && !movingCommand.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로만 입력해야 합니다.");
        }

        if (bridge.canMove(currentIdx++, movingCommand)) {
            gameResult.addMoveResult("O");
            return true;
        }

        gameResult.addMoveResult("X");
        return false;
    }

    public int getCurrentIdx() {
        return currentIdx;
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

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameTryCount++;
        currentIdx = 0;
        gameResult = new GameResult();
    }

    public void quit() {
        currentIdx = 20;
    }
}
