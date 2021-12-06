package main;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Countdown {

    public static void startCountdown() {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int countdownStarter = 4;
            public void run() {
                System.out.println("Time left in seconds:");
                System.out.println(countdownStarter * 30);
                countdownStarter--;
                if (countdownStarter < 0) {
                    System.out.println("Timer Over!");
                    MasterMind.isTimeOver = true;
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 30, SECONDS);
    }
}