package placeholderGameName;

import java.util.Random;

public class main {
    public static void main(String args[]) {
        System.out.println("Hello!");
        Random random = new Random();
        while(true){
            System.out.println(random.nextInt(101));
        }

    }
}
