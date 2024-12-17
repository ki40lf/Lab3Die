package character;

import help.*;
import place.Place;

public class Julio extends Character implements StateUtilit {
    private double debuffChance; // Шанс наложить дебафф

    public Julio(String name, State state, Place location, int money, double debuffChance) {
        super(name, state, location, money);
        this.debuffChance = debuffChance;
    }

    public double getDebuffChance() {
        return debuffChance;
    }

    public void debuff(Character target) {
        if (this.getState() == State.Calm || this.getState() == State.Irritated) {
            if (Math.random() < getDebuffChance()) {
                target.setState(worsenState(target.getState()));
                System.out.println(this.getName() + " наложил дебафф на " + target.getName() + "! Новое состояние: " + target.getState());
            } else {
                System.out.println(this.getName() + " попытался наложить дебафф на " + target.getName() + ", но безуспешно.");
            }
        }
    }

    public void debuffAudience(Character[] audience) {

        for (Character target : audience) {
            if (target != null && !this.equals(target) && target.getState() != State.Sad) {
                debuff(target);
            }
        }
    }

    @Override
    public void move(Place newLocation) {
        int distance = getLocation().distanceTo(newLocation);
        setLocation(newLocation);
        System.out.println(getName() + " переместился в " + newLocation.getName() + " на расстояние " + distance + " единиц.");
    }
}
