package racingcar.domain;

public class Car {
    private static final int INIT_POSITION = 0;

    private final CarName carName;
    private int position;

    public Car(String name){
        this.carName = new CarName(name);
        position = INIT_POSITION;
    }

    public void move(){
        this.position++;
    }

    public String getCarName(){
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

}
