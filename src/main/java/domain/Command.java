package domain;

public enum Command {
    HIT("y"),
    STAND("n");

    private static final String INVALID_COMMAND_MESSAGE = "y 혹은 n만 입력 가능합니다.";

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command from(String value) {
        if (HIT.value.equals(value)) {
            return HIT;
        }
        if (STAND.value.equals(value)) {
            return STAND;
        }
        throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
    }

    public boolean isHit() {
        return this == HIT;
    }
}
