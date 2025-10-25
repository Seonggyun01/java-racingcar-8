package racingcar.controller;

import java.util.List;
import racingcar.domain.CarNameParser;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String inputCarName;
        String inputCount;

        //자동차 이름 입력받기
        inputCarName = getInputCarName();
        //사용자 입력 (,)로 분리하기
        List<String> carNames = CarNameParser.parse(inputCarName);
        //Cars 객체 생성
        Cars cars = Cars.fromNames(carNames);

        //횟수 입력받기
        inputCount = getInputCount();
        //Count로 횟수 관리
        Count count = new Count(inputCount);

        //경기 시작 및 중간 결과 출력
        racingGamePlay(cars, count);
        //우승자 출력
        winnerPrint(cars);
    }

    private void winnerPrint(Cars cars) {
        Cars winners = cars.findWinners();
        outputView.printWinners(winners.getWinnersName());
    }

    private void racingGamePlay(Cars cars, Count count) {
        outputView.printResultMessage();
        Game game = new Game(cars);
        for(int i = 0; i< count.getCount(); i++){
            game.play();
            printRoundResult(cars);
        }
    }

    private String getInputCount() {
        String inputCount;
        outputView.printCountPrompt();
        inputCount = inputView.readCount();
        if(inputCount==null||inputCount.isEmpty()){
            throw new IllegalArgumentException("횟수를 입력해주세요.");
        }
        return inputCount;
    }

    private String getInputCarName() {
        String inputCarName;
        outputView.printCarNamesPrompt();
        inputCarName = inputView.readCarNames();
        if(inputCarName==null || inputCarName.isEmpty()){
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        return inputCarName;
    }

    private void printRoundResult(Cars cars) {
        cars.getCarList().
                forEach(car->outputView.printNameAndPosition(car.getCarName(), car.getPosition()));
        outputView.printLine();
    }
}
