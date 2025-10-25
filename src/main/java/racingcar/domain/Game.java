package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private static final int MOVABLE_LOWER_BOUND = 4;
    private Cars cars;

    public Game(Cars cars){
        this.cars = cars;
    }

    public void play(){
        for(Car car: cars.getCarList()){
            moveIfMovable(car);
        }
    }

    private static void moveIfMovable(Car car) {
        if(Randoms.pickNumberInRange(0,9)>=MOVABLE_LOWER_BOUND){
            car.move();
        }
    }

}
