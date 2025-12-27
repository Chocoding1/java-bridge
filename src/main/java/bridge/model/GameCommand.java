package bridge.model;

public class GameCommand {

    private static final String QUIT_COMMAND = "Q";
    private static final String RETRY_COMMAND = "R";

    private static final String ERR_INVALID_COMMAND = "[ERROR] 게임 재시작/종료 여부는 R 또는 Q만 입력할 수 있습니다.";

    private final String command;

    public GameCommand(String command) {
        validateCommand(command);
        this.command = command;
    }

    public boolean isQuit() {
        return command.equals(QUIT_COMMAND);
    }

    private void validateCommand(String command) {
        if (!command.equals(RETRY_COMMAND) && !command.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(ERR_INVALID_COMMAND);
        }
    }
}
