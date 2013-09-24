package cs2114.adventure;

import java.io.PrintWriter;
/**
 * // -------------------------------------------------------------------------
/**
 *  allows a user to take an item from a room
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author dmoore09
 *  @version Feb 9, 2013
 */
public class TakeCommand
    extends Command
{

    /**
     * Allows user to take an item from the current room. If item is not
     * present will give error message
     * @param user the player in the game
     * @param writer is the PrintWriter that displays text on the screen
     * @return false for all conditions
     */
    @Override
    public boolean execute(Player user, PrintWriter writer)
    {
        PlayerWithItems user1 = (PlayerWithItems) user;
        Room cRoom = user1.getCurrentRoom();

        if (hasSecondWord())
        {
            String itemId = getSecondWord();

            if (((PlayableRoom)cRoom).hasItem(itemId))
            {
                String itemDescription = user1.pickUpItem();
                writer.println(itemId + " has been added to your inventory");
                writer.println(itemDescription);
            }
            else
            {
                writer.println(itemId + " is not in this room");
            }
        }
        else
        {
            writer.println("What would you like to take?");
        }
        return false;
    }

}
