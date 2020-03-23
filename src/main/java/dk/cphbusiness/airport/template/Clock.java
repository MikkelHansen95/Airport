package dk.cphbusiness.airport.template;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clock implements Runnable {
  private final long sleepingTime = 1;
  private boolean running = true;
  private final PassengerProducer producer;
  private final PassengerConsumer consumer;
  private final PassengerConsumer consumer1;
  private long millis;
  
  public Clock(PassengerProducer producer, PassengerConsumer consumer, PassengerConsumer consumer1, Time startTime) {
    this.producer = producer;
    this.consumer = consumer;
    this.consumer1 = consumer1;
    this.millis = startTime.getMillis();
    }
  
  public void stop() {
    running = false;
    }
  
  public Time getTime() {
    return new Time(millis);
    }
  
  @Override
  public void run() {
    try {
      while (running) {
        Thread.sleep(sleepingTime);
        producer.tick(this);
        // producer.tick(this);
        consumer1.tick(this);
        consumer.tick(this);
        
        millis += 1000;
        }
      } 
    catch (InterruptedException ex) {
      Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }
