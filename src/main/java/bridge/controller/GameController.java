package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

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
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputSize));
        BridgeGame bridgeGame = new BridgeGame(bridge, new GameResult());
        while (!bridgeGame.isFinish()) {
            String moving = inputView.readMoving();
            if (!bridgeGame.move(moving)) {
                outputView.printMap(bridgeGame);
            }
            outputView.printMap(bridgeGame);

        }
    }
}
