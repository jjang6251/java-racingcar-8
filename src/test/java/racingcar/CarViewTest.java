package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.CarView;

import static org.assertj.core.api.Assertions.*;

public class CarViewTest {
    @DisplayName("숫자 입력을 정상적으로 파싱한다")
    @Test
    void 숫자_입력_성공() {
        String input = "5";
        CarView carview = new CarView();

        int count = carview.getCount();

        assertThat(count).isEqualTo(5);
    }

    @DisplayName("숫자가 아닌 입력이면 IllegalArgumentException을 던진다")
    @Test
    void 숫자_아닌_입력_예외() {
        String input = "input";
        CarView carView = new CarView();

        assertThatThrownBy(() -> carView::getCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should enter a number");
    }
}
