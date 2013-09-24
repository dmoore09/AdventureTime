package cs2114.adventure;

/**
 * // -------------------------------------------------------------------------
/**
 *  Items to be found by the player placed in rooms
 *  Item can be named anything and be used for certain objectives in the game
 *
 *  @author dmoore09
 *  @version Jan 29, 2013
 */
public class Item
    implements Weighable
{

    //fields for weight, name, description
    private String name;
    private double weight;
    private String description;

    /**
     * Initializes the item by defining its weight and name
     * @param type is the type of object to be created
     * @param mass is the weight of the object
     * @param description1 a description of the object
     */
    public Item(String type, double mass, String description1)
    {
        name = type;
        weight = mass;
        description = description1;
    }

    /**
     * return weight of the object
     * @return double to represent the weight of the item
     */
    @Override
    public double getWeight()
    {
        // TODO Auto-generated method stub
        return weight;
    }

    /**
     * return name of item
     * @return name of item
     */
    public String getName()
    {
        return name;
    }

    /**
     * get the description of the object
     * @return description describing the object and its properties
     */
    public String getDescription()
    {
        return description;
    }


}
