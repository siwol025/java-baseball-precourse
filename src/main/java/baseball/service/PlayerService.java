package baseball.service;

import baseball.model.Player;
import baseball.util.GameRule;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class PlayerService {
    private Player player;
    public String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public PlayerService(Player player) {
        this.player = player;
    }

    public void assignPlayerNumbers() {
        int[] playerNums = new int[GameRule.MAX_NUMBER_SIZE];

        System.out.print(INPUT_MESSAGE);
        String inputNums = inputPlayerNums();

        for (int i = 0; i < playerNums.length; i++) {
            playerNums[i] = Integer.parseInt(inputNums.charAt(i) + "");

        }

        player.setPlayerNums(playerNums);
    }

    public String inputPlayerNums() {
        String input = receivePlayerInput();
        InputValidator.validateDigitCount(input);

        return input;
    }

    public int inputRestartCommand() {
        int input = Integer.parseInt(receivePlayerInput());
        InputValidator.validateRestartCommand(input);

        return input;
    }

    public String receivePlayerInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }

}
