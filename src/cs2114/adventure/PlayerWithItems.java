package cs2114.adventure;

import java.util.ArrayList;
import java.util.List;

/**
 * // -------------------------------------------------------------------------
 * /** Gives Player the ability to hold items The items are held in an array
 * once the player has items he can look at their descriptions and drop them.
 * all items will be added up to calculate the weight of the player
 *
 * @author dmoore09
 * @version Jan 29, 2013
 */
public class PlayerWithItems
    extends Player
    implements Weighable
{
    // field for weight and inventory
    private double     weight;
    private List<Item> inventory;



    /**
     * initialize player class creates a list for items
     */
    public PlayerWithItems()
    {
        inventory = new ArrayList<Item>();
        weight = 1.0;

    }


    /**
     * initialize player class with an item already in his inventory
     * @param starterItem is an item for the player to start with
     */
    public PlayerWithItems(Item starterItem)
    {
        inventory = new ArrayList<Item>();
        inventory.add(starterItem);
        weight = 1.0 + starterItem.getWeight();
    }


    /**
     * pick up an item that is encountered
     * @return item description
     */
    public String pickUpItem()
    {
        // find item and tell player what is in the room
        Room cRoom = this.getCurrentRoom();
        List<Item> roomItems = ((PlayableRoom)cRoom).returnItems();

        for (Item foundItem : roomItems)
        {
            if (roomItems.size() != 0)
            {
                // calculate weight
                double addedWeight = foundItem.getWeight();

                if (addedWeight + weight > 50)
                {
                    System.out.println("you are to heavy");
                }
                else
                {
                    // add to list
                    inventory.add(foundItem);
                    return foundItem.getDescription();
                }
            }
            else
            {
                System.out.println("there are no items in the room!");
            }
        }
        return "";
    }


    /**
     * looks for an item name and returns its info
     * @param itemName is the name of the item
     * @return description of item or error message
     */
    public String reviewItem(String itemName)
    {
        // search for items string name findItem()
        int itemIndex = this.findItem(itemName);

        if (itemIndex < inventory.size())
        {
            // if item is found give description
            Item desiredItem = inventory.get(itemIndex);
            return desiredItem.getDescription();
        }
        // if not found give error message
        else
        {
            return "you are not carrying that item";
        }

    }


    /**
     * drop an item from the inventory *must have current room set to work
     * @param itemName of item to be found
     */
    public void dropItem(String itemName)
    {
        // search for name findItem()
        int itemIndex = this.findItem(itemName);

        if (itemIndex < inventory.size())
        {
            Item dropItem = inventory.get(itemIndex);
            double itemWeight = dropItem.getWeight();

            // drop item
            inventory.remove(itemIndex);

            // change weight
            weight = weight - itemWeight;

            // add item to current room
            Room cRoom = this.getCurrentRoom();
            ((PlayableRoom)cRoom).addItem(dropItem);
        }
        else
        {
            System.out.println("your not carrying that item");
        }
    }


    /**
     * search for name of object in inventory
     *
     * @return index of item inside inventory
     * @param itemName
     *            name of item to search for
     */
    public int findItem(String itemName)
    {
        int i = 0;
        for (Item anyItem : inventory)
        {
            if (itemName.equals(anyItem.getName()))
            {
                return i;
            }
            i++;
        }
        return inventory.size();
    }


    /**
     * return the weight of the player
     * @return the double value for the player's weight
     */
    @Override
    public double getWeight()
    {
        // TODO Auto-generated method stub
        return weight;
    }


    /**
     * return the player's inventory
     * @return list of items that player has
     */
    public List<Item> getInventory()
    {
        return inventory;
    }

}
