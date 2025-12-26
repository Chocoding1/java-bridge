package bridge.config;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {

    private GameController gameController;
    private OutputView outputView;
    private InputView inputView;

    public GameController gameController() {
        if (gameController == null) {
            gameController = new GameController(outputView(), inputView());
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
}
