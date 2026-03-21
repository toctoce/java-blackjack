package domain.participant;

import java.util.List;

public record Players(List<Player> players) {

    public Players(List<Player> players) {
        this.players = List.copyOf(players);
    }

    public int size() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }
}
