package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_NOTICE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_NOTICE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART_GAME_NOTICE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String ERR_BRIDGE_SIZE_INTEGER = "[ERROR] 다리의 길이는 정수 형태로 입력해야 합니다.";
    private static final String ERR_INVALID_MOVING_COMMAND = "[ERROR] 이동할 칸은 U 또는 D로만 입력해야 합니다.";

    private static final String UP_MARK = "U";
    private static final String DOWN_MARK = "D";

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_NOTICE);
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE_INTEGER);
        }
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING_NOTICE);
        String input = Console.readLine();
        if (!input.equals(UP_MARK) && !input.equals(DOWN_MARK)) {
            throw new IllegalArgumentException(ERR_INVALID_MOVING_COMMAND);
        }
        return input;
    }

    public String readGameCommand() {
        System.out.println(INPUT_RESTART_GAME_NOTICE);
        return Console.readLine();
    }
}
