package domain.participant;

import domain.Hand;
import domain.card.Card;

public class Participant {
    private static final int INITIAL_HAND_SIZE = 2;

    protected Hand hand;

    public Participant() {
        hand = new Hand();
    }

    public Participant(Hand hand) {
        this.hand = hand;
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public boolean isBlackjack() {
        return hand.isBlackjack();
    }

    public boolean isBlackjackAtFirst() {
        return isBlackjack() && hand.size() == INITIAL_HAND_SIZE;
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return hand.getSum();
    }

    // todo : Participant도 불변으로 변경
    public void draw(Card card) {
        hand = hand.draw(card);
    }

}
