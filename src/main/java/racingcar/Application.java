package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.RandomMoveStrategy;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.view.CarView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarView carView = new CarView();
        CarService carService = new CarServiceImpl(new RandomMoveStrategy());
        var controller = new CarController(carView, carService);
        controller.run();
    }
}
