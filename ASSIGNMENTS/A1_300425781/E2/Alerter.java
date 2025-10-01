package ASSIGNMENTS.A1_300425781.E2;

public class Alerter implements EventHandler {
    
    // interface method
    public void handle(Event event) {
        if (event.getPriority() > 3) { System.out.println("[ALERT] CRITICAL: " + event.getName()); }
        else { System.out.println("[ALERT] Minor Issue: " + event.getName()); }
    }
} 