package bridge;

import bridge.config.AppConfig;
import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();
        gameController.run();
    }
}
