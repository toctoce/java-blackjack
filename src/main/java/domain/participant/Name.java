package domain.participant;

import static common.Constants.MAX_NAME_LENGTH;
import static common.Constants.MIN_NAME_LENGTH;
import static exception.ErrorMessage.INVALID_NAME;

public record Name(String value) {
    public Name(String value) {
        String trimmed = value.trim();
        validateName(trimmed);
        this.value = trimmed;
    }

    private void validateName(String value) {
        if (isInvalidLength(value) || hasInvalidCharacter(value)) {
            throw new IllegalArgumentException(INVALID_NAME.getMessage());
        }
    }

    private boolean isInvalidLength(String value) {
        return value.length() < MIN_NAME_LENGTH || value.length() > MAX_NAME_LENGTH;
    }

    private boolean hasInvalidCharacter(String value) {
        return value.chars()
                .filter(this::isInvalidCharacter)
                .findAny()
                .isPresent();
    }

    private boolean isInvalidCharacter(int character) {
        return !isEnglish(character) && !isNumber(character) && !isKorean(character);
    }

    private boolean isEnglish(int character) {
        return character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z';
    }

    private boolean isNumber(int character) {
        return character >= '0' && character <= '9';
    }

    private boolean isKorean(int character) {
        return character >= '가' && character <= '힣';
    }
}
