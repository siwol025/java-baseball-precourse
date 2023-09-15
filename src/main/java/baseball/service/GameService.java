package baseball.service;

import baseball.model.Game;
import baseball.util.GameRule;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private final Game game;

    public GameService() {
        this.game = new Game();
    }

    public void setGame() {
        game.setComputerNums(generateRandomNums());
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

    public boolean checkContains(int[] computerNums, int randomNum) {
        for (int i = 0; i < computerNums.length; i++) {
            if (computerNums[i] == 0) {
                break;
            }

            if (computerNums[i] == randomNum) {
                return true;
            }
        }

        return false;
    }
}
