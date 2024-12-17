package character;

import help.*;
import place.Place;

public abstract class Character implements Payable {
    private String name;
    private State state;
    private Place location;
    private int money;
    public final Apple[] appleInventory;// Массив для хранения яблок

    public Character(String name, State state, Place location, int money) {
        setName(name);
        setLocation(location);
        setBalance(money);
        setState(state);
        this.appleInventory = new Apple[8];
    }

    public Apple getAppleType() {
        return new Apple("гнилое", 5); // Возвращает фиксированный тип яблок
    }

    public int getBalance() {
        return money;
    }

    public void setBalance(int money) throws InvalidCharacterDataException {
        if (money < 0) {
            throw new InvalidCharacterDataException("Деньги не должны быть отрицательны");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidCharacterDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidCharacterDataException("Имя персонажа не может быть пустым или null.");
        }
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) throws InvalidCharacterDataException {
        if (state == null) {
            throw new InvalidCharacterDataException("Состояние персонажа не может быть null.");
        }
        this.state = state;
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        if (location == null) {
            throw new InvalidCharacterDataException("Локация персонажа не может быть null.");
        }
        this.location = location;
    }

    public void throwApple() throws PossibleException {
        for (int i = 0; i < appleInventory.length; i++) {
            if (appleInventory[i] != null) {
                System.out.println(name + " бросил " + appleInventory[i].type() + " яблоко!");
                appleInventory[i] = null;
                return;
            }
        }
        throw new PossibleException(name + " не имеет яблок для броска!");
    }

    public void purchaseApples(int quantity) throws PossibleException {
        int totalPrice = quantity * getAppleType().price();
        spendMoney(totalPrice);

        for (int i = 0; i < quantity; i++) {
            addApple();
        }

        System.out.println(getName() + " купил " + quantity + " яблок типа: " + getAppleType().type() + " за " + totalPrice + " голды.");
    }

    public void addApple() throws PossibleException {
        for (int i = 0; i < appleInventory.length; i++) {
            if (appleInventory[i] == null) {
                appleInventory[i] = getAppleType();
                return;
            }
        }
        throw new PossibleException(getName() + " не хватает места в инвентаре для добавления яблока!");
    }

    public abstract void move(Place newLocation);

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", state=" + state +
                ", location='" + location + '\'' +
                ", money=" + money +
                '}';
    }

}
