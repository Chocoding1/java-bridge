package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(int currentIdx, String movingCommand) {
        return bridge.get(currentIdx).equals(movingCommand);
    }

    public boolean IsOutOfIdx(int currentIdx) {
        return bridge.size() <= currentIdx;
    }
}
