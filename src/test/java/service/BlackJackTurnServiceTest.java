package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.TestUtil.createDealer;
import static util.TestUtil.createPlayer;

import domain.Deck;
import domain.card.Rank;
import domain.participant.Dealer;
import domain.participant.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BlackJackTurnServiceTest {

    BlackJackTurnService blackJackTurnService;
    Deck deck = Deck.createShuffledDeck();

    @BeforeEach
    void setUp() {
        blackJackTurnService = new BlackJackTurnService();
    }

    @Test
    void 플레이어_Hit_시도가_성공하는_경우() {
        // given
        Player player = createPlayer("봉구스");

        // when
        boolean hit = blackJackTurnService.tryHitByPlayer(player, "y", deck);

        // then
        assertTrue(hit);
        assertEquals(1, player.getHand().getCards().size());
    }

    @Test
    void 딜러_Hit_시도가_성공하는_경우() {
        // given
        Dealer dealer = createDealer();

        // when
        boolean hit = blackJackTurnService.tryHitByDealer(dealer, deck);

        // then
        assertTrue(hit);
        assertEquals(1, dealer.getHand().getCards().size());
    }

    @Test
    void 딜러_Hit_시도가_실패하는_경우() {
        // given
        Dealer dealer = createDealer(Rank.JACK, Rank.QUEEN, Rank.KING);

        // when, then
        assertFalse(blackJackTurnService.tryHitByDealer(dealer, deck));
        assertEquals(3, dealer.getHand().getCards().size());
    }

    @Nested
    class 플레이어가_드로우_할_수_없는_경우 {
        @Test
        void 플레이어의_손패의_합이_21_이상인_경우() {
            // given
            Player player = createPlayer("시오", Rank.JACK, Rank.QUEEN, Rank.KING);

            // when, then
            assertFalse(blackJackTurnService.tryHitByPlayer(player, "y", deck));
            assertEquals(3, player.getHand().getCards().size());
        }

        @Test
        void 플레이어의_입력이_n인_경우() {
            // given
            Player player = createPlayer("시오", Rank.TWO, Rank.FIVE);

            // when, then
            assertFalse(blackJackTurnService.tryHitByPlayer(player, "n", deck));
            assertEquals(2, player.getHand().getCards().size());
        }
    }


    @Test
    void 손패의_합이_21보다_작은_경우() {
        // given
        Player player = createPlayer("시오", Rank.JACK);

        // when, then
        assertTrue(blackJackTurnService.isPlayerUnder21(player));
    }

    @Test
    void 손패의_합이_21보다_큰_경우() {
        // given
        Player player = createPlayer("시오", Rank.JACK, Rank.QUEEN, Rank.KING);

        // when, then
        assertFalse(blackJackTurnService.isPlayerUnder21(player));
    }
}
