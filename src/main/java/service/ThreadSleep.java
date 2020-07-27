package service;

public class ThreadSleep {

    public static void sleepThread(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
