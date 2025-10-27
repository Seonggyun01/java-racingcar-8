package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void Car_생성_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("zzzzz");
            assertThat(car.getCarName()).isEqualTo("zzzzz");
            assertThat(car.getPosition()).isEqualTo(0);
        });
    }

    @Test
    void Car_move_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("z");
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        });
    }
}