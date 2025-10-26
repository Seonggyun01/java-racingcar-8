package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void 랜덤값_4일_경우_테스트(){
        Cars cars = new Cars(List.of(
                new Car("aaa"),
                new Car("bbb"),
                new Car("ccc")));
        Game game = new Game(cars);
        assertRandomNumberInRangeTest(()->{
            game.play();
            assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(1);
            assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(1);
            assertThat(cars.getCarList().get(2).getPosition()).isEqualTo(1);
        },4,4,4);
    }

    @Test
    void 랜덤값_4에서_9사이_테스트(){
        Cars cars = new Cars(List.of(
                new Car("aaa"),
                new Car("bbb"),
                new Car("ccc")));
        Game game = new Game(cars);
        assertRandomNumberInRangeTest(()->{
            game.play();
            assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(1);
            assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(1);
            assertThat(cars.getCarList().get(2).getPosition()).isEqualTo(1);
        },4,7, 9);
    }

    @Test
    void 랜덤값_3일_경우_테스트(){
        Cars cars = new Cars(List.of(
                new Car("aaa"),
                new Car("bbb"),
                new Car("ccc")));
        Game game = new Game(cars);
        assertRandomNumberInRangeTest(()->{
            game.play();
            assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(0);
            assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(0);
            assertThat(cars.getCarList().get(2).getPosition()).isEqualTo(0);
        },3,3,3);
    }

    @Test
    void 랜덤값_0에서_3사이_테스트(){
        Cars cars = new Cars(List.of(
                new Car("aaa"),
                new Car("bbb"),
                new Car("ccc")));
        Game game = new Game(cars);
        assertRandomNumberInRangeTest(()->{
            game.play();
            assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(0);
            assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(0);
            assertThat(cars.getCarList().get(2).getPosition()).isEqualTo(0);
        },0,1,3);
    }
}