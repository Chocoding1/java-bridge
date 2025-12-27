package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "*"})
    @DisplayName("게임 재시작/종료 여부 명령어가 R이나 Q가 아닐 경우 예외 발생")
    void createGameCommand_fail_when_invalid_command(String command) {
        //when & then
        assertThatThrownBy(() -> new GameCommand(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}