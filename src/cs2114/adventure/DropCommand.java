package cs2114.adventure;

import java.io.PrintWriter;
/**
 * // -------------------------------------------------------------------------
/**
 *  allows user to drop item in inventory
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author dmoore09
 *  @version Feb 10, 2013
 */

public class DropCommand
    extends Command
{

    /**
     * user drops item, if there is no item present then outputs an error
     * message
     * @param user is the player in the game
     * @param writer is the PrinterWriter that displays text on the screen
     * @return false for all conditions
     */
    @Override
    public boolean execute(Player user, PrintWriter writer)
    {
        //typecast user and get his current room
        PlayerWithItems user1 = (PlayerWithItems) user;

        //if user entered drop itemName
        if (hasSecondWord())
        {
            String itemId = getSecondWord();

            //drop item if present in inventory
            if (user1.findItem(itemId) < user1.getInventory().size())
            {
                user1.dropItem(itemId);
                writer.println(itemId + " has been dropped from your " +
                		"inventory");
            }
            //error if no item in inventory
            else
            {
                writer.println("you are not carrying that item");
            }
        }
        //if there is no item specified
        else
        {
            writer.println("What would you like to drop?");
        }

        return false;
    }

}
