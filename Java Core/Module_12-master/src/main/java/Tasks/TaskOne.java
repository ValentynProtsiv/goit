package Tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TaskOne {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        long currentTime = System.currentTimeMillis();
        ScheduledFuture<?> printGoneSeconds = executorService.scheduleAtFixedRate(() -> {

            System.out.println((System.currentTimeMillis() - currentTime) / 1000);
        }, 1, 1, SECONDS);

        ScheduledFuture<?> printGoneEveryFiveSeconds = executorService.scheduleAtFixedRate(() ->{
            System.out.println("Минуло 5 секунд");
        },5, 5, SECONDS);

        executorService.schedule(new Runnable() {
            public void run() {
                printGoneSeconds.cancel(true);
                printGoneEveryFiveSeconds.cancel(true);
            }
        }, 60 * 60, SECONDS);
    }
}