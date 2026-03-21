package service;

import static domain.Hand.BLACKJACK_SCORE;

import domain.Command;
import domain.Deck;
import domain.card.Card;
import domain.participant.Dealer;
import domain.participant.Player;

public class BlackJackTurnService {
    private static final int DEALER_HIT_LIMIT = 17;

    public boolean tryHitByPlayer(Player player, Command command, Deck deck) {
        if (canPlayerHit(player, command)) {
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

    private boolean canPlayerHit(Player player, Command command) {
        return isPlayerUnder21(player) && command.isHit();
    }

    private boolean canDealerHit(Dealer dealer) {
        return dealer.getScore() < DEALER_HIT_LIMIT;
    }
}
