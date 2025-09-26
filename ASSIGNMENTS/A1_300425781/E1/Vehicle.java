package ASSIGNMENTS.A1_300425781.E1;

// imports
import java.time.Instant;

public abstract class Vehicle implements Printable {
    
    // private data
    private double emptyWeight; // vehicles base weight
    private double cruiseSpeed; // usual operating speed

    // constructors
    public Vehicle() { // set weight 30% of max, speed 30% of max
        emptyWeight = 0.3 * getMaxWeight();
        cruiseSpeed = 0.3 * getMaxSpeed();
    }

    public Vehicle(double weight, double speed) {
        // illegal argument cases -> else set
        
        else if (emptyWeight > getMaxWeight()) 
            throw new IllegalArgumentException("emptyWeight must be less than or equal to MAX_WEIGHT (" + getMaxWeight() + ")");
        else if (cruiseSpeed < getMinSpeed())
            throw new IllegalArgumentException("cruiseSpeed must be greater than or equal to MIN_SPEED (" + getMinSpeed() + ")");
        else if (cruiseSpeed > getMaxSpeed())
            throw new IllegalArgumentException("cruiseSpeed must be less than or equal to MAX_SPEED (" + getMaxSpeed() + ")");
        else {
            emptyWeight = weight;
            cruiseSpeed = speed;
        }
    }

    // abstract methods (getters)
    public abstract double getMaxWeight();
    public abstract double getMaxSpeed();
    public abstract double getMinSpeed();
    public abstract double getEmptyWeight();
    public abstract double getCruiseSpeed();
    public abstract int getId();
    public abstract Instant getRegistrationTime();
    public abstract String getVehicleType();

    // setters
    public void setCruiseSpeed(double n) { 
        if (n <= 0)
            throw new IllegalArgumentException("emptyWeight must be greater than 0");
        else
            cruiseSpeed = n; 
    }
    public void setEmptyWeight(double n) { emptyWeight = n; }

    // methods
    public void start() { System.out.println("The vehicle has started!"); }
    public void move() { System.out.println("The vehicle has moved!"); }
    public void stop() { System.out.println("The vehicle has stopped!"); }

    public void operate() {
        start();
        move();
        stop();
    }

    // from Printable interface
    public void dump() {
        System.out.println("--- " + getVehicleType() + " ---");
        System.out.println("id          : " + getId());
        System.out.println("emptyWeight : " + getEmptyWeight());
        System.out.println("cruiseSpeed : " + getCruiseSpeed());
        System.out.println("MAX_WEIGHT  : " + getMaxWeight());
        System.out.println("MAX_SPEED   : " + getMaxSpeed());
        System.out.println("MIN_SPEED   : " + getMinSpeed());
        System.out.println("REG_TIME    : " + getRegistrationTime());
    }
}
