package domain.participant;

public class Player extends Participant {

    private final Name name;

    public Player(Name name) {
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(new Name(name));
    }

    public Name getName() {
        return name;
    }

    public String getNameString() {
        return name.value();
    }
}
