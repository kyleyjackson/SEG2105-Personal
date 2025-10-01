package ASSIGNMENTS.A1_300425781.E2;

public class Logger implements EventHandler { 
    
    // interface method
    public void handle(Event event) { System.out.println("[LOG] " + event.toString()); }
}