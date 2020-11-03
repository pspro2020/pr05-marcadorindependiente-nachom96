public class MainThread {

    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        Thread1 dice = new Thread1();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(dice);
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].start();
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                return;
            }
        }
        dice.print();

    }

}
