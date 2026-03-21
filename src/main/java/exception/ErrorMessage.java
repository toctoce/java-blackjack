package exception;

import static common.Constants.MAX_NAME_LENGTH;
import static common.Constants.MIN_NAME_LENGTH;

public enum ErrorMessage {
    EMPTY_NAME("닉네임에 빈 문자열을 입력할 수 없습니다."),
    INVALID_NAME("닉네임은 %d~%d글자여야 합니다.".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH)),
    INVALID_YN("y 혹은 n만 입력 가능합니다."),
    EMPTY_DECK("덱에 카드가 없습니다."),
    INVALID_BETTING_AMOUNT("배팅 금액은 0보다 커야합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
