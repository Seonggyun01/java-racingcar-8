package racingcar.domain;

public class Count {
    private static int MIN_COUNT = 0;
    private final int count;

    public Count(String rawCount) {
        validate(rawCount);
        this.count = Integer.parseInt(rawCount);
    }

    private static void validate(String rawCount) {
        if (rawCount == null || rawCount.isEmpty()) {
            throw new IllegalArgumentException("횟수를 입력해주세요.");
        }

        try {
            Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 정수를 입력해야합니다.");
        }

        if (Integer.parseInt(rawCount) < MIN_COUNT) {
            throw new IllegalArgumentException("횟수는 양수를 입력해야합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
