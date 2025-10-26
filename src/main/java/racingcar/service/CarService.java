package racingcar.service;

import java.util.List;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;
import racingcar.dto.RoundResultDto;

public interface CarService {
    Race createRace(String input);
    List<RoundResultDto> runOneRound(Race race, MoveStrategy moveStrategy);
}
