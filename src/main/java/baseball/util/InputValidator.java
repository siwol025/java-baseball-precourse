package baseball.util;

public class InputValidator {
    public static void validateDigitCount(String input) throws IllegalArgumentException {
        if (input == null || input.length() != GameRule.MAX_NUMBER_SIZE || !input.matches("\\d+")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
