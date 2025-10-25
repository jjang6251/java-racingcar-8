package racingcar.view;

import camp.nextstep.edu.missionutils.*;

public class CarView {
    public String getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String s = Console.readLine();
        try {
            int n = Integer.parseInt(s);
            if(n <= 0) throw new IllegalArgumentException("The number of attempts must be a positive integer.");
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("should enter a number");
        }
    }
}
