package baseball.service;

import baseball.model.Game;
import baseball.model.Player;
import baseball.util.GameRule;
import baseball.view.GameResultView;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private Game game;
    private Player player;
    private PlayerService playerService;
    private GameResultView gameResultView;

    public GameService() {
        this.game = new Game();
        this.player = new Player();
        this.playerService = new PlayerService(player);
        this.gameResultView = new GameResultView();
    }

    public void setGame() {
        game.setComputerNums(generateRandomNums());
        initializeScores();
    }

    public void runGame() {
        while (true) {
            playerService.assignPlayerNumbers();
            checkGuess(game.getComputerNums(), player.getPlayerNums());
            gameResultView.showResult(game);

            if (game.getStrike() == GameRule.MAX_NUMBER_SIZE) {
                break;
            }

            initializeScores();
        }
    }

    public boolean endGame() {
        gameResultView.askForRestartOrExit();
        int command = playerService.inputRestartCommand();

        if (command == GameRule.RESTART_COMMAND) {
            return false;
        }

        return true;
    }

    public void checkGuess(int[] computerNums, int[] playerNums) {
        for (int i = 0; i < GameRule.MAX_NUMBER_SIZE; i++) {
            if (computerNums[i] == playerNums[i]) {
                int strike = game.getStrike() + 1;
                game.setStrike(strike);

                continue;
            }

            if (checkContains(computerNums, playerNums[i])) {
                int ball = game.getBall() + 1;
                game.setBall(ball);
            }
        }
    }

    public void initializeScores() {
        game.setBall(0);
        game.setStrike(0);
    }

    public int[] generateRandomNums() {
        int[] computerNums = new int[GameRule.MAX_NUMBER_SIZE];

        for (int i = 0; i < computerNums.length; i++) {
            computerNums[i] = insertNumber(computerNums);
        }

        return computerNums;
    }

    public int insertNumber(int[] computerNums) {
        while (true) {
            int randomNum = Randoms.pickNumberInRange(GameRule.MIN_RANGE_NUM, GameRule.MAX_RANGE_NUM);

            boolean containsRandomNum = checkContains(computerNums, randomNum);

            // 랜덤으로 생성된 숫자가 computerNums 배열에 포함되어 있지 않으면 return
            if (containsRandomNum == false) {
                return randomNum;
            }
        }
    }

    public boolean checkContains(int[] computerNums, int num) {
        for (int i = 0; i < computerNums.length; i++) {
            if (computerNums[i] == 0) {
                break;
            }

            if (computerNums[i] == num) {
                return true;
            }
        }

        return false;
    }
}
