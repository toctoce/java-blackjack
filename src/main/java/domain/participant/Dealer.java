package domain.participant;

import domain.Hand;
import java.util.List;

public class Dealer extends Participant {

    public Hand getOpenHand() {
        return Hand.from(List.of(hand.getFirstCard()));
    }
}
