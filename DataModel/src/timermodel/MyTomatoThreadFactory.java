package timermodel;

import java.util.concurrent.ThreadFactory;

/**
 * Creates daemon threads that can be used.
 */
public class MyTomatoThreadFactory implements ThreadFactory {

  @Override
  public Thread newThread(Runnable r) {
    Thread thread = new Thread();
    thread.setDaemon(true);
    return thread;
  }
}
