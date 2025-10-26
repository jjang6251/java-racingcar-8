package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("need at least 1 car");
        }
        this.cars = List.copyOf(cars);
    }

    public void runRound(MoveStrategy moveStrategy) {
        cars.forEach(c -> c.move(moveStrategy));
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

}
