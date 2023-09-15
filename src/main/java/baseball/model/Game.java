package baseball.model;

public class Game {
    private int[] computerNums;
    private int ball;
    private int strike;

    public int[] getComputerNums() {
        return computerNums;
    }

    public void setComputerNums(int[] computerNums) {
        this.computerNums = computerNums;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
