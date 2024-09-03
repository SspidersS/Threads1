public class Main {

    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                try {
                    Thread.sleep(1000);
                    long elapsedMillis = System.currentTimeMillis() - startTime;
                    long seconds = elapsedMillis / 1000;
                    System.out.printf("Час, що минув: %d секунд%n", seconds);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        timeThread.start();
        messageThread.start();
    }
}
