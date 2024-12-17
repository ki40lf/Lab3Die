package place;

public class Hotel extends Place {
    public Hotel (String name, int x, int y, int z) {
        super(name, x, y, z);
    }
        public void sayHello (String name){
            System.out.println("Швейцар приветствует " + name + " в гостинице!");
        }

        public void escortRoom (String name){
            System.out.println("Швейцар провел " + name + " в номер.");
        }
}