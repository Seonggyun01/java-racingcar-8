package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 우승자_한명_테스트(){
        assertSimpleTest(()->{
            Cars cars = new Cars(Arrays.asList(
                    new Car("aaa"),
                    new Car("bbb"),
                    new Car("ccc")));

            cars.getCarList().get(0).move();

            Cars winner = cars.findWinners();

            assertThat(winner.getCarList().size()).isEqualTo(1);
            assertThat(cars.getCarList())
                    .extracting("carName")
                    .contains("aaa");

        });
    }

    @Test
    void 우승자_2명_테스트(){
        assertSimpleTest(()->{
            Cars cars = new Cars(Arrays.asList(
                    new Car("aaa"),
                    new Car("bbb"),
                    new Car("ccc")));

            cars.getCarList().get(0).move();
            cars.getCarList().get(1).move();

            Cars winners = cars.findWinners();

            assertThat(winners.getCarList().size()).isEqualTo(2);
            assertThat(cars.getCarList())
                    .extracting("carName")
                    .contains("aaa","bbb");
        });
    }

    @Test
    void 우승자_3명_테스트(){
        assertSimpleTest(()->{
            Cars cars = new Cars(Arrays.asList(
                    new Car("aaa"),
                    new Car("bbb"),
                    new Car("ccc")));

            cars.getCarList().get(0).move();
            cars.getCarList().get(1).move();
            cars.getCarList().get(2).move();

            Cars winners = cars.findWinners();

            assertThat(winners.getCarList().size()).isEqualTo(3);
            assertThat(cars.getCarList())
                    .extracting("carName")
                    .contains("aaa","bbb","ccc");
        });
    }
}