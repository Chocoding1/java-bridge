package bridge.view;

import bridge.model.BridgeGame;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_NOTICE = "최종 게임 결과";
    private static final String GAME_SUCCESS_RESULT_NOTICE = "게임 성공 여부: ";
    private static final String GAME_TRY_COUNT_NOTICE = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(GAME_START_NOTICE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        printUpMap(bridgeGame);
        printDownMap(bridgeGame);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
                resultMap.add("O");
                continue;
            }
            if (bridgeGame.isBridgeDown(i) && bridgeGame.isNotMove(i)) {
                resultMap.add("X");
                continue;
            }
            resultMap.add(" ");
        }
        System.out.println(
                resultMap.stream()
                        .collect(Collectors.joining(" | ", "[ ", " ]"))
        );
    }

    private static void printDownMap(BridgeGame bridgeGame) {
        List<String> resultMap = new ArrayList<>();
        for (int i = 0; i < bridgeGame.getCurrentIdx(); i++) {
            if (bridgeGame.isBridgeDown(i) && bridgeGame.isMove(i)) {
                resultMap.add("O");
                continue;
            }
            if (bridgeGame.isBridgeUp(i) && bridgeGame.isNotMove(i)) {
                resultMap.add("X");
                continue;
            }
            resultMap.add(" ");
        }
        System.out.println(
                resultMap.stream()
                        .collect(Collectors.joining(" | ", "[ ", " ]"))
        );
    }
}
