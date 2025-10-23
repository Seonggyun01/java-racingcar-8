package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountTest {
    @Test
    void Count_성공_테스트(){
        assertSimpleTest(()->{
            Count count = new Count("1");
            assertThat(count.getCount()).isEqualTo(1);
        });
    }

    @Test
    void 소수_입력_테스트(){
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new Count("1.111");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("횟수는 정수를 입력해야합니다.");
        });
    }

    @Test
    void 음수_입력_테스트(){
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new Count("-1");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("횟수는 양수를 입력해야합니다.");
        });
    }

    @Test
    void 큰수_테스트(){
        assertSimpleTest(() ->{
            assertThatThrownBy(()->{new Count("2147483648");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("횟수는 양수를 입력해야합니다.");
        });
    }

    @Test
    void null_입력_테스트(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->{new Count(null);})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("횟수를 입력해주세요.");
        });
    }

    @Test
    void 빈문자열_입력_테스트(){
        assertSimpleTest(()->{
            assertThatThrownBy(()->{new Count("");})
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("횟수를 입력해주세요.");
        });
    }
}