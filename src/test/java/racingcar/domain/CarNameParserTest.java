package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarNameParserTest {
    @Test
    void 이름_한개_파싱_테스트(){
        assertSimpleTest(()->{
            String carName = "pobi";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("pobi");
        });
    }

    @Test
    void 이름_2개_파싱_테스트(){
        assertSimpleTest(()->{
            String carName = "pobi,woni";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("pobi", "woni");
        });
    }
    @Test
    void 이름_10개_파싱_테스트(){
        assertSimpleTest(()->{
            String carName = "a,b,c,d,ㄱ,ㄴ,ㄷ,ㄹ,1,100";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("a","b","c","d","ㄱ","ㄴ","ㄷ","ㄹ","1","100");
        });
    }

    @Test
    void 이름에_빈문자열_테스트1(){
        assertSimpleTest(()->{
            String carName = "pobi,";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("pobi","");
        });
    }

    @Test
    void 이름에_빈문자열_테스트2(){
        assertSimpleTest(()->{
            String carName = "pobi,,jun";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("pobi","","jun");
        });
    }

    @Test
    void 한글_이름_입력_테스트1(){
        assertSimpleTest(()->{
            String carName = "가나다";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("가나다");
        });
    }

    @Test
    void 한글_이름_입력_테스트2(){
        assertSimpleTest(()->{
            String carName = "가나다,라마";
            List<String> result = CarNameParser.parse(carName);
            assertThat(result).contains("가나다", "라마");
        });
    }
}