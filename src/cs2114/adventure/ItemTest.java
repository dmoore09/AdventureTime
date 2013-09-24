package cs2114.adventure;
/**
 * // -------------------------------------------------------------------------
/**
 *  test Item to make sure all methods work as expected
 *
 *  @author dmoore09
 *  @version Jan 30, 2013
 */
public class ItemTest extends student.TestCase
{

    //fields
    private Item testItem;

    /**
     * initialize item field
     */
    public ItemTest()
    {
        testItem = new Item("sword", 1.0, "kill stuff");
    }

    /**
     * test for correct weight
     */
    public void testGetWeight()
    {
        assertEquals(1.0, testItem.getWeight(), 0.01);
    }

    /**
     * test for correct name
     */
    public void testGetName()
    {
        assertEquals("sword", testItem.getName());
    }

    /**
     * test for correct description
     */
    public void testGetDescription()
    {
        assertEquals("kill stuff", testItem.getDescription());
    }
}
