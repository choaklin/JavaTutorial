package javase.generic.bean;

/**
 * something
 *
 * @author choaklin
 * @since 0.1.0
 */
public class Fruit<T> {

    private T info;

    public Fruit() {
    }
    public Fruit(T info) {
        this.info = info;
    }


    public static void main(String[] args) {
        Fruit<String> fruit = new Fruit<String>("sasasasa");
        System.out.println(fruit.info);
    }

}
