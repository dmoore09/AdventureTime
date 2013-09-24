package cs2114.adventure;
import java.io.PrintWriter;

/**
 * // -------------------------------------------------------------------------
/**
 *  opens the locked door in the first room when used with old key
 *  only works with the key and the player must be in darkroom
 *
 *  @author dmoore09
 *  @version Feb 12, 2013
 */
public class UseCommand
    extends Command
{

    /**
     * allows player to use a key to win the game. If it is any other item
     * will throw an error
     * @param user the player in the game
     * @param writer is the PrintWriter that displays text on the screen
     * @return false for all conditions
     */
    @Override
    public boolean execute(Player user, PrintWriter writer)
    {

        PlayerWithItems user1 = (PlayerWithItems) user;
        Room cRoom = user1.getCurrentRoom();

        //make sure user has entered item name
        if (hasSecondWord())
        {
            String itemName = getSecondWord();
            //make sure user has item
            if (user1.findItem(itemName) < user1.getInventory().size())
            {
                //check to see if it is the old key, and in dark room
                if (itemName.equals("oldKey") &&
                    ((PlayableRoom)cRoom).getName().equals("Dark Room"))
                {
                    writer.println("You have escaped!!");
                }
                //if it is not an old key give error
                else
                {
                    writer.println("you cannot use that here");
                }
            }
            //tell player he does not have the specified item
            else
            {
                writer.println("you do not have that item");
            }
        }
        //tell player to enter a item name
        else
        {
            writer.println("What would you like to use?");
        }

        return false;
    }

}
