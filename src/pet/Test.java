package pet;

/**
 * Created by Administrator on 2015/12/25.
 */
public class Test {
    public static void main(String [] args) {
        Pet pet=new Pet("");
        pet.play();
        Dog dog=new Dog();
        dog.play();
        Cat cat=new Cat("cat");
        cat.play();
    }
}
