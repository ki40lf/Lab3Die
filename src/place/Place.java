package place;

public abstract class Place {
    private final int x;
    private final int y;
    private final int z;
    private final String name;

    public Place(String name, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public int distanceTo(Place other) {
        return (int)Math.sqrt(Math.pow(this.getX() - other.getX(), 2) +
                Math.pow(this.getY() - other.getY(), 2) +
                Math.pow(this.getZ() - other.getZ(), 2));
    }
}
