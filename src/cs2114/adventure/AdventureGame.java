package cs2114.adventure;

/**
 * // -------------------------------------------------------------------------
 * /** Extends game class initializes all conditions for the game to run
 * includes all of the rooms and items to be in the game
 *
 * @author dmoore09
 * @version Feb 5, 2013
 */

public class AdventureGame
    extends Game
{

    /**
     * starts up the game with a new player
     */
    public AdventureGame()
    {
        super(new PlayerWithItems());
    }


    /**
     * all of the commands present in the game available for the user
     */
    @Override
    public void createCommands()
    {
        CommandWords commands = commandWords();
        commands.addCommand("go", new GoCommand());
        commands.addCommand("help", new HelpCommand(commands));
        commands.addCommand("quit", new QuitCommand());
        commands.addCommand("inventory", new InventoryCommand());
        commands.addCommand("drop", new DropCommand());
        commands.addCommand("take", new TakeCommand());
        commands.addCommand("use", new UseCommand());
    }


    /**
     * create rooms for player to navigate
     */
    @Override
    public void createRooms()
    {
        //create rooms and add items
        PlayableRoom darkRoom = new PlayableRoom("Dark Room with two doors" +
        		", one to the left and one to the right the " +
        		"left door appears to be locked", "Dark Room");

        PlayableRoom noteRoom = new PlayableRoom("in a dimly light room " +
            "with nothing but a table and a door ahead.... There appears to " +
            "be " + "a letter" + " on the table", "Note Room");
        Item letter = new Item("letter", 0.5, "A letter addressed to " +
        		"you. The letter reads: There is only one way out of here");
        noteRoom.addItem(letter);

        PlayableRoom hallway = new PlayableRoom("entering a long hallway, you "
        		+ "see a light at the end of the hall.", "A long Hallway");


        PlayableRoom brightRoom = new PlayableRoom("entering a very well " +
        		"light room with a small table with a key on top, there" +
        		" is a door on the left side of the room. As you enter the " +
        		"the door behind you locks", "Bright room");
        Item oldKey = new Item("oldKey", 1.0, "An old rusty key... Maybe it" +
            " will help me get out of here");
        brightRoom.addItem(oldKey);

        PlayableRoom maze1 = new PlayableRoom("entering a plain room with " +
        		"nothing in it. There are two doors one to the left" +
        		" and one to the right", "maze room 1");

        PlayableRoom maze2 = new PlayableRoom("entering another plain " +
        		"room.... One door ahead", "maze room 2");

        PlayableRoom maze3 = new PlayableRoom("entering a big empty " +
        		"room.", "maze room 3");


        //set exits
        darkRoom.setExit("right", noteRoom);
        noteRoom.setExit("ahead", hallway);
        noteRoom.setExit("back", darkRoom);
        hallway.setExit("back", noteRoom);
        hallway.setExit("ahead", brightRoom);
        brightRoom.setExit("left", maze1);
        maze1.setExit("back", brightRoom);
        maze1.setExit("left", darkRoom);
        maze1.setExit("right", maze2);
        maze2.setExit("back", maze1);
        maze2.setExit("ahead", maze3);
        maze3.setExit("back", maze2);


        //set dark room as start room"
        player().setCurrentRoom(darkRoom);
    }


    /**
     * a welcome message sent to user the first time they enter the world
     * @return the first message the player will see at start of the game
     */
    @Override
    public String welcomeMessage()
    {
        return "You wake up in a poorly lit room with nothing in your pockets."
            + " You see two doors, one to the left and one to the right. The"
            + " door on the left appears to be locked"
            + " What do you want to do?" + " type 'help' if you have "
            + "any questions";
    }
}
