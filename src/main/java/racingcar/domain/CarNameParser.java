package racingcar.domain;

import java.util.List;

public class CarNameParser {
    public CarNameParser() {}

    public static List<String> parse(String rawCarnames) {

        String[] parsedCarname = rawCarnames.split(",");
        return List.of(parsedCarname);
    }
}
