package cs2114.adventure;

import java.io.PrintWriter;
/**
 * // -------------------------------------------------------------------------
/**
 *  Prints out the player's inventory
 *  Will retrieve player's inventory and print out description of each item
 *
 *  @author dmoore09
 *  @version Feb 9, 2013
 */
public class InventoryCommand
    extends Command
{

    /**
     * Prints out the players inventory
     * @param user the player in the game
     * @param writer is the PrintWriter that displays text on the screen
     * @return false for all outcomes
     */
    @Override
    public boolean execute(Player user, PrintWriter writer)
    {
        PlayerWithItems user1 = (PlayerWithItems) user;

        //looks for second word of command
        if (hasSecondWord())
        {
            String itemId = getSecondWord();
            //will return item description if present and send error if not
            String message = user1.reviewItem(itemId);
            writer.println(message);
        }
        //if there is no second word send an error
        else
        {
            writer.println("What item would you like to look at?");
        }

        return false;
    }

}
