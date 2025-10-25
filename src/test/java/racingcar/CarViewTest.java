package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.CarView;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class CarViewTest {
    private void provideInput(String input) {
        System.setIn(new ByteArrayInputStream((input + System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
    }

    @AfterEach
    void consoleClose() {
        Console.close();
    }

    @DisplayName("숫자 입력을 정상적으로 파싱한다")
    @Test
    void 숫자_입력_성공() {
        provideInput("5");
        CarView carview = new CarView();

        int count = carview.getCount();

        assertThat(count).isEqualTo(5);
    }

    @DisplayName("숫자가 아닌 입력이면 IllegalArgumentException을 던진다")
    @Test
    void 숫자_아닌_입력_예외() {
        provideInput("abc");
        CarView carView = new CarView();

        assertThatThrownBy(carView::getCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should enter a number");
    }

    @DisplayName("0 이하의 숫자를 입력하면 IllegalArgumentException 발생")
    @Test
    void 음수_또는_0_입력_예외() {
        provideInput("0");
        CarView view = new CarView();

        assertThatThrownBy(view::getCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The number of attempts must be a positive integer.");
    }
}
