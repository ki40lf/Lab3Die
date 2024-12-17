import character.*;
import character.Character;
import help.*;
import place.*;


public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Отель Гранд", 2,3,1);
        Crabs crabs = new Crabs("Мистер Крабс", State.Funny, hotel, 100, "Крабсургер");
        Julio julio = new Julio("Господин Жулио", State.Irritated, hotel, 80, 0.5);
        Migo migo = new Migo("Миго", State.Calm, hotel, 90);


        Restaurant restaurant = new Restaurant("Клод Моне",3,5,7);
        crabs.move(restaurant);
        System.out.println(crabs.getName() + " в ресторане");
        restaurant.tellPrice(crabs);
        try {
            crabs.eat(restaurant);
        } catch (PossibleException e) {
            System.out.println("Ошибка в ресторане: " + e.getMessage());
        }


        crabs.move(hotel);
        hotel.sayHello(crabs.getName());
        hotel.escortRoom(crabs.getName());
        crabs.sleep();


        System.out.println("\n--- Друзья приходят в театр и встречаются ---");
        Actors actors = new Actors();
        Character[] audience = {crabs, migo, julio};
        Theater theater = new Theater("Театр", 2,2,8, actors, audience);
        crabs.move(theater);
        julio.move(theater);
        migo.move(theater);

        for (Character character : audience) {
            System.out.println(character);
        }

        try {
            julio.purchaseApples(3);
            migo.purchaseApples(3);
            crabs.purchaseApples(3);
        } catch (PossibleException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Начало театрального шоу ---");
        theater.startShow();

        System.out.println("\n--- Представление завершено ---");
    }
}
