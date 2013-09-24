package cs2114.adventure;

import java.util.Scanner;
import student.TestCase;
import student.testingsupport.PrintWriterWithHistory;
/**
 * // -------------------------------------------------------------------------
/**
 *  test the take command methods
 *
 *  @author dmoore09
 *  @version Feb 13, 2013
 */
public class TakeCommandTest
    extends TestCase
{
    private PlayableRoom room;
    private Item item;
    private PlayerWithItems user;
    private TakeCommand command;


    /**
     * runs before every test method to set up the conditions
     */
    public void setUp()
    {
        room = new PlayableRoom("Room for Testing", "TestRoom");
        item = new Item("rock", 1.0, "small rock");
        user = new PlayerWithItems();
        command = new TakeCommand();

        user.setCurrentRoom(room);
        room.addItem(item);
    }

    /**
     * test take when there is an item in the room
     */
    public void testTakePresent()
    {
        command.readArguments(new Scanner("rock"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("rock has been added to " +
        		"your inventory"));
    }

    /**
     * test take when there is an item in the room
     */
    public void testTakeNoItem()
    {
        command.readArguments(new Scanner("blob"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("blob is not in this " +
        		"room"));
    }

    /**
     * test take when there is no second word entered
     */
    public void testTakeNoSW()
    {
        command.readArguments(new Scanner(""));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("What would you like to " +
        		"take?"));
    }

}
