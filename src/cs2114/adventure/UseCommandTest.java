package cs2114.adventure;

import student.TestCase;
import student.testingsupport.PrintWriterWithHistory;
import java.util.Scanner;
/**
 * // -------------------------------------------------------------------------
/**
 *  test use command methods
 *
 *  @author dmoore09
 *  @version Feb 13, 2013
 */
public class UseCommandTest
    extends TestCase
{
    private PlayableRoom room;
    private Item oldKey;
    private PlayerWithItems user;
    private UseCommand command;


    /**
     * runs before all test methods to set up test
     */
    public void setUp()
    {
        room = new PlayableRoom("Room for Testing", "Dark Room");
        oldKey = new Item("oldKey", 1.0, "small rock");
        user = new PlayerWithItems(oldKey);
        command = new UseCommand();

        user.setCurrentRoom(room);
    }

    /**
     * test use when there is a oldKey in player's inventory
     */
    public void testUseKey()
    {
        command.readArguments(new Scanner("oldKey"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("You have escaped!!"));
    }

    /**
     * test use when there is an in player's inventory, but not the key
     */
    public void testUseNotKey()
    {

        Item rock = new Item("rock", 1.0, "testing");
        PlayerWithItems user1 = new PlayerWithItems(rock);
        command.readArguments(new Scanner("rock"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user1, writer);

        assertTrue(writer.getHistory().contains("you cannot use that here"));
    }

    /**
     * test use when there is not such item in player's inventory
     */
    public void testUseWrongItem()
    {
        command.readArguments(new Scanner("rock"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("you do not have that item"));
    }

    /**
     * test use when there is no second word entered
     */
    public void testUseNo()
    {
        command.readArguments(new Scanner(""));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("What would you like to use?"));
    }


}
