package bridge.model;

import java.util.List;

public class Bridge {

    private static final String DOWN_COMMAND = "D";

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = List.copyOf(bridge);
    }

    public boolean canMove(int currentIdx, String movingCommand) {
        return bridge.get(currentIdx).equals(movingCommand);
    }

    public boolean IsOutOfIdx(int currentIdx) {
        return bridge.size() <= currentIdx;
    }

    public boolean isDown(int idx) {
        return bridge.get(idx).equals(DOWN_COMMAND);
    }
}
