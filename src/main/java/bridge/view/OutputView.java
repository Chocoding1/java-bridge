package bridge.view;

import bridge.model.BridgeGame;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String GAME_START_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_NOTICE = "최종 게임 결과";
    private static final String GAME_SUCCESS_RESULT_NOTICE = "게임 성공 여부: ";
    private static final String GAME_TRY_COUNT_NOTICE = "총 시도한 횟수: ";

    private static final String SUCCESS_MARK = "O";
    private static final String FAIL_MARK = "X";
    private static final String LEFT_SQUARE_BRACKET_FORMAT = "[ ";
    private static final String RIGHT_SQUARE_BRACKET_FORMAT = " ]";
    private static final String PIPE_FORMAT = " | ";

    public void printStart() {
        System.out.println(GAME_START_NOTICE);
    }

    public void printMap(BridgeGame bridgeGame) {
        printUpMap(bridgeGame);
        printDownMap(bridgeGame);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT_NOTICE);
        printUpMap(bridgeGame);
        printDownMap(bridgeGame);
        System.out.println(GAME_SUCCESS_RESULT_NOTICE + bridgeGame.getSuccessResult());
        System.out.println(GAME_TRY_COUNT_NOTICE + bridgeGame.getGameTryCount());
    }

    private static void printUpMap(BridgeGame bridgeGame) {
        List<String> resultMap = new ArrayList<>();
        for (int i = 0; i < bridgeGame.getCurrentIdx(); i++) {
            if (bridgeGame.isBridgeUp(i) && bridgeGame.isMove(i)) {
                resultMap.add(SUCCESS_MARK);
                continue;
            }
            if (bridgeGame.isBridgeDown(i) && bridgeGame.isNotMove(i)) {
                resultMap.add(FAIL_MARK);
                continue;
            }
            resultMap.add(" ");
        }
        printMap(resultMap);
    }

    private static void printDownMap(BridgeGame bridgeGame) {
        List<String> resultMap = new ArrayList<>();
        for (int i = 0; i < bridgeGame.getCurrentIdx(); i++) {
            if (bridgeGame.isBridgeDown(i) && bridgeGame.isMove(i)) {
                resultMap.add(SUCCESS_MARK);
                continue;
            }
            if (bridgeGame.isBridgeUp(i) && bridgeGame.isNotMove(i)) {
                resultMap.add(FAIL_MARK);
                continue;
            }
            resultMap.add(" ");
        }
        printMap(resultMap);
    }

    private static void printMap(List<String> resultMap) {
        System.out.println(
                resultMap.stream()
                        .collect(Collectors.joining(PIPE_FORMAT, LEFT_SQUARE_BRACKET_FORMAT, RIGHT_SQUARE_BRACKET_FORMAT))
        );
    }
}
