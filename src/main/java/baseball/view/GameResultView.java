package baseball.view;

import baseball.model.Game;
import baseball.model.Player;
import baseball.util.GameRule;

public class GameResultView {
    private Game game;

    public final static String BALL_WORD = "볼";
    public final static String STRIKE_WORD = "스트라이크";
    public final static String NOT_MATCH_WORD = "낫싱";
    public final static String SUCCESS_MESSAGE = GameRule.MAX_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public GameResultView(Game game) {
        this.game = game;
    }

    public void showResult() {
        int ballCount = game.getBall();
        int strikeCount = game.getStrike();
        String resultMessage = strikeCount + STRIKE_WORD;

        if (ballCount != 0) {
            resultMessage = ballCount + BALL_WORD + " " + resultMessage;
            System.out.println(resultMessage);

            return;
        }

        if (strikeCount == 0 && ballCount ==0) {
            System.out.println(NOT_MATCH_WORD);

            return;
        }

        System.out.println(resultMessage);

        if (strikeCount == 3) {
            System.out.println(SUCCESS_MESSAGE);
        }
    }
}
