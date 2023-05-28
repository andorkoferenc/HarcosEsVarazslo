package HarcosEsVarazslo;

import java.util.Random;

public class Dobokocka {

    public static Random random = new Random();
    public static int dob(){
        return (random.nextInt(6)+1);
    }

    public static int eletero(){
        return (random.nextInt(6)+1)+3;
    }

    public static int lepes(){
        return (random.nextInt(3));
    }
}
