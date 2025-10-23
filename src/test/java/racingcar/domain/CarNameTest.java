package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    void 이름이_1글자인_경우(){
        assertSimpleTest(()->{
            CarName carName = new CarName("z");
            assertThat(carName.getName()).isEqualTo("z");

        });
    }

    @Test
    void 이름이_5글자인_경우(){
        assertSimpleTest(()->{
            CarName carName = new CarName("zzzzz");
            assertThat(carName.getName()).isEqualTo("zzzzz");

        });
    }
    @Test
    void 이름_null인_경우(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->{new CarName(null);})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 비어있을 수 없습니다.");
        });
    }

    @Test
    void 이름_빈문자열_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new CarName("");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 비어있을 수 없습니다.");
        });
    }

    @Test
    void 이름_길이_5자_초과_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new CarName("zzzzzz");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 최대 5글자입니다.");
        });
    }

    @Test
    void 이름_중간에_공백_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new CarName("zz zz");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름에 공백은 입력할 수 없습니다.");
        });
    }

    @Test
    void 이름_앞에_공백_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new CarName(" zzzz");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름에 공백은 입력할 수 없습니다.");
        });
    }

    @Test
    void 이름_뒤에_공백_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new CarName("zzzz ");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름에 공백은 입력할 수 없습니다.");
        });
    }

    @Test
    void 이름_중간에_특수문자_테스트() {
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new CarName("zz*zz");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름에 특수문자는 입력할 수 없습니다.");
        });
    }
}