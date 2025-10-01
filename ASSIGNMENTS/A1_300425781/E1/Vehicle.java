package ASSIGNMENTS.A1_300425781.E1;

// imports
import java.time.Instant;

public abstract class Vehicle implements Printable {
    
    // private data
    protected double emptyWeight; // vehicles base weight
    protected double cruiseSpeed; // usual operating speed
    private static int n0 = 0;
    protected int id;

    // constructors
    public Vehicle() { // set weight 30% of max, speed 30% of max
        emptyWeight = 0.3 * getMaxWeight();
        cruiseSpeed = 0.3 * getCruiseSpeed();
        this.id = n0;
        n0++;
    }

    public Vehicle(double weight, double speed) {
        setCruiseSpeed(speed);
        setEmptyWeight(weight);
        this.id = n0;
        n0++;
    }

    // abstract methods (getters)
    public abstract double getMaxWeight();
    public abstract double getMaxSpeed();
    public abstract double getMinSpeed();
    public abstract double getEmptyWeight();
    public abstract double getCruiseSpeed();
    public abstract Instant getRegistrationTime();
    public abstract String getVehicleType();

    // setters
    public void setCruiseSpeed(double n) { 
        if (n < getMinSpeed())
            throw new IllegalArgumentException("cruiseSpeed must be greater than or equal to MIN_SPEED (" + getMinSpeed() + ")");
        else if (n > getMaxSpeed())
            throw new IllegalArgumentException("cruiseSpeed must be less than or equal to MAX_SPEED (" + getMaxSpeed() + ")");
        else
            cruiseSpeed = n;
    }

    public void setEmptyWeight(double n) { 
        if (n <= 0)
            throw new IllegalArgumentException("emptyWeight must be greater than 0");
        else if (n > getMaxWeight())
            throw new IllegalArgumentException("emptyWeight must be less than or equal to MAX_WEIGHT (" + getMaxWeight() + ")");
        else
            emptyWeight = n;
    }
    
    public int getId() { return id; }

    // methods
    public void start() { System.out.println(getVehicleType() + "[" + getId() + "] has started!"); }
    public void move() { System.out.println(getVehicleType() + "[" + getId() + "] has moved!"); }
    public void stop() { System.out.println(getVehicleType() + "[" + getId() + "] has stopped!"); }

    public void operate() {
        start();
        move();
        stop();
    }

    // from Printable interface
    public void dump() {
        System.out.println("--- " + getVehicleType() + " ---");
        System.out.println("id          : " + getId());
        System.out.println("emptyWeight : " + getEmptyWeight() + " kg");
        System.out.println("cruiseSpeed : " + getCruiseSpeed() + " km/h");
        System.out.println("MAX_WEIGHT  : " + getMaxWeight() + " kg");
        System.out.println("MAX_SPEED   : " + getMaxSpeed() + " km/h");
        System.out.println("MIN_SPEED   : " + getMinSpeed() + " km/h");
        System.out.println("REG_TIME    : " + getRegistrationTime());
    }
}
