package sample;

/**
 * @author Lejing Huang
 * @version 1.0
 * @since 2020-04-28
 */
public class AudioVideo extends Asset {

    //Static member: as a counter for the number of AudioVideo Object
    static public int NUMBER = 0;

    //Private member
    private double Price;
    private double Discount;

    //Default constructor
    public AudioVideo()
    {
        setID("");
        setName("");
        setType("");
        setLocation("");
        setUsedBy("");
        setState("");
        setPrice(0.0);
        setDiscount(0.0);

        NUMBER++;
    }

    //Overloaded constructor
    public AudioVideo(String ID, String Name, String Type, String Location, String UsedBy, String State, double Price, double Discount)
    {
        setID(ID);
        setName(Name);
        setType(Type);
        setLocation(Location);
        setUsedBy(UsedBy);
        setState(State);
        setPrice(Price);
        setDiscount(Discount);

        NUMBER++;
    }

    //Getter and setter
    public void setPrice(double Price)
    {
        this.Price = Price;
    }

    public void setDiscount(double Discount)
    {
        this.Discount = Discount;
    }

    public double getPrice()
    {
        return Price;
    }

    public double getDiscount()
    {
        return Discount;
    }

    //Unique functionality
    public double discountPrice(double Price, double Discount)
    {
        double discountPrice;

        discountPrice = Price * Discount;

        return discountPrice;
    }

    @Override
    public void MaintenancePlans()
    {
        System.out.println("The projector window has been cleaned and the lamp has been replaced.");
    }

    @Override
    public void IPConfiguration()
    {
        System.out.println("The projector has obtained IP addresses from a pool of static IP addresses and has been configured by network personnel successfully.");
    }
}
