package bridge.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 정상 생성 테스트")
    void makeBridge_success() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 3;

        //when
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        //then
        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    @DisplayName("입력받은 다리 길이가 3 ~ 20 사이의 숫자가 아닐 경우 예외 발생")
    void makeBridge_fail_when_bridgeSize_out_of_range(int bridgeSize) {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when & then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}