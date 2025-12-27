package bridge.controller;

import static bridge.util.ExceptionHandler.*;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.GameCommand;
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
        Bridge bridge = retryUtilSuccess(this::createBridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!bridgeGame.isFinish()) {
            String moving = retryUtilSuccess(inputView::readMoving);
            if (!bridgeGame.move(moving)) {
                outputView.printMap(bridgeGame);
                GameCommand gameCommand = retryUtilSuccess(() -> new GameCommand(inputView.readGameCommand()));
                if (gameCommand.isQuit()) {
                    break;
                }
                bridgeGame.retry();
                continue;
            }
            outputView.printMap(bridgeGame);
        }
        outputView.printResult(bridgeGame);
    }

    private Bridge createBridge() {
        int inputSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(inputSize));
    }
}
