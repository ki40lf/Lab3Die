package place;
import help.*;
import character.Crabs;

public class Restaurant extends Place {
    public Restaurant (String name, int x, int y, int z) {
        super(name, x, y, z);
    }
    private final int priceDefaultDish = 10;
    private final int priceFavouriteDish = 20;

    public void tellPrice(Crabs crabs) {
        System.out.println("Губка Боб: Цена обычного блюда: " + priceDefaultDish + " голды, цена: " + crabs.getFavouriteDish() + ": " + priceFavouriteDish);
    }

    public int getDishPrice(State state) {
        return state == State.Funny || state == State.Relax ? priceFavouriteDish : priceDefaultDish;
    }
}
