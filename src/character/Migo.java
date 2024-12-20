package character;

import help.*;
import place.Place;

public class Migo extends Character {
    public Migo(String name, State state, Place location, int money) {
        super(name, state, location, money);
    }

    public void giveApple(Character target) throws PossibleException {
        if (getState() == State.Sad || getState() == State.Irritated) {
            throw new PossibleException(getName() + " не может раздавать яблоки из-за плохого настроения!");
        }


        for (int i = 0; i < appleInventory.length; i++) {
            if (appleInventory[i] != null) {
                target.addApple();
                System.out.println(getName() + " дал яблоко " + target.getName());
                appleInventory[i] = null;
                return;
            }
        }


        throw new PossibleException(getName() + " не имеет яблок для передачи!");
    }

    public void giveAppleAudience(Character[] audience) throws PossibleException {
        for (Character target : audience) {
            if (target != null && !this.equals(target)){
                giveApple(target);
            }
        }
    }

    @Override
    public void move(Place newLocation) {
        int distance = getLocation().distanceTo(newLocation);
        this.location = newLocation;
        System.out.println(getName() + " пришёл в " + newLocation.getName() + " на расстояние " + distance + " единиц.");
    }
}
