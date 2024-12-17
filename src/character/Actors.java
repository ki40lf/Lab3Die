package character;

import help.*;

public class Actors implements StateUtilit {
    private State state;

    public Actors() {
        this.state = State.Relax;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State worsenState(State state) {
        State newState = StateUtilit.super.worsenState(state);

        if (newState == State.Sad && state == State.Sad) {
            System.out.println("Актёры и так в наихудшем состоянии");
        } else {
            System.out.println("Актёры теперь в состоянии: " + newState);
        }

        return newState;
    }


    public void worsenActorsState() {
        state = worsenState(state);
    }
}
