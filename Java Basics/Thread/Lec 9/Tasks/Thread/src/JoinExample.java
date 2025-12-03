class Worker extends Thread {
    private final String message;

    Worker(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(message + " - " + i);
        }
    }
}


public class JoinExample {
    public static void main(String[] args) {
        Worker thread1 = new Worker("Thread 1");
        Worker thread2 = new Worker("Thread 2");


        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
