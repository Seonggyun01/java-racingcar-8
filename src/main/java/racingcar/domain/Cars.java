package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }
    public static Cars fromNames(List<String> carNames){
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public Cars findWinners(){
        int max = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        List<Car> winners = carList.stream()
                .filter(c-> c.getPosition() == max)
                .toList();

        return new Cars(winners);
    }

    public String[] getWinnersName(){
        return carList.stream()
                .map(Car::getCarName)
                .toArray(String[]::new);
    }

    public List<Car> getCarList(){
        return carList;
    }
}
