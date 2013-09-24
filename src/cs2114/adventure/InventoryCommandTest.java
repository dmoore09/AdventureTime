package cs2114.adventure;

import java.util.Scanner;
import student.testingsupport.PrintWriterWithHistory;
import student.TestCase;
/**
 * // -------------------------------------------------------------------------
/**
 *  test Inventory Command methods
 *
 *  @author dmoore09
 *  @version Feb 13, 2013
 */
public class InventoryCommandTest
    extends TestCase
{
    private Item item;
    private PlayerWithItems user;
    private InventoryCommand command;

    /**
     * runs before every test method to set up the conditions
     */
    public void setUp()
    {
        item = new Item("rock", 1.0, "small rock");
        user = new PlayerWithItems(item);
        command = new InventoryCommand();
    }

    /**
     * test inventory command when the desired item is in the players inventory
     */
    public void testInventoryItem()
    {
        command.readArguments(new Scanner("rock"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains(item.getDescription()));
    }

    /**
     * test inventory command when the desired item is not in
     * the players inventory
     */
    public void testInventoryNoItem()
    {
        command.readArguments(new Scanner("blah"));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("you are not carrying that" +
        		" item"));
    }

    /**
     * test inventory command when no second word is entered
     */
    public void testInventoryNo2Word()
    {
        command.readArguments(new Scanner(""));

        PrintWriterWithHistory writer = new PrintWriterWithHistory();
        command.execute(user, writer);

        assertTrue(writer.getHistory().contains("What item would you like " +
        		"to look at?"));
    }
}


