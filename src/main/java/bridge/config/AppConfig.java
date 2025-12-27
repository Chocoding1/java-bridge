package bridge.config;

import bridge.controller.GameController;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {

    private GameController gameController;
    private OutputView outputView;
    private InputView inputView;
    private BridgeMaker bridgeMaker;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public GameController gameController() {
        if (gameController == null) {
            gameController = new GameController(outputView(), inputView(), bridgeMaker());
        }
        return gameController;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private BridgeMaker bridgeMaker() {
        if (bridgeMaker == null) {
            bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator());
        }
        return bridgeMaker;
    }

    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator() {
        if (bridgeRandomNumberGenerator == null) {
            bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        }
        return bridgeRandomNumberGenerator;
    }
}
