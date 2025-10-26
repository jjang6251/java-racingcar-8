package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean moveable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
