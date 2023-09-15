package baseball.controller;

import baseball.model.Game;
import baseball.service.GameService;

public class GameController {
    private final GameService gameService = new GameService();

    public void startGame() {
        while (true) {
            processGame();
        }
    }

    public void processGame() {
        gameService.setGame();
        while (true) {

        }
    }


}
