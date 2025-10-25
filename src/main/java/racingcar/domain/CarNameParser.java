package racingcar.domain;

import java.util.List;

public class CarNameParser {
    private CarNameParser() {}

    public static List<String> parse(String rawCarnames) {

        String[] parsedCarname = rawCarnames.split(",",-1);
        return List.of(parsedCarname);
    }
}
