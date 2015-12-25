package zoo;

/**
 * Created by Administrator on 2015/12/25.
 */
public class Zoo {
    public static void main(String[] args) {
        Bird bird=null;
        Cat cat=null;
        Dog dog=null;
        Panda panda=null;
        for(int i=0;i<10;i++){
            int num=(int)(Math.random()*4)+1;
            switch (num){
                case 1:
                    bird=new Bird();
                    break;
                case 2:
                    cat=new Cat();
                    break;
                case 3:
                    dog=new Dog();
                    break;
                case 4:
                    panda=new Panda();
                    break;
            }
        }
        if(bird!=null){
            System.out.println(bird);
        }
        if(cat!=null){
            System.out.println(cat);
        }
        if(dog!=null){
            System.out.println(dog);
        }
        if(panda!=null){
            System.out.println(panda);
        }
    }
}
