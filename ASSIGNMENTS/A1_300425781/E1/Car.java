package ASSIGNMENTS.A1_300425781.E1;

import java.time.Instant;

public class Car extends LandVehicle {

    // constants
    private final double MAX_WEIGHT = 1500.0;
    private final double MAX_SPEED = 200.0;
    private final double MIN_SPEED = 20.0;

    // id helper
    private static int count = -1;

    // instance variables
    private static int id;
    private final Instant REG_TIME = Instant.now();
    private double emptyWeight;
    private double cruiseSpeed;

    public Car() {
        super();
        id = count++;
        count++;
    }

    public Car(double weight, double speed) {
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

    public String getVehicleType() { return "Car"; }
    
    // methods
    public static int count() { return id - 1; }
}