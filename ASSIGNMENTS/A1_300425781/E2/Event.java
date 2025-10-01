package ASSIGNMENTS.A1_300425781.E2;

public class Event {
    
    // instance variables
    private String name;
    private int priority;

    // constructor
    public Event(String s, int p) {
        name = s;
        priority = p;
    }

    // getters
    public String getName() { return name; }
    public int getPriority() { return priority; }

    // emthods
    public String toString() { return "Event: {Name: \'" + getName() + "\', Priority: " + getPriority() + "}"; }
}