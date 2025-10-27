package racingcar.domain;

import java.util.List;

public class CarNameParser {
    private CarNameParser() {
    }

    public static List<String> parse(String rawCarNames) {

        String[] parsedCarName = rawCarNames.split(",", -1);
        return List.of(parsedCarName);
    }
}
