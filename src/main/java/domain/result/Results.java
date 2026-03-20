package domain.result;

import domain.betting.Bettings;
import domain.participant.Dealer;
import java.util.ArrayList;
import java.util.List;

public record Results(List<Result> results) {

    public Results() {
        this(List.of());
    }

    public Results(List<Result> results) {
        this.results = List.copyOf(results);
    }

    public static Results of(Dealer dealer, Bettings bettings) {
        List<Result> results = bettings.bettings().stream()
                .map(betting -> Result.of(dealer, betting))
                .toList();
        return new Results(results);
    }

    public Results add(Result result) {
        List<Result> results = new ArrayList<>(this.results);
        results.add(result);
        return new Results(results);
    }
}
