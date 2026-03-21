package domain;

import static common.Constants.BLACKJACK_SCORE;

import domain.card.Card;
import domain.card.Cards;
import java.util.List;

public class Hand {
    private final Cards cards;

    public Hand() {
        cards = new Cards();
    }

    public Hand(Cards cards) {
        this.cards = cards;
    }

    public static Hand from(List<Card> cardList) {
        Cards cards = new Cards(cardList);
        return new Hand(cards);
    }

    public int getSum() {
        return cards.getSum();
    }

    public boolean isBust() {
        return getSum() > BLACKJACK_SCORE;
    }

    public boolean isBlackjack() {
        return getSum() == BLACKJACK_SCORE;
    }

    public Hand draw(Card card) {
        return new Hand(cards.add(card));
    }

    public Cards getCards() {
        return cards;
    }

    public List<Card> getCardsList() {
        return cards.cards();
    }

    public Card getFirstCard() {
        return cards.getFirst();
    }

    public int size() {
        return cards.size();
    }
}
