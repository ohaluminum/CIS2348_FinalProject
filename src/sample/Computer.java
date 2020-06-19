package sample;

/**
 * @author Lejing Huang
 * @version 1.0
 * @since 2020-04-28
 */
public class Computer extends Asset {

    //Static member: as a counter for the number of Computer Object
    static public int NUMBER = 0;

    //Private member
    private String SubType;
    private double batteryCapacity;
    private double usedPercentage;

    //Default constructor
    public Computer()
    {
        setID("");
        setName("");
        setType("");
        setLocation("");
        setUsedBy("");
        setState("");
        setSubType("");
        setBatteryCapacity(0.0);
        setUsedPercentage(0.0);

        NUMBER++;
    }

    //Overloaded constructor
    public Computer(String ID, String Name, String Type, String Location, String UsedBy, String State, String SubType, double batteryCapacity, double usedPercentage)
    {
        setID(ID);
        setName(Name);
        setType(Type);
        setLocation(Location);
        setUsedBy(UsedBy);
        setState(State);
        setSubType(SubType);
        setBatteryCapacity(batteryCapacity);
        setUsedPercentage(usedPercentage);

        NUMBER++;
    }

    //Getter and setter
    public void setSubType(String SubType)
    {
        this.SubType = SubType;
    }

    public void setBatteryCapacity(double batteryCapacity)
    {
        this.batteryCapacity = batteryCapacity;
    }

    public void setUsedPercentage(double usedPercentage)
    {
        this.usedPercentage = usedPercentage;
    }

    public String getSubType()
    {
        return SubType;
    }

    public double getBatteryCapacity()
    {
        return batteryCapacity;
    }

    public double getUsedPercentage()
    {
        return usedPercentage;
    }

    //Unique Funtionality
    public double currentBattery(double batteryCapacity, double usedPercentage)
    {
        double currentBattery;

        currentBattery = batteryCapacity * (1 - usedPercentage);

        return currentBattery;
    }

    @Override
    public void MaintenancePlans()
    {
        System.out.println("The server/laptop/desktop has completed security updates and software upgrades.");
    }

    @Override
    public void IPConfiguration()
    {
        if (SubType.equals("Laptop") || SubType.equals("Desktop"))
        {
            System.out.println("The laptop/desktop has automatically acquired dynamic IP addresses from DHCP servers.");
        }

        if (SubType.equals("Server"))
        {
            System.out.println("The server has obtained IP addresses from a pool of static IP addresses and has been configured by network personnel successfully.");
        }
    }
}
