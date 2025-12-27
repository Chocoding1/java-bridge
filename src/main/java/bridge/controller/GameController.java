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
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (!bridgeGame.isFinish()) {
            String moving = inputView.readMoving();
            if (!bridgeGame.move(moving)) {
                outputView.printMap(bridgeGame);
                selectGameCommand(bridgeGame);
                continue;
            }
            outputView.printMap(bridgeGame);
        }
    }

    private void selectGameCommand(BridgeGame bridgeGame) {
        String restartCommand = inputView.readGameCommand();
        if (!restartCommand.equals("R") && !restartCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 여부는 R 또는 Q만 입력할 수 있습니다.");
        }

        if (restartCommand.equals("R")) {
            bridgeGame.retry();
        }

        if (restartCommand.equals("Q")) {
            bridgeGame.quit();
        }
    }
}
