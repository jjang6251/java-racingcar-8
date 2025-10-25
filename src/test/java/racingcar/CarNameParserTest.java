package racingcar;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class CarNameParserTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarServiceImpl();
    }

    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생.")
    @Test
    void 자동차_이름_5자_초과() {
        String input = "pobibi,woniwoni";


        assertThatThrownBy(() -> carService.createRace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name length exceeded");
    }

    @DisplayName("빈 문자열 또는 공백만 입력한 경우 예외 발생")
    @Test
    void 빈문자열_공백_예외발생() {
        String input = "";

        assertThatThrownBy(() -> carService.createRace(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty string err");
    }
}