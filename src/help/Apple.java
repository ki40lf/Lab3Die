package help;

public record Apple(String type, int price) {
    public Apple {
        if (price < 0) {
            throw new IllegalArgumentException("Цена яблока не может быть отрицательной!");
        }
    }
}
