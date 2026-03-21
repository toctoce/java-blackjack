package service;

import domain.Deck;
import domain.participant.Dealer;
import domain.participant.Player;
import domain.participant.Players;
import java.util.List;

public class BlackJackInitService {

    public Deck createDeck() {
        return Deck.createShuffledDeck();
    }

    // todo 딜러도 카드리스트 주입!
    public Dealer createDealer(Deck deck) {
        Dealer dealer = new Dealer();
        dealer.draw(deck.drawCard());
        dealer.draw(deck.drawCard());
        return dealer;
    }

    public Players createPlayers(List<String> names, Deck deck) {
        List<Player> players = names.stream()
                .map(name -> {
                    Player player = Player.from(name);
                    player.draw(deck.drawCard());
                    player.draw(deck.drawCard());
                    return player;
                })
                .toList();
        return new Players(players);
    }
}
