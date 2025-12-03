class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Running in: " + Thread.currentThread().getName());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "Worker-Thread");
        thread.start();
    }
}
