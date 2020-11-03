import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Thread1 implements Runnable {

    Random rnd = new Random();
    private int count[] = new int[6];
    private Object[] vigilante = new Object[6];
    int total;

    @Override
    public synchronized void run() {
        int result;
        for (int i = 0; i < 10000; i++) {

            result = rnd.nextInt(6) + 1;

            sum(result);

            total++;

        }

    }
    
    public void sum(int try_num) {
        synchronized (vigilante) {
            count[try_num - 1]++;
        }
    }

    public void print() {

        for(int i = 0; i <= 5; i++) {
            vigilante[i] = new Object();
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("Numero %d : %d veces \n", i + 1, count[i]);

        }

        System.out.printf("Total de veces: %d + %d + %d + %d + %d + %d = %d",count[0],
                count[1],count[2],count[3],count[4],count[5],total);

    }

}
