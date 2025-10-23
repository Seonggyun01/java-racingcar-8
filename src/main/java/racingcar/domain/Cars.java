package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
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

    public List<Car> getCarList(){
        return carList;
    }
}
