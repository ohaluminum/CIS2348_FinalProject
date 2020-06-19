package sample;

/**
 * @author Lejing Huang
 * @version 1.0
 * @since 2020-04-28
 */
public class Printer extends Asset {

    //Static member: as a counter for the number of Printer Object
    static public int NUMBER = 0;

    //private member
    private double inkCapacity;
    private double remainingPercentage;

    //Default constructor
    public Printer()
    {
        setID("");
        setName("");
        setType("");
        setLocation("");
        setUsedBy("");
        setState("");
        setInkCapacity(0.0);
        setRemainingPercentage(0.0);

        NUMBER++;
    }

    //Overloaded constructor
    public Printer(String ID, String Name, String Type, String Location, String UsedBy, String State, double inkCapacity, double remainingPercentage)
    {
        setID(ID);
        setName(Name);
        setType(Type);
        setLocation(Location);
        setUsedBy(UsedBy);
        setState(State);
        setInkCapacity(inkCapacity);
        setRemainingPercentage(remainingPercentage);

        NUMBER++;
    }

    //Getter and setter
    public void setInkCapacity(double inkCapacity)
    {
        this.inkCapacity = inkCapacity;
    }

    public void setRemainingPercentage(double remainingPercentage)
    {
        this.remainingPercentage = remainingPercentage;
    }

    public double getInkCapacity()
    {
        return inkCapacity;
    }

    public double getRemainingPercentage()
    {
        return remainingPercentage;
    }

    //Unique functionality
    public double remainingInk(double inkCapacity, double remainingPercentage)
    {
        double remainingInk;

        remainingInk = inkCapacity * remainingPercentage;

        return remainingInk;
    }

    @Override
    public void MaintenancePlans()
    {
        System.out.println("The printer has completed driver software updates, cleaning, and cartridge replacement.");
    }

    @Override
    public void IPConfiguration()
    {
        System.out.println("The printer has obtained IP addresses from a pool of static IP addresses and has been configured by network personnel successfully.");
    }
}
