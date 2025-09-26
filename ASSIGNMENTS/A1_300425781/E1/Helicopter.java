package ASSIGNMENTS.A1_300425781.E1;

import java.time.Instant;

public class Helicopter extends AirVehicle {

    // constants
    private final double MAX_WEIGHT = 80000.0;
    private final double MAX_SPEED = 900.0;
    private final double MIN_SPEED = 90.0;

    // id helper
    private static int count = -1;

    // instance variables
    private static int id;
    private final Instant REG_TIME = Instant.now();
    private double emptyWeight;
    private double cruiseSpeed;

    public Helicopter() {
        super();
        id = count++;
        count++;
    }

    public Helicopter(double weight, double speed) {
        super(weight, speed);
        id = count++;
        count++;
    }

    // inherited abstract methods
    public double getEmptyWeight() { return emptyWeight; }

    public double getCruiseSpeed() { return cruiseSpeed; }

    public double getMaxSpeed() { return MAX_SPEED; }

    public double getMinSpeed() { return MIN_SPEED; }

    public double getMaxWeight() { return MAX_WEIGHT; }

    public int getId() { return id; }

    public Instant getRegistrationTime() { return REG_TIME; }

    public String getVehicleType() { return "Helicopter"; }
    
    // methods
    public static int count() { return id - 1; }
}