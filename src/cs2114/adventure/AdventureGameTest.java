package cs2114.adventure;

import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  test adventure game class to make sure the game is set up properly
 *
 *  @author dmoore09
 *  @version Feb 13, 2013
 */
public class AdventureGameTest
    extends TestCase
{

    /**
     * test all methods except welcome message
     */
    public void testGame()
    {
        AdventureGame game = new AdventureGame();
        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        game.useWriter(writer);
        assertTrue(game.interpret("quit"));
    }

    /**
     * make sure the right welcome message is printed
     */
    public void testWelcomeMessage()
    {
        AdventureGame game = new AdventureGame();
        String message = game.welcomeMessage();
        String expectedMessage = "You wake up in a poorly lit room with" +
        	" nothing in your pockets."
            + " You see two doors, one to the left and one to the right. The"
            + " door on the left appears to be locked"
            + " What do you want to do?" + " type 'help' if you have "
            + "any questions";
        assertEquals(message, expectedMessage);
    }
}
