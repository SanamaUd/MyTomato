package timermodel;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Model for the timer.
 */
public class TimerModel {

  private final ScheduledExecutorService scheduler;
  private Duration duration = Duration.ofMinutes(25);
  private ScheduledFuture<?> future;

  /**
   * Constructor.
   * Creates the scheduler.
   */
  public TimerModel() {
    scheduler = Executors.newSingleThreadScheduledExecutor(new MyTomatoThreadFactory());
  }

  /**
   * Method to start the timer.
   */
  public void start() {
    Runnable secondElapsed = this::fireSecondElapsedEvent;
    future = scheduler.scheduleAtFixedRate(secondElapsed, 1, 1, TimeUnit.SECONDS);
  }

  private void fireSecondElapsedEvent() {
    //TODO fill this in
  }
}
