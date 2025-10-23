package racingcar.view;

public class OutputView {
    public void printCarNamesPrompt(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기주능로 구분)");
    }

    public void printCountPrompt(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void printResultMessage(){
        System.out.println("실행 결과");
    }
    public void printNameAndPosition(String carName, int position){
        System.out.println(carName +" : "+ "-".repeat(position));
    }
    public void printWinnersMessage(){
        System.out.print("최종 우승자 : ");
    }
    public void printWinners(String... winners){
        String winnersJoined = String.join(", ", winners);
        printWinnersMessage();
        System.out.println(winnersJoined);
    }
}
