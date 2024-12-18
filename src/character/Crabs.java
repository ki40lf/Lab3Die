package character;

import place.*;
import help.*;

public class Crabs extends Character {
    private String favouriteDish;

    public Crabs(String name, State state, Place location, int money, String favouriteDish) {
        super(name, state, location, money);
        this.favouriteDish = favouriteDish;
    }


    public void eat(Restaurant restaurant) throws PossibleException {
        System.out.println("Крабс находится в " + getState() + " настроении");
        int dishPrice = restaurant.getDishPrice(getState());
        spendMoney(dishPrice);
        if (getState() == State.Relax || getState() == State.Funny) {
            System.out.println(getName() + " выбирает любимое блюдо и наслаждается: " + getFavouriteDish() + ".");
        } else {
            System.out.println(getName() + " съел обычное блюдо, потому что находится не в настроении.");
        }
    }

    public String getFavouriteDish() {
        return favouriteDish;
    }

    public void sleep() {
        setState(State.Relax);
        System.out.println(getName() + " немного поспал и теперь чувствует себя расслабленным.");
    }

    @Override
    public void move(Place newLocation) {
        int distance = getLocation().distanceTo(newLocation);
        this.location = newLocation;
        System.out.println(getName() + " переместился (под звуки Мр.Крабса из Губки Боба) в " + newLocation.getName() + " на расстояние " + distance + " единиц.");
    }
}
