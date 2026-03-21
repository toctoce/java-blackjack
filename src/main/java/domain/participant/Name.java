package domain.participant;

import static common.Constants.MAX_NAME_LENGTH;
import static common.Constants.MIN_NAME_LENGTH;
import static exception.ErrorMessage.INVALID_NAME;

public record Name(String value) {

    private static final String NAME_REGEX = "^[a-zA-Z0-9가-힣]{%d,%d}$".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH);

    public Name(String value) {
        String trimmed = value.trim();
        validateName(trimmed);
        this.value = trimmed;
    }

    private void validateName(String value) {
        if (!value.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(INVALID_NAME.getMessage());
        }
    }
}
