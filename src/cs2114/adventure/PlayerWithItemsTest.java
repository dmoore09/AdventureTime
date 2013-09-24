package cs2114.adventure;

import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  test the playerWithItems class for errors
 *
 *  @author dmoore09
 *  @version Jan 31, 2013
 */
public class PlayerWithItemsTest
    extends TestCase
{

    //fields for player, item, and room
    private PlayableRoom room;
    private Item item;
    private PlayerWithItems user;
    private PlayerWithItems user1;

    /**
     * initialize fields for testing
     */
    public PlayerWithItemsTest()
    {
        room = new PlayableRoom("Room for Testing", "TestRoom");
        item = new Item("rock", 1.0, "small rock");
        user = new PlayerWithItems();
        user1 = new PlayerWithItems(item);
    }


    /**
     * add an item to inventory see if weight changes
     */
    public void testPickUpItem()
    {
        //add item to room and set current room
        room.addItem(item);
        user.setCurrentRoom(room);

        //pick up item
        user.pickUpItem();

        assertEquals(1.0, user.getWeight(), 0.01);
        assertEquals(1, user.getInventory().size());

    }

    /**
     * test pick up Items when there are no items in the room
     */
    public void testPickUpItemNone()
    {
        user.setCurrentRoom(room);

        //try to pick up items
        user.pickUpItem();

        assertEquals(0, user.getInventory().size());
    }

    /**
     * test pickUpItem when player will be to heavy
     */
    public void testPickUpItemHeavy()
    {
        //add item to the room
        Item heavy = new Item("big", 100.0, "to heavy");
        room.addItem(heavy);

        //try and pick up
        user.setCurrentRoom(room);
        user.pickUpItem();

        assertEquals(0, user.getInventory().size());
    }



    /**
     * test reviewItem to make sure rock is found when present
     */
    public void testReviewItemT()
    {
        assertEquals("small rock", user1.reviewItem("rock"));
    }

    /**
     * test reviewItem when player does not have an item
     */
    public void testReviewItemF()
    {
        assertEquals("you are not carrying that item", user.reviewItem("rock"));
    }

    /**
     * test drop Item to make sure it is removed from user inventory
     * and added to the room
     */
    public void testDropItem()
    {
        user1.setCurrentRoom(room);
        user1.dropItem("rock");

        assertEquals(0, user1.getInventory().size());
        assertEquals(1.0, user1.getWeight(), 0.01);
    }

    /**
     * test drop item when no items are present to drop
     */
    public void testDropItemF()
    {
        PlayerWithItems user3 = new PlayerWithItems(item);
        user3.setCurrentRoom(room);

        user3.dropItem("ball");

        assertEquals(1, user3.getInventory().size());
        assertEquals(2.0, user3.getWeight(), 0.01);
    }

}

