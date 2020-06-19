package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Lejing Huang
 * @version 1.0
 * @since 2020-04-28
 */
public abstract class Asset implements Functionality {

    //Abstract class
    private SimpleStringProperty ID = new SimpleStringProperty("");
    private SimpleStringProperty Name = new SimpleStringProperty("");
    private SimpleStringProperty Type = new SimpleStringProperty("");
    private SimpleStringProperty Location = new SimpleStringProperty("");
    private SimpleStringProperty UsedBy = new SimpleStringProperty("");
    private SimpleStringProperty State = new SimpleStringProperty("");

    //Getter and setter
    public void setID(String ID)
    {
        this.ID.set(ID);
    }

    public void setName(String Name)
    {
        this.Name.set(Name);
    }

    public void setType(String Type)
    {
        this.Type.set(Type);
    }

    public void setLocation(String Location)
    {
        this.Location.set(Location);
    }

    public void setUsedBy(String UsedBy)
    {
        this.UsedBy.set(UsedBy);
    }

    public void setState(String State)
    {
        this.State.set(State);
    }

    public String getID()
    {
        return ID.get();
    }

    public String getName()
    {
        return Name.get();
    }

    public String getType()
    {
        return Type.get();
    }

    public String getLocation()
    {
        return Location.get();
    }

    public String getUsedBy()
    {
        return UsedBy.get();
    }

    public String getState()
    {
        return State.get();
    }
}
