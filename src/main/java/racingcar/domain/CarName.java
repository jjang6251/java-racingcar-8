package racingcar.domain;

public class CarName {
    private static final int MAX = 5;
    private final String value;

    public CarName(String raw) {
        if (raw.isEmpty()) throw new IllegalArgumentException("empty string err");
        if (raw.length() > MAX) throw new IllegalArgumentException("car name length exceeded");
        this.value = raw;
    }
    public String value() { return value; } // 값 객체라 조회 허용
}
