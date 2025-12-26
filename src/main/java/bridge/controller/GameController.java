package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public GameController(OutputView outputView, InputView inputView, BridgeMaker bridgeMaker) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        outputView.printStart();
        int inputSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(inputSize);
    }
}
