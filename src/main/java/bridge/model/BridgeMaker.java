package bridge.model;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private static final String UP_MARK = "U";
    private static final String DOWN_MARK = "D";

    private static final String ERR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3 ~ 20 사이의 숫자여야 합니다.";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (bridgeNumberGenerator.generate() == 1) {
                bridge.add(UP_MARK);
                continue;
            }
            bridge.add(DOWN_MARK);
        }
        return bridge;
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < size) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE);
        }
    }
}
