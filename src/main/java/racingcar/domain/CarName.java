package racingcar.domain;

import java.util.regex.Pattern;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern ALLOWED = Pattern.compile("^[가-힣A-Za-z0-9]+$");

    private final String name;

    public CarName(String name){
        this.name = name;
        validate();
    }

    private void validate(){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if(name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }

        if(name.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 입력할 수 없습니다.");
        }

        if(!ALLOWED.matcher(name).matches()){
            throw new IllegalArgumentException("이름에 특수문자는 입력할 수 없습니다.");
        }
    }

    public String getName(){
        return name;
    }
}
