package cs2114.adventure;

import student.TestCase;
import student.testingsupport.PrintWriterWithHistory;
import java.util.Scanner;
/**
 * // -------------------------------------------------------------------------
/**
 *  test the DropCommand class methods
 *
 *  @author dmoore09
 *  @version Feb 13, 2013
 */
public class DropCommandTest
    extends TestCase
{
    private PlayableRoom room;
    private Item item;
    private PlayerWithItems user;
    private DropCommand command;

    /**
     * initializes static fields before each run of a test
     */
    public void setUp()
    {
        room = new PlayableRoom("Room for Testing", "TestRoom");
        item = new Item("rock", 1.0, "small rock");
        user = new PlayerWithItems(item);
        command = new DropCommand();

        user.setCurrentRoom(room);
    }

    /**
     * test DropCommand for when the player has the specified item
     */
    public void testDropCommandItem()
    {
        command.readArguments(new Scanner("rock"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("rock has been dropped from " +
        		"your inventory"));
    }

    /**
     * test DropCommand for when a player tries to drop an item he doesn't have
     */
    public void testDropItemNoItem()
    {
        command.readArguments(new Scanner("blob"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("you are not carrying that " +
        		"item"));
    }

    /**
     * test DropCommand when a second word is not entered
     */
    public void testDropCommandFalse()
    {
        command.readArguments(new Scanner(""));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("What would you like to " +
        		"drop?"));
    }

}
