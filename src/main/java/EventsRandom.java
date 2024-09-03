package src.main.java;

import java.util.Random;

public class EventsRandom {
    
    private final String[] events = new String[]{"COMBAT","SHOP","BOSS","CAMP"};
    private static final Random EventRNG = new Random();
    private String Events;

    public EventsRandom() {
        this.Events = this.randomEvent();
    }

    public String randomEvent()  {
        return events[EventRNG.nextInt(events.length)];
    }

    public String getEvent() {
        return Events;
    }

    public String toString() {
        return this.Events;
    }
}
