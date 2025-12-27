package bridge.model;

public class GameCommand {

    private final String command;

    public GameCommand(String command) {
        validateCommand(command);
        this.command = command;
    }

    public boolean isQuit() {
        return command.equals("Q");
    }

    private void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 여부는 R 또는 Q만 입력할 수 있습니다.");
        }
    }
}
