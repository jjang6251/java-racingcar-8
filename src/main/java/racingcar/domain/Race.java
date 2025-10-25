package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        if(cars.isEmpty()) {
            throw new IllegalArgumentException("need at least 1 car");
        }
        this.cars = List.copyOf(cars);
    }

}
