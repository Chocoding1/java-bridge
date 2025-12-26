package bridge.config;

import bridge.controller.GameController;
import bridge.view.OutputView;

public class AppConfig {

    private GameController gameController;
    private OutputView outputView;

    public GameController gameController() {
        if (gameController == null) {
            gameController = new GameController(outputView());
        }
        return gameController;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
