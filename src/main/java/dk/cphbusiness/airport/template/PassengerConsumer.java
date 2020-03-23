package dk.cphbusiness.airport.template;

import dk.cphbusiness.algorithm.examples.queues.PriorityQueuePassengers;
import java.util.List;

public class PassengerConsumer {

    private final List<Plane> planes;
    private final PriorityQueuePassengers queue;
    private int processingTicksLeft = 500;
    // Passenger being processed
    private Passenger passenger;
    String version;

    public PassengerConsumer(List<Plane> planes, PriorityQueuePassengers queue, String version) {
        this.planes = planes;
        this.queue = queue;
        this.version = version;
    }

    public void tick(Clock clock) {
        if (processingTicksLeft > 0) {
            processingTicksLeft--;
            return;
        }

        System.out.println("before peeking : " + queue.peek());
        passenger = queue.dequeue();
        System.out.println("after peeking: " + queue.peek());

        if (passenger == null) {
            processingTicksLeft = 100;
        } else {
            Time now = clock.getTime();
            if (passenger.getPlane().getDepartureTime().compareTo(now) < 0) {
                passenger.setStatus(Status.MissedPlane);
                System.out.println("Consumer" + version + ":    ->      Passenger " + passenger + " missed the plane");
            } else if (passenger.getStatus() == Status.Boarded) {
                //System.out.println("Waiting to consume ("+version+")");
            } else {
                passenger.setStatus(Status.Boarded);
                System.out.println("Consumer" + version + ":    ->      Passenger " + passenger + " has boarded");
            }

            switch (passenger.getCategory()) {
                case LateToFlight:
                    processingTicksLeft = 100;
                    break;
                case BusinessClass:
                    processingTicksLeft = 100;
                    break;
                case Disabled:
                    processingTicksLeft = 100;
                    break;
                case Family:
                    processingTicksLeft = 100;
                    break;
                case Monkey:
                    processingTicksLeft = 100;
                    break;
            }

        }

    }
}

