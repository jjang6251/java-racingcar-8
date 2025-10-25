package racingcar;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameParserTest {
    @DisplayName("쉼표(,) 이외의 구분자를 사용하면 예외가 발생한다.")
    @Test
    void 쉼표_구분자_성공_케이스() {
        String input = "pobi,woni";

        List<String> result = CarNameParser.parse(input);

        assertThat(result)
                .hasSize(2)
                .containsExactly("pobi", "woni");
    }

    @DisplayName("쉼표(,) 이외의 구분자를 사용하면 예외가 발생한다.")
    @Test
    void 쉼표_이외의_구분자_예외발생() {
        String input = "pobi:woni";

        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("separator err");
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생.")
    @Test
    void 자동차_이름_5자_초과() {
        String input = "pobibi,woniwoni";

        assertThatThrownBy(() -> CarNameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name length exceeded");
    }

    @DisplayName("빈 문자열 또는 공백만 입력한 경우 예외 발생")
    @Test
    void 빈문자열_공백_예외발생() {
        String input1 = "";
        String input2 = "   ";

        assertThatThrownBy(() -> CarNameParser.parse(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty string err");
        assertThatThrownBy(() -> CarNameParser.parse(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("blank field err");
    }
}
