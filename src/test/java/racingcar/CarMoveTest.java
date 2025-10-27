package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveTest {
    @DisplayName("무작위 값이 4이상인 경우(참) 전진하는지")
    @Test
    void 무작위_값이_참일_경우_전진() {
        Car car = new Car(new CarName("Pobi"));
        MoveStrategy alwaysmove = () -> true;

        car.move(alwaysmove);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("무작위 값이 4 미만일 경우(거짓) 정지")
    @Test
    void 무작위_값이_거짓일_경우_정지() {
        Car car = new Car(new CarName("Pobi"));
        MoveStrategy nevermove = () -> false;

        car.move(nevermove);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
