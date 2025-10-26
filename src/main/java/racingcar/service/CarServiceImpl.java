package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;
import racingcar.dto.RoundResultDto;

public class CarServiceImpl implements CarService {
    @Override
    public Race createRace(String input) {
        List<String> carNames = inputSeparate(input);
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("need at least 1 car");
        }
        var cars = carNames.stream()
                .map(CarName::new)          // 이름 규칙 검증
                .map(Car::new)              // 도메인 조립
                .toList();
        return new Race(cars);
    }

    @Override
    public List<RoundResultDto> runOneRound(Race race, MoveStrategy moveStrategy) {
        race.runRound(moveStrategy);
        return race.cars().stream()
                .map(c -> new RoundResultDto(c.getName(), c.getPosition()))
                .toList();
    }

    private static List<String> inputSeparate(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }
}
