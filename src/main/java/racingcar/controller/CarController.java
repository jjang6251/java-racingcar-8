package racingcar.controller;

import java.util.List;
import racingcar.domain.Race;
import racingcar.dto.FinalResultDto;
import racingcar.dto.RoundResultDto;
import racingcar.service.CarService;
import racingcar.view.CarView;

public class CarController {
    private final CarView carView;
    private final CarService carService;


    public CarController(CarView carView, CarService carService) {
        this.carView = carView;
        this.carService = carService;
    }

    public void run() {
        String names = carView.getCarNameInput();
        int attempt = carView.getCount();
        Race race = carService.createRace(names);
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempt; i++) {
            //라운드 실행
            List<RoundResultDto> roundResultDto = carService.runOneRound(race);
            carView.printRound(roundResultDto);
        }
        FinalResultDto finalResultDto = carService.findWinners(race);
        carView.printFinalWinner(finalResultDto);
    }
}
