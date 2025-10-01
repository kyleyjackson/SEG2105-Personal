package ASSIGNMENTS.A1_300425781.E2;

public class Notifier implements EventHandler {
    
    // interface method
    public void handle(Event event) { System.out.println("[NOTIFICATION] User alerted about: " + event.getName()); }
}