package cs2114.adventure;

import java.util.ArrayList;
import java.util.List;

/**
 * // -------------------------------------------------------------------------
/**
 *  Room that allows items to be placed in it
 *  Room is the playing field for the game where all of the items, npcs and
 *  player exist
 *
 *  @author dmoore09
 *  @version Jan 29, 2013
 */
public class PlayableRoom
    extends Room
{
    //list for items in the room, name
    private List<Item> items;
    private String name;

    /**
     * creates a list that holds all of the items in the map
     * @param description of the room
     * @param title of the room
     */
    public PlayableRoom(String description, String title)
    {
        super(description);
        items = new ArrayList<Item>();
        name = title;
    }

    /**
     * allows you to add an item to the room
     * @param anyItem is item to be added
     */
    public void addItem(Item anyItem)
    {
        items.add(anyItem);
    }

    /**
     * allows you to remove an item from a room
     * @param type is name of object
     */
    public void removeItem(String type)
    {
        int i = 0;
        for (Item anyItem : items)
        {
            if (type.equals(anyItem.getName()))
            {
                items.remove(i);
                break;
            }
            i++;
        }
    }

    /**
     * allows you to access the items in the room
     * @return array of all items in the room
     */
    public List<Item> returnItems()
    {
        return items;
    }

    /**
     * return the name of the room
     * @return the name of the room
     */
    public String getName()
    {
        return name;
    }

    /**
     * returns item with specified name
     * @param itemName is the name of item to be found
     * @return true if has item, false if no item
     */
    public boolean hasItem(String itemName)
    {
        for (Item item : items)
        {
            if (itemName.equals(item.getName()))
            {
                return true;
            }

        }
        return false;
    }

    /**
     * returns the long description of the room as well as it's items
     * @return description of room and items in it
     */
    public String getLongDescription()
    {
        String description = super.getLongDescription();
        String itemId = "The items in this room are:";
        List<Item> itemsRoom = this.returnItems();

        for (Item item : itemsRoom)
        {
            itemId = itemId + " " + item.getName();
        }

        return description + " " + itemId;
    }





}
