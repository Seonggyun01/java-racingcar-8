package racingcar.view;

public class OutputView {
    private final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기주능로 구분)";
    private final String TRY_COUNT_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNERS_MESSAGE_PREFIX = "최종 우승자 : ";
    private final String POSITION_SYMBOL = "-";

    public void printCarNamesPrompt(){
        System.out.println(CAR_NAMES_PROMPT);
    }

    public void printCountPrompt(){
        System.out.println(TRY_COUNT_PROMPT_MESSAGE);
    }

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public void printNameAndPosition(String carName, int position){
        System.out.println(carName +" : "+ POSITION_SYMBOL.repeat(position));
    }

    public void printWinnersMessage(){
        System.out.print(WINNERS_MESSAGE_PREFIX);
    }

    public void printWinners(String... winners){
        String winnersJoined = String.join(", ", winners);
        printWinnersMessage();
        System.out.println(winnersJoined);
    }

    public void printLine(){
        System.out.println();
    }
}
