package timermodel;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import utilities.TomatoObservable;
import utilities.TomatoObservableManager;
import utilities.TomatoObservation;

/**
 * Model for the timer.
 */
public class TimerModel implements TomatoObservable {

  public static final TomatoObservation<Duration> DURATION_MODIFIED = new TomatoObservation<>();
  private static final Duration PERIOD_TO_COUNT = Duration.ofSeconds(1);
  protected static final Duration INITIAL_DURATION = Duration.ofMinutes(25);
  private final ScheduledExecutorService scheduler;
  private Duration duration;
  private ScheduledFuture<?> future;
  private TomatoObservableManager observableManager;

  /**
   * Constructor.
   * Creates the scheduler.
   */
  public TimerModel() {
//	scheduler = Executors.newSingleThreadScheduledExecutor(new MyTomatoThreadFactory());
    scheduler = Executors.newScheduledThreadPool(1);
    observableManager = new TomatoObservableManager();
    duration = INITIAL_DURATION;
  }

  /**
   * Method to start the timer.
   */
  public void start() {
    Runnable secondElapsed = this::fireSecondElapsedEvent;
    future = scheduler.scheduleAtFixedRate(secondElapsed, 1, 1, TimeUnit.SECONDS);
    scheduler.schedule(() -> future.cancel(true), 25, TimeUnit.MINUTES);
  }

  void fireSecondElapsedEvent() {
    Duration remainingTime = duration.minus(PERIOD_TO_COUNT);
    setDurationLeft(remainingTime);
  }
  
  /**
   * Sets the given {@link Duration} to be held by the model. 
   * @param toSet the {@link Duration} to set
   */
  private void setDurationLeft(Duration toSet) {
	  this.duration = toSet;
	  observableManager.notifyObservers(DURATION_MODIFIED, duration);
  }

  @Override
  public TomatoObservableManager getObservableManager() {
    return observableManager;
  }

  public Duration getDuration() {
    return duration;
  }
  
  
}
