package ASSIGNMENTS.A1_300425781.E1;

import java.time.Instant;

public class Plane extends AirVehicle {
  
    // constants
    private final double MAX_WEIGHT = 80000.0;
    private final double MAX_SPEED = 900.0;
    private final double MIN_SPEED = 90.0;

    // variables
    private static int count = 0;
    private final Instant REG_TIME = Instant.now();

    public Plane() {
        super();
        count++;
    }

    public Plane(double weight, double speed) {
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

    public String getVehicleType() { return "Plane"; }

    public static int count() { return count;}
}