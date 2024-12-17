package help;

public interface StateUtilit {
    default State worsenState(State state) {
        return switch (state) {
            case Funny -> State.Relax;
            case Relax -> State.Calm;
            case Calm -> State.Irritated;
            case Irritated -> State.Sad;
            case Sad -> State.Sad;
        };
    }
}
