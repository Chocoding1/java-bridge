package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printStart();
        int inputSize = inputView.readBridgeSize();

    }
}
