package racingcar.domain;

public class Car {
    private final Integer INIT_POSITION = 0;
    private final Integer MAX_NAME_LENGTH = 5;

    private final String carName;
    private int position;

    public Car(String name){
        validateName(name);
        this.carName = name;
        position = INIT_POSITION;
    }

    private void validateName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if(name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }

        if(name.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 입력할 수 없습니다.");
        }
    }

    public void move(){
        this.position++;
    }

    public String getCarName(){
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
