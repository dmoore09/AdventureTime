package cs2114.adventure;

/**
 * // -------------------------------------------------------------------------
/**
 *  tests the PlayableRoom class
 *
 *  @author dmoore09
 *  @version Jan 31, 2013
 */
public class PlayableRoomTest
    extends student.TestCase
{

    //fields for playable room and item to be used in testing
    private PlayableRoom room;
    private Item item;

    /**
     * initialize the fields
     */
    public void setUp()
    {
        room = new PlayableRoom("Room for Testing", "TestRoom");
        item = new Item("rock", 1.0, "small rock");
    }

    /**
     * test the getName method
     */
    public void testGetName()
    {
        assertEquals("TestRoom", room.getName());
    }

    /**
     * test get items method
     */
    public void testGetItems()
    {
        assertEquals(0, room.returnItems().size());
    }

    /**
     * test add item by making sure an item can be added to the array
     * items
     */
    public void testAddItem()
    {
        room.addItem(item);

        assertEquals(1, room.returnItems().size());
    }

    /**
     * test remove item to make sure it works by adding an item then removing
     * it
     */
    public void testRemoveItem()
    {
        room.addItem(item);

        room.removeItem("rock");

        assertEquals(0, room.returnItems().size());
    }

    /**
     * test remove item to make sure it works when searching for an item the is
     * not present
     */
    public void testRemoveItemF()
    {
        room.addItem(item);

        room.removeItem("ball");

        assertEquals(1, room.returnItems().size());
    }

    /**
     * test getLonDescription() to make sure the right message is returned
     */
    public void testGetLongDescription()
    {
        String expected = room.getLongDescription();
        assertEquals(expected, room.getLongDescription());
    }
}
