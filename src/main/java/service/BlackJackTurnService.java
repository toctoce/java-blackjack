package service;

import static common.Constants.BLACKJACK_SCORE;
import static common.Constants.DEALER_HIT_LIMIT;
import static common.Constants.HIT_COMMAND;

import domain.Deck;
import domain.card.Card;
import domain.participant.Dealer;
import domain.participant.Player;

public class BlackJackTurnService {
    public boolean tryHitByPlayer(Player player, String input, Deck deck) {
        if (canPlayerHit(player, input)) {
            Card card = deck.drawCard();
            player.draw(card);
            return true;
        }
        return false;
    }

    public boolean tryHitByDealer(Dealer dealer, Deck deck) {
        if (canDealerHit(dealer)) {
            Card card = deck.drawCard();
            dealer.draw(card);
            return true;
        }
        return false;
    }

    public boolean isPlayerUnder21(Player player) {
        return player.getScore() < BLACKJACK_SCORE;
    }

    private boolean canPlayerHit(Player player, String input) {
        return isPlayerUnder21(player) && input.equals(HIT_COMMAND);
    }

    private boolean canDealerHit(Dealer dealer) {
        return dealer.getScore() < DEALER_HIT_LIMIT;
    }
}
