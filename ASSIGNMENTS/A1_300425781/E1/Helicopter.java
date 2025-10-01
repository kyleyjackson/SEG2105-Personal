package ASSIGNMENTS.A1_300425781.E1;

import java.time.Instant;

public class Helicopter extends AirVehicle {

    // constants
    private final double MAX_WEIGHT = 5000.0;
    private final double MAX_SPEED = 250.0;
    private final double MIN_SPEED = 25.0;

    // variables
    private static int count = 0;
    private final Instant REG_TIME = Instant.now();

    public Helicopter() {
        super();
        count++;
    }

    public Helicopter(double weight, double speed) {
        super(weight, speed);
        count++;
    }

    // methods
    public double getEmptyWeight() { return emptyWeight; }

    public double getCruiseSpeed() { return cruiseSpeed; }

    public double getMaxSpeed() { return MAX_SPEED; }

    public double getMinSpeed() { return MIN_SPEED; }

    public double getMaxWeight() { return MAX_WEIGHT; }

    public Instant getRegistrationTime() { return REG_TIME; }

    public String getVehicleType() { return "Helicopter"; }
    
    public static int count() { return count; }
}