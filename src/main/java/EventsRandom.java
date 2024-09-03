package src.main.java;

import java.util.Random;

public class EventsRandom {
    
    private final String[] events = new String[]{"COMBAT","SHOP","BOSS","CAMP"};
    private static final Random EventRNG = new Random();
    private String Events;

    EventsRandom() {
        this.Events = this.randomEvent();
    }

    public String randomEvent()  {
        return events[EventRNG.nextInt(events.length)];
    }

    public String getEvent() {
        return Events;
    }

    public String toString() {
        return this.Events +"\n";
    }

    public static void main(String[] args){
        EventsRandom test = new EventsRandom();
        System.out.println(test.toString());
    }
}
