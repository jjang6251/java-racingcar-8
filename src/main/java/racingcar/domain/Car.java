package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName name;
    private int position;


    public Car(CarName name) {
        this.name = name;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.value();
    }

}
