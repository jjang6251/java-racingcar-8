package racingcar.controller;

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
    }
}
