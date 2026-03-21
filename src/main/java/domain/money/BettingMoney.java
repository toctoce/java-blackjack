package domain.money;

public record BettingMoney(Money money) {
    private static final String INVALID_BETTING_AMOUNT_MESSAGE = "배팅 금액은 0보다 커야합니다.";

    public static BettingMoney from(long amount) {
        validate(amount);
        return new BettingMoney(new Money(amount));
    }

    public static BettingMoney from(Money money) {
        validate(money.amount());
        return new BettingMoney(money);
    }

    private static void validate(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_BETTING_AMOUNT_MESSAGE);
        }
    }
}
