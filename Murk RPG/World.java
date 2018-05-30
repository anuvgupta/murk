//import necessary classes
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//declare World class
public class World
{
    //declare constants: clear string, satyr ASCII art, scanner to read user int input, scanner to read user String input, random object from which to derive random numbers
    public final String c = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public final String satyr = "    ((()))\n    | , ,|   ^\n    (  > |  /_\\\n    \\'--/    |\n    / ^^|    |\n   ;/  (|    |\n   |(  )|    |\n   ;| '||    |\n  / ( ,\\|__,-;.\n ,' \"\\,.'  ' -|\n,|...:\"\"---'--'\n/;::;;;;/    |\nY| ''':(     |\n\\( :. ) |    |\n  )  /'/     |\n /. / |      |\n( ,<| |      |\n \\_\\ \\_\\\n /_> /_\\";
    public final Scanner rI = new Scanner(System.in);
    public final Scanner rS = new Scanner(System.in);
    public final Random rand = new Random();

    //declare instance field variables
    private Cell[][] map; //declare two-dimensional array of Cells to represent map of world
    private final Cell boundary; //declare constant boundary Cell to represent any cell off the map
    private Player player; //declare Player variable
    private boolean pL; //declare boolean pL that decides whether game continues

    //World constructor needs no parameters; World is constructed by an instance of HQ
    public World()
    {
        boundary = new Cell(0, 0, "boundary", "Boundary"); //initialize boundary constant to a Cell with coordinates off the map and the type and name of boundary
        pL = true; //initialize pL to true so the game runs later
        //intialize 2D array of Cells with each cell containing coordinates, type, and name
        map = new Cell[][]{
            { new Cell(1, 1, "lake", "Lake of Moonshine"), new Cell(2, 1, "forest", "Murkwood Forest"), new Cell(3, 1, "village", "Wintergreen"), new Cell(4, 1, "field", "Enverglen Meadows"), new Cell(5, 1, "mountain", "Northwest Peak"), new Cell(6, 1, "mountain", "Northeast Peak") },
            { new Cell(1, 2, "forest", "Murkwood Forest"), new Cell(2, 2, "forest", "Murkwood Forest"), new Cell(3, 2, "field", "Enverglen Meadows"), new Cell(4, 2, "gardens", "Fallendor Northwest Gardens"), new Cell(5, 2, "mountain", "Southwest Peak"), new Cell(6, 2, "mountain", "Southeast Peak") },
            { new Cell(1, 3, "forest", "Murkwood Forest"), new Cell(2, 3, "forest", "Murkwood Forest"), new Cell(3, 3, "field", "Enverglen Meadows"), new Cell(4, 3, "palace", "Fallendor Palace"), new Cell(5, 3, "gardens", "Fallendor Southeast Gardens"), new Cell(6, 3, "beach", "Armorican Seaside") },
            { new Cell(1, 4, "forest", "Murkwood Forest"), new Cell(2, 4, "forest", "Murkwood Forest"), new Cell(3, 4, "village", "Everwood"), new Cell(4, 4, "field", "Enverglen Meadows"), new Cell(5, 4, "field", "Enverglen Meadows"), new Cell(6, 4, "beach", "Armorican Seaside") },
            { new Cell(1, 5, "field", "Enverglen Meadows"), new Cell(2, 5, "field", "Enverglen Meadows"), new Cell(3, 5, "field", "Enverglen Meadows"), new Cell(4, 5, "field", "Enverglen Meadows"), new Cell(5, 5, "village", "Glenfield"), new Cell(6, 5, "beach", "Armorican Seaside") },
            { new Cell(1, 6, "volcano", "Mount Shadow"), new Cell(2, 6, "village", "Blackbridge"), new Cell(3, 6, "beach", "Armorican Seaside"), new Cell(4, 6, "beach", "Armorican Seaside"), new Cell(5, 6, "beach", "Armorican Seaside"), new Cell(6, 6, "sea", "Vermillion Sea") },
        };
        player = new Player(); //initialize player to new player object
    }

    //this method is a utility that helps figure out if a string can be parsed to an int or double
    public static boolean isNumeric(String str) { //take in a String parameter
        //use a try catch so the terminal doesn't display the error
        try {
            //try to parse the string to a double
            double d = Double.parseDouble(str);
        }  
        catch(NumberFormatException nfe) {  
            //if an error is caught, it cannot be parsed, so return false (the string cannot be converted to a number)
            return false;  
        }
        //if the method reaches this point, no error was thrown, so return true (the string can be converted to a number)
        return true;  
    }

    //this method serves as an intro to retrieve the user's information; called by an instance of HQ
    public boolean intro() { //needs no parameters
        //cleac the terminal and print the introductory story
        System.out.print(c + "\n" +
            "         ____\n" +
            "        0    0\n" +
            "_______0______0_______\n" +
            "~~~~~~~~~~~~~~~~~~~~~~\n" +
            "Waking up, you see the sun rising.\n" +
            "What a pretty sunrise! You're drowsy, but below the sun, you can see meadows, fields,\n" +
            "forests, a volcano, and evem a shining silver palace in the background! Amazing.\n" +
            "The Moonstone Palace of Fallendor. \"I would love to be a Minstrel of the court there someday...\"\n" +
            "you fantasize as the horsedrawn carriage crawls slowly along the bumpy road to the LAND OF MURK.\n\n" +
            "\"Where do you hail from, my friend?\" asks the knight next to you.\n" +
            "In response, you say, \"I am (enter your name): ");
        //retrieve the player's name input with a scanner object and invoke setName on the player object to set its name property
        player.setName(rS.next());

        //ask for the player's origin
        System.out.print("and I hail from: ");
        //retrieve the player's origin input with a scanner object and invoke setOrigin on the player object to set its origin property
        player.setOrigin(rS.next());

        //continue the intro
        System.out.println("I'm a minstrel, a musician, but I do have some skill with a sword.\"\n\n" +
            "\"And I'm Hans of Irelong. Pleased to make your acquaintance, " + player.getName() + " of " + player.getOrigin() + ",\"\n" +
            " replies the friendly knight. You converse politely with the knight as you make your way to MURK.");

        //confirm continuing with user
        System.out.print("\n(Type any key to continue, x to quit)\nNext? ");
        //if the user enters x, return false so that HQ knows to quit; otherwise, return true so HQ continues
        if(rS.next().equals("x")) return false;
        else return true;
    }

    //an intermediate method for further introduction and confirmation; called by an instance of HQ
    public boolean start() {
        //clear the screen, continue the introduction, and confirm continuation
        System.out.print(c +
            "_._|_._._Y_._._Y_._|_._\n" +
            "You've arrived in a field. You bid the knight goodbye and\nlook out at the vast plains in front of you.\n\nGood Luck!\n" +
            "\n(Type any key to continue, x to quit)\nNext? ");

        //if the user enters x, return false so that HQ knows to quit; otherwise, return true so HQ continues
        if(rS.next().equals("x")) return false;
        else return true;
    }

    //the method that lets the user interact with the world; called by an instance of HQ
    public void play() {
        System.out.print(c); //clear screen
        while (pL) { //only run game loop while pL is true
            if (player.getHealth() <= 0) { //if player's health is less than or equal to 0, he is dead
                System.out.println("You have 0 health. Guess what that means: You died!\n\nGAME OVER."); //print that the user has died
                pL = false; //set pL to false to prevent continuation
                break; //leave the game loop
            }
            int cX = player.getX(); //declare and initialize an int for the player's current x position in the world
            int cY = player.getY(); //declare and initialize an int for the player's current y position in the world
            Cell currCell = getCell(cX, cY); //declare and initialize a reference to the Cell corresponding to the player's current position in the world
            //this block prints a quest-related map
            if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 3)) { //if the player is on the main quest and is at stage 3 of the quest, print the quest map
                for(int y = 1; y <= 6; y++) { //loop through y values of the map
                    for(int x = 1; x <= 6; x++) { //loop through x values of the map
                        //System.out.print("|(" + x + ", " + y + ")");
                        //if the cell in this loop is the same as the current cell of the player
                        if ((x == currCell.getX()) && (y == currCell.getY())) System.out.print("|*"); //print a wall and an asterisk to indicate the player's location on the map
                        else System.out.print("|"); //otherwise, just print a wall
                        if (getCell(x, y).getGem()) System.out.print("x"); //if the gem has been found in that cell, print an x
                        else if ((getCell(x, y).getCap() <= 0) || (!getCell(x, y).hasGem())) System.out.print("o"); //if a cell has run out of its resources (and the user still hasn't found a gem) or the cell is known to not have a gem, print an o
                        else System.out.print("_"); //if neither of those are true, the gem has not been found in the cell, so print an underscore
                    }
                    System.out.println("|"); //at the end of each row, print the ending wall to make the map look more complete
                }
                //print a legend for the map
                System.out.print("\n" +
                    "x - you found this gem\n" +
                    "o - there is no gem here\n" +
                    "_ - keep looking for the gem\n" +
                    "* - your location in Murk\n\n");
            }

            //print the player's current money, health, and location relative to the current cell and other cells nearby
            System.out.print("Money: " + player.getMoney() + "\nHealth: " + player.getHealth() + "\n\n" +
                "You are in a " + currCell.getType() + ". " + currCell.getName() + "\n\n" +
                "To the north there is a " + getCell(cX, cY - 1).getType() + ",\n" +
                "To the south there is a " + getCell(cX, cY + 1).getType() + ",\n" +
                "To the east there is a " + getCell(cX + 1, cY).getType() + ",\n" +
                "To the west there is a " + getCell(cX - 1, cY).getType() + ".\n" +
                "\n");
            //print some possible action options (changing position, manage inventory, check current quest)
            System.out.print("n. go north\n" +
                "s. go south\n" +
                "e. go east\n" +
                "w. go west\n" +
                "i. manage inventory\n" +
                "q. check quest\n");
            //if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 3)) System.out.println("m. view map");
            //invoke choose on the current cell to provide further cell related action options
            String com = currCell.choose(); //assign the returned action the the user chose to a newly declared String com
            String dir = "nesw"; //declare and initialize a String containing the allowed direction options
            System.out.println(c); //clear the screen
            if (com.equals("x")) { //if the user's command is x, or quit
                pL = false; //set the game loop boolean to false
                break; //break out of the game loop
            }
            /* 
             *THIS SECTION IS A CHEAT I BUILT IN FOR TESTING. IGNORE PLS*
            if (com.equals("c")) {
            for(int y = 1; y <= 6; y++) {
            for(int x = 1; x <= 6; x++) {
            getCell(x, y).setGem(true);
            }
            }
            }
             */
            else if (com.equals("i")) { //if the user's command is i, or manage inventory
                System.out.println(c); //clear the screen
                while(true) { //infinite loop
                    System.out.print("Money: " + player.getMoney() + "\nHealth: " + player.getHealth() + "\n\n"); //print the money and health of player
                    player.printInv(); //invoke printInv() on the player to print it's inventory
                    System.out.print("To use an item, type its number, or any other key to exit the inventory: "); //print options
                    String ans = rS.next(); //get the user input
                    System.out.println(c); //clear the screem
                    if (isNumeric(ans)) { //if the answer is numeric, it a is a valid command
                        int o = Integer.parseInt(ans) - 1; //convert the command to a number and subtract one from it for array purposes
                        if (o < player.getInvSize()) { //if the command is within the amount of items player has
                            String t = player.getItem(o).getType(); //get the type of that selected item
                            if (t.equals("fish") || t.equals("rabbit")) { //if the item is a type of food
                                player.changeHealth(player.getItem(o).getV2()); //feed the user that item by increasing his health by the item's health value (V2)
                                if(player.getItem(o).getV1() > 1) player.getItem(o).changeV1(-1); //if the user has multiple of that item, subtract one from it's amount count (V1)
                                else player.removeItem(o); //if the user has only one of that item, remove it from player's inventory entirely
                            }
                            else System.out.println("\nYou cannot use that item here.\n"); //if the item is not food, print that the user cannot use that item
                        }
                        else System.out.println("\nInvalid item number.\n"); //if the command inputted is not within the number of items the user has, then print the response
                    }
                    //if it is not a valid (numerical) command, the user wants to leave the inventory
                    else break; //break out of the infinite inventory loop
                }
            }
            else if (com.equals("q")) player.printQuest(); //if the user inputs q, he wants to view his current quest, so invoke printQuest() on player to print the current quest
            else if (dir.contains(com)) player.move(com); //if the command inputted is a direction, invoke move on player to change the player's position in the world
            else interact(currCell); //if the command was none of the above, the user chose to interact with the current cell, so call interact and pass in the current cell 
        }
    }

    //this method returns a cell from the map, if given coordinates
    public Cell getCell(int cX, int cY) { //declare method with int x and y coordinate parameters
        if ((cX > 6) || (cX < 1) || (cY > 6) || (cY < 1)) return boundary; //if the coordinates requested are out of the map size, return a boundary cell constant
        else return map[cY - 1][cX - 1]; //otherwise if the coordinates are valid, retrieve the requested cell from the map and return it
    }

    //this method checks if the gem quest is complete
    private boolean gemQuestComplete() { //needs no parameters
        for(int y = 1; y <= 6; y++) { //loop through the y of the map
            for(int x = 1; x <= 6; x++) { //loop through the x of the map
                //if the cell of the currently iterated x and y coordinates both has a gem in it and has not had its gem found
                if ((!getCell(x, y).getGem()) && (getCell(x, y).hasGem())) return false; //return false as that means not all possible gems have been found
            }
        }
        return true; //if the method reaches this point, all possible gems have been found, so return true
    }

    //this method is called when a gem is found
    private void gemQuest(Cell currCell) { //pass in the reference to the current cell to interact with
        currCell.setGem(true); //set the variable of the cell that determines whether its gem has been found to true
        if (player.has("gem")) player.getItem("gem").changeV1(1); //if the player already has at least one gem in his inventory, add to its amount property
        else player.addItem("Amount", 1, "", 0, "Mysterious Gem", "gem"); //otherwise, add a gem type Item object to the inventory by invoking addItem on player
        System.out.print("You found a mysterious gem! "); //print that the user found a gem
        if (player.getQN().equals("The Mysterious Gem")) { //if the useris on the main quest
            if (player.getQS() == 1) System.out.println("Go to a village tavern to find out what it is."); //and if the user is on stage one, he is told to visit a village for more info
            else if (player.getQS() == 2) System.out.println("Go to the palace to find out what it is."); //and if the user is on stage two, he is told to visit the palace for more info
            else if (player.getQS() == 3) { //and if the user is on stage three, he has been appointed to find all the gems
                if(gemQuestComplete()) { //if the gem quest is complete, user has found all the gems
                    System.out.println("You have found all the gems that you can! Go to the palace to return them.\n"); //tell the user to go to the palace
                    System.out.println(c + "Quest objective stage " + player.getQS() + " completed: " + player.getQL()); //clear and print that the user completed his last objective
                    player.changeQS(1); //increase the quest stage
                    player.setQL("Return to the King"); //set the quest level to the new objective
                    System.out.println("Quest objective stage " + player.getQS() + " added: " + player.getQL()); //print the new level and stage
                    System.out.print("\nType any key to continue: "); //confirm continuation
                    String g = rS.next(); //wait for a key to be entered
                }
                //otherwise, if the quest is incomplete
                else System.out.println("You have " + player.getItem("gem").getV1() + " gems. Collect more."); //print the amount of found gems and encourage the user ti find more
            }
            //error message in case the player finds a gem after completing the "finding" stage of the quest
            else System.out.println("That should not be happening, since you have already all that you can find.\n\nGame is glitching! Please restart.");
        }
        else { //if the user has not started the main quest
            System.out.println("Go to a village tavern to find out what it is."); //tell the user to go to a tavern for more info
            player.setQN("The Mysterious Gem"); //set the quest title
            player.setQL("Visit a village"); //set the quest objective level
            player.setQS(1); //set the quest stage number
            System.out.print("New "); //print new before
            player.printQuest(); //printing the current (new) quest
        }
    }

    //this method is used to let the player interact with the current cell
    public void interact (Cell currCell){ //pass in the reference to the current cell
        int r = rand.nextInt(10); //invoke nextInt() on the constant random object to get a new random int between 0 and 10
        if(currCell.getCap() <= 0) currCell.setGem(true); //if the cell's capacity, or amount of resources, has run out, then set it's "gem found" property to true so that it is counted as a completed cell
        //this next large condition block accounts for all the different types of cells and how to interact with them. Many are similar so comments may be sparse for later cell types
        if (currCell.getType().equals("forest")) { //if the current cell's type is a forest, the user wants to chop wood
            if(!player.has("axe")) System.out.println("You need an axe!"); //if the user does not have the requried item in his inventory, print it so
            else if(currCell.getCap() <= 0) System.out.println("There are no more trees in this forest!"); // if the capacity (resources) of the cell is at 0 or less, print it so
            else { //otherwise, the user can interact
                player.getItem("axe").changeV2(-1); //increase damage to (decrease health (V2 property) of) the tool used by one
                if((r >= 0) && (r <= player.getItem("axe").getV1())) { //if the random number is betweem 0 and the tool's strength
                    if (player.has("wood")) player.getItem("wood").changeV1(1); //if the player has the gainable item, add one to its amount count (V1)
                    else player.addItem("Amount", 1, "", 0, "Murkwood", "wood"); //if the player does not have that item, add it to his inventory
                    System.out.println("You chopped some Murkwood! You have " + player.getItem("wood").getV1() + " log(s)."); //print that the user has gained an item and print its amount count in his inventory
                    currCell.changeCap(-1); //decrease the capacity (resource count) of the cell by 1
                    if ((r <= 3) && (!currCell.getGem())) gemQuest(currCell); //if, by chance the random number is also within a certain low margin, call gemQuest() with the current cell as a parameter so that the user can gain a gem
                }
                else  { //if the random number is, by chance, not within the tool's strength
                    System.out.println("The trees refuse to fall! Swing that axe again, or buy a better one."); //print that the interaction failed
                }
                if (player.getItem("axe").getV2() == 0) { //if, after the interaction, the tool has no more health left
                    System.out.println("By the way, your axe is now broken!\nIt has been used to the most. Get a new one."); //print it so
                    player.removeItem("axe"); //remove the item from the player's inventory
                }
            }
        }
        //the field type cell interaction is identical to the forest type cell interaction, so no comments are needed
        else if (currCell.getType().equals("field")) { //if the current cell's type is a field, the user wants to hunt rabbits
            if(!player.has("bow")) System.out.println("You need a bow!");
            else if(currCell.getCap() <= 0) System.out.println("There are no more rabbits in this field!");
            else {
                player.getItem("bow").changeV2(-1);
                if((r >= 0) && (r <= player.getItem("bow").getV1())) {
                    if (player.has("rabbit")) player.getItem("rabbit").changeV1(1);
                    else player.addItem("Amount", 1, "Health Value", 5, "Enverglen Rabbit", "rabbit");
                    System.out.println("You caught a rabbit! You have " + player.getItem("rabbit").getV1() + " rabbit(s).");
                    currCell.changeCap(-1);
                    if ((r <= 2) && (!currCell.getGem())) gemQuest(currCell);
                }
                else  {
                    System.out.println("The rabbits refuse to die! Shoot those arrows again, or buy a better bow.");
                }
                if (player.getItem("bow").getV2() == 0) {
                    System.out.println("By the way, your bow is now broken and you are out of arrows!\nThey have been used to the most. Get new ones.");
                    player.removeItem("bow");
                }
            }
        }
        else if (currCell.getType().equals("volcano")) { //the volcano cell is a suicide option
            //print volcano ASCII art
            System.out.print("" +
                "    ____* <--- you \n" +
                "   /     \\ \n" +
                "  /       \\ \n" +
                "_/_________\\_\n");
            //print dramatic suicidal thoughts
            System.out.print("You contemplate life as you look at the magma below.\n" +
                "\"Is this life really worth it?\" you think.\n" +
                "\"Will I ever make it as a minstrel, or will I be forced\n" +
                "to go back to my father's lobster farm up north?\"\n\n" +
                "(y for yes, any other key for no)\nYou begin to cry. Will you jump? ");
            //ask the user if they want to die
            String a = rS.next(); //collect user input with a scanner
            if(a.equals("y")) { //if user input is y, they want to die
                //clear screen and print dramatic suicide
                System.out.println(c + "The tears stream down your face as you fall into the wind\n" +
                    "and become one with the fire. " + player.getName() + ", the minstrel of " + player.getOrigin() + " is no more.\n\n" + 
                    "THE END");
                pL = false; //set the game loop variable to false so the game ends
            }
            else {
                //clear screen and print uplifting change of thoughts
                System.out.println(c + "It's not over! You wipe the tears off your cheeks as you remember\n" +
                    "all the wonderful memories of the land of Murk. I shall live to see another day!");
            }
        }
        //the mountain type cell interaction is similar to the forest type cell interaction, so minimal comments are needed 
        else if (currCell.getType().equals("mountain")) { //if the current cell's type is a mountain, the user wants to climb peaks
            if(!player.has("rope")) System.out.println("You need a rope!");
            else if(currCell.getCap() <= 0) System.out.println("There are no more peaks on this part of the mountain left to climb!");
            else {
                player.getItem("rope").changeV2(-1);
                if((r >= 0) && (r <= player.getItem("rope").getV1())) {
                    player.changeStamina(5); //instead of adding an item after success, increase user's stamina
                    System.out.println("The brisk mountain air and vigorous climbing has increased your total stamina.\nStamina: " + player.getStamina());
                    currCell.changeCap(-1);
                    if ((r <= 3) && (!currCell.getGem())) gemQuest(currCell);
                }
                else  {
                    System.out.println("You fell off a cliff and your health has gone down! Try climbing again, or buy a better rope.");
                    player.changeHealth(-5);
                }
                if (player.getItem("rope").getV2() == 0) {
                    System.out.println("By the way, your rope has just snapped!\nIt has been used to the most. Get a new one.");
                    player.removeItem("rope");
                }
            }
        }
        else if (currCell.getType().equals("gardens")){ //if the cell type is gardens: this is a big break from the typical cell interaction into quest interaction
            //if the user is not at the correct stage in the main questline, print that the gardens are locked
            if ((player.getQN().equals("")) || ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() < 3))) System.out.println("The garden gates are locked.");
            //if the user is at the right stage...
            else if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 3)) {
                System.out.println(satyr); //print an ASCII satyr
                //print story info and instructions for the Song Game - a guitar hero type game
                System.out.println("\n\nOh no! Satyrs (Half human, half goat beasts) are chasing you!\n" +
                    "Whatever shall you do? You must play music to satiate the satyrs!\n\n" +
                    "How to play:\n" +
                    "The controls are ASDF. You see your harp vertically, and the\n" +
                    "lines are the strings on the harp. When an '0' reaches the bottom\n" +
                    "of your string, press the corresponding key (ASDF correspond to the strings).\n"+
                    "You must play 25 notes. If you miss a note, you may still calm the satyrs.\n" +
                    "However, if you play more than 5 extra notes out of turn, they attack you!\n" +
                    "(Side note: your stamina determines how fast you must play!)\n\n" +
                    "Type any key to continue: ");
                String g = rS.next(); //get user input

                //invoke prepGame() from the SongGame class to prepare the song game:
                //prepare the song game by calculating the length of the harp strings (how many upcoming notes the player can see)
                //and the speed of the song game both based on the user's stamina
                SongGame.prepGame(8 + ((int) (player.getStamina() / 30)), 0.5 + ((int) (player.getStamina() / 200)));
                SongGame.play(); //call the static method play from the SongGame class to begin the song game

                //this loop checks every 1.5 seconds to see if the song game is running
                while(SongGame.state == 0) { //SongGame.state ==  0 represents that the song game is running
                    System.out.println("Game in progress."); //print that the game is still in progress
                    try { //try/catch around Thread.sleep() for safety reasons
                        Thread.sleep(1500); //invoke the static sleep() from the Thread class to pause the thread for 1500 milliseconds (1.5 seconds)
                    }
                    catch (Exception e) { //if an error is thrown, catch it
                        System.out.println("Cannot sleep: " + e.getMessage()); //and print the error
                        break; //breal from the checking loop.
                    }
                }

                //the song game's state variable has changed, meaning the game has ended
                System.out.println(c); //clear the terminal window
                switch (SongGame.state) { //switch statement to check the song game's ending state
                    case 1: //state 1 means the user played too many incorrect notes and lost all 5 lives
                    {
                        player.changeHealth(-15); //reduce the player's health by 15
                        System.out.println("You Lost! You played too many random notes, and now the Satyrs have eaten you!" +
                            "Your health has gone down by 15." +
                            "Health: " + player.getHealth());
                        //print the info and the new health to the user
                        break; //break out of the case
                    }
                    case 2: //state 2 means the user got 25 notes correct missin none, and therefore won the song game
                    {
                        //print the info and confirm continuation
                        System.out.println("You Won! The satyrs have gone to sleep. You can enter the gardens safely.\nType any key to continue.");
                        String a1 = rS.next(); //wait for user input
                        gemQuest(currCell); //call gemQuest() to add a gem to the player's inventory
                        break; //break out of the case
                    }
                    case 3: //state 3 means the user did not lose all lives (by playing incorrect notes) but may have missed some notes
                    {
                        //print the info
                        System.out.println("You missed " + (25 - SongGame.score) + " notes!\nYou may still have a chance, based on your stamina and the amount of notes you got right...");
                        //get a random number betweeo 0 and 100
                        int a = rand.nextInt(100);
                        //the plsyer's chances are: their stamina + their score (total amount of correct notes) in the game
                        int b = player.getStamina() + SongGame.score;
                        if (a < b) { //if the random number is within the player's chances
                            //print the good news and confirm continuation
                            System.out.println("You Won! The satyrs have gone to sleep. You can enter the gardens safely.\nType any key to continue.");
                            //wait for user input
                            String a1 = rS.next();
                            //add a gem to the player's inventory by calling gemQuest()
                            gemQuest(currCell);
                        }
                        else { //if the random number is not within the player's chances
                            player.changeHealth(-15); //reduce their health by 15
                            System.out.println("You Lost! You played too many random notes, and now the Satyrs have eaten you!" +
                                "Your health has gone down by 15." +
                                "Health: " + player.getHealth());
                            //print the bad news
                        }
                        break; //break out of the case
                    } //end of switch
                    //return to end of play() method
                }
            }
            //if the player has completed the main quest or has beaten the satyrs in the current garden cell
            else if (((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 4)) || ((currCell.getGem()) && (player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 3))) {
                System.out.println(satyr); //print an ASCII satyr
                //print the respect of the satyrs
                System.out.println("\n\nThe satyrs bow their heads and dance in joy at the sight of " + player.getName() + ", the magical minstrel.\n\n");
            }
        }
        else if (currCell.getType().equals("palace")) { //if the current cell type is the palace, there will be more quest interactions
            //if the user is not at the correct stage in the main questline, print that the palace gates are locked
            if ((player.getQN().equals("")) || ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() < 2))) System.out.println("The palace gates are locked.");
            //if the user is at the correct stage...
            else if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 2)) {
                //questline dialogue with king
                System.out.print("You approach the palace facade. The guards, seeing your gems, open the gates for you.\n" +
                    "You walk up a shiny white staircase cloaked in purple and gold velvet.\nSuddenly you are blinded by a flash of light!\n" +
                    "It is the legendary King of Murk's crown, shimmering in all it's glory.\nType any key to continue: ");
                String g = rS.next(); //wait for user input
                //more dialogue
                System.out.print(c + "You approach the King.\n" +
                    player.getName() + ": Your majesty, I have found these precious gems, and I thought you might know of their origin.\n" +
                    "King: You dare speak to me?!\n" +
                    player.getName() + ": Um. My sincerest apologies?\n" +
                    "     ...\n     ...\n" +
                    "King: HA HA HA I love the expression on little men's faces when they see my wrath.\n" +
                    "     Oh, my child, I'm only being facetious. I'm so funny. Ha ha. Ahem. Anyway...\n" +
                    player.getName() + ": The gems.\n\n");
                System.out.print("Type any key to continue: ");
                g = rS.next(); //wait for user input
                //moooorreeee dialogue
                System.out.print("\n\n" +
                    "King: Ah yes, young traveler. As you can see, my crown is beautiful, but the purple gems are missing.\n" +
                    "     And you seem to have one. In my last battle for Murk, these mysterious purple gems of murk were scattered across the land.\n" +
                    "     You have some, but the rest may be hard to find. Try and visit every part of Murk, and collect as many gems as you can.\n" +
                    "     Here is a map. And do not fear, I will reward you. Because I am benevolent. HA HA HA I'm so great. HA HA HA HA Ha ha ha ha......\n" +
                    "You hear the King's laughter boom through the halls as you sprint out of the palace, trying not to trip over the king's ego.\n\n"+
                    "Type any key to continue: ");
                g = rS.next(); //wait for user input
                //quest update
                System.out.println(c + "Quest objective stage " + player.getQS() + " completed: " + player.getQL());
                player.changeQS(1);
                player.setQL("Find the gems");
                System.out.println("Quest objective stage " + player.getQS() + " added: " + player.getQL());
                System.out.print("\nType any key to continue: ");
                g = rS.next(); //wait for user input
                //essentially, the user advances to the next stage in the main questline, has a map available to him, and must find all the mysterious gems
            }
            else if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 3)) { //if the user is at the gem-finding stage
                //print the guards' respect
                System.out.print("The guards bow their heads as " + player.getName() + ", the king's gem-finder, walks up the shiny marble steps.\n" +
                    "King: HAH HAH HA HA HA HA Ha ha ha ha hA HA HA HAH HA HHAAA HA...\n" +
                    "You nearly trip over the purple carpet as you whip around and sprint back outside.\n\n" +
                    "Type any key to continue: ");
                String g = rS.next(); //wait for user input
            }
            else if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 4)) { //if the user is at the stage in which he has all the gems
                //print the dialogue of success
                System.out.println("King: HA HA HA! You have all the gems? Wonderful!\nThank you, my son! Now be on your way.\n" +
                    player.getName() + ": But...\n" +
                    "King: Ah yes. Here are 1000 coins. Go buy all the Murky Ale and Blackbridge Wine you want.\n" +
                    "      Also, enjoy your new position as minstrel of my court!\n" +
                    "(\"Yes!\", you think. \"Life is finally getting good!\")\n" +
                    "King: HA HA HA! You can play to the sweet sounds of my laughter!\n" +
                    player.getName() + ": I cry every time. Although there is still the volcano.....no. I accept!\n");
                //confirm continuation
                System.out.print("\nType any key to continue: ");
                String g = rS.next(); //wait for user input
                //quest update
                System.out.println(c + "Quest objective stage " + player.getQS() + " completed: " + player.getQL());
                player.changeQS(1);
                player.setQL("Quest complete!");
                System.out.println("Quest objective stage " + player.getQS() + " added: " + player.getQL());
                System.out.print("\nType any key to continue: "); //confirm continuation
                g = rS.next(); //wait for user input
                System.out.println(c + "You win!\n\n THE END."); //print success, the end
                pL = false; //set pL to false so the game loop stops
            }
            //unnecessary case in which there are other quests in the game and whenever the user visits the palace he is called a minstrel of the court
            else if ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() == 5)) {
                System.out.println("Minstrel of the Court!");
            }
        }
        //the beach type cell interaction is identical to the forest type cell interaction, so no comments are needed
        else if (currCell.getType().equals("beach")){ //if the current cell's type is a beach, the user wants to dig for shells
            if(!player.has("shovel")) System.out.println("You need a shovel!");
            else if(currCell.getCap() <= 0) System.out.println("There are no more shells on this part of the beach!");
            else {
                player.getItem("shovel").changeV2(-1);
                if((r >= 0) && (r <= player.getItem("shovel").getV1())) {
                    if (player.has("shells")) player.getItem("shells").changeV1(1);
                    else player.addItem("Amount", 1, "", 0, "Silver Shells", "shells");
                    System.out.println("You dug up some Silver Shells! You have " + player.getItem("shells").getV1() + " shell(s).");
                    currCell.changeCap(-1);
                    if ((r <= 2) && (!currCell.getGem())) gemQuest(currCell);
                }
                else  {
                    System.out.println("The shells refuse to reveal themselves! Thrust that shovel again, or buy a better one.");
                }
                if (player.getItem("shovel").getV2() == 0) {
                    System.out.println("By the way, your shovel is now rusted!\nIt has been used to the most. Get a new one.");
                    player.removeItem("shovel");
                }
            }
        }
        //the sea type cell interaction is identical to the forest type cell interaction, so no comments are needed
        else if (currCell.getType().equals("sea")) { //if the current cell's type is a sea, the user wants to fish for angelfish
            if(!player.has("fishing pole")) System.out.println("You need a fishing pole!");
            else if(currCell.getCap() <= 0) System.out.println("There are no more fish in this sea!");
            else {
                player.getItem("fishing pole").changeV2(-1);
                if((r >= 0) && (r <= player.getItem("fishing pole").getV1())) {
                    if (player.has("fish")) player.getItem("fish").changeV1(1);
                    else player.addItem("Amount", 1, "Health Value", 10, "Angelfish", "fish");
                    System.out.println("You caught some Angelfish! You have " + player.getItem("fish").getV1() + " fish.");
                    currCell.changeCap(-1);
                    if ((r <= 1) && (!currCell.getGem())) gemQuest(currCell);
                }
                else  {
                    System.out.println("The fish refuse to bite! Drop that line again, or buy some new bait.");
                }
                if (player.getItem("fishing pole").getV2() == 0) {
                    System.out.println("By the way, your fishing pole is about to break!\nIt has been used to the most. Get a new one.");
                    player.removeItem("fishing pole");
                }
            }
        }
        //the lake type cell interaction is similar to the mountain type cell interaction, so minimal comments are needed
        else if (currCell.getType().equals("lake")) { //if the current cell's type is a lake, the user wants to swim
            //no tool is needed to swim in the lake, making it the ideal first place for the player to start, whic is exactly why the user does not start there :D
            if(currCell.getCap() <= 0) System.out.println("You've explored every part of the lake!");
            else {
                if((r >= 0) && (r <= 7)) {
                    player.changeStamina(5); //stamina increased, just like on a mountain
                    System.out.println("The cool water and vigorous swimming has increased your total stamina.\nStamina: " + player.getStamina());
                    currCell.changeCap(-1);
                    if ((r <= 2) && (!currCell.getGem())) gemQuest(currCell);
                }
                else  {
                    System.out.println("You almost drowned and your health has gone down! Try swimming again, or buy better lungs.");
                    player.changeHealth(-5);
                }
            }
        }
        else if (currCell.getType().equals("village")) { //if the current cell type is village, the user wants to enter the village
            System.out.println(c); //clear the screen
            while (true) { //infinite village loop
                //print village options
                System.out.println("You are in the village of " + currCell.getName());
                System.out.print("\nOptions:\n" +
                    "s - go to the store\n" +
                    "t - go to the tavern\n" +
                    "any other key - exit the village\n\n" +
                    "What will you do? ");
                String ans = rS.next(); //get user input
                System.out.println(c); //clear the screem
                if (ans.equals("s")) { //if user chose s, go to store
                    while (true) { //infinite store loop
                        System.out.println(currCell.getName() + " Store\n"); //print the store name
                        System.out.print("Money: " + player.getMoney()); //print the player's money
                        //print store options
                        System.out.print("\nOptions:\n" +
                            "b - buy items\n" +
                            "s - sell items\n" +
                            "any other key - exit the store\n\n" +
                            "What would you like to do: ");
                        String ans2 = rS.next(); //get user input
                        System.out.println(c); //clear screen
                        if (ans2.equals("b")) { //if user chose b to buy items
                            boolean b = true; //boolean b represents the buy loop's continuation
                            while(b) { //run while b is true
                                System.out.println(c); //clear screen
                                player.printInv(); //print player's inventory
                                System.out.println("Money: " + player.getMoney()); //print player's money
                                //print buy item options
                                System.out.println("\n" +
                                    "1. axe - 10\n" +
                                    "2. rope - 10\n" +
                                    "3. bow and arrows - 10\n" +
                                    "4. shovel - 10\n" +
                                    "5. fishing pole - 10\n" + 
                                    "What would you like to buy? (Type the number or any other key to quit): ");
                                String ans3s = rS.next(); //get iser input
                                if(isNumeric(ans3s)) { //if input is numeric, user wants to buy
                                    int ans3 = Integer.parseInt(ans3s); //convert input to number
                                    if ((ans3 > 0) && (ans3 < 6)) { //if number is valid, go to money condition
                                        if(player.getMoney() < 10) System.out.println("You do not have enough money to buy that item!"); //if user hass less than 10 coins, print it so
                                        else { //otherwise go to buy switch statement
                                            switch (ans3) { //switch based on user choice
                                                case 1: //1 - add axe
                                                {
                                                    player.addItem("Strength", 5, "Health", 4, "Woodsman's Axe", "axe");
                                                    break;
                                                }
                                                case 2: //2 - add rope
                                                {
                                                    player.addItem("Strength", 6, "Health", 5, "Climber's Rope", "rope");
                                                    break;
                                                }
                                                case 3: //3 - add bow
                                                {
                                                    player.addItem("Strength", 7, "Health", 6, "Hunter's Bow", "bow");
                                                    break;
                                                }
                                                case 4: //4 - add shovel
                                                {
                                                    player.addItem("Strength", 6, "Health", 4, "Gravedigger's Shovel", "shovel");
                                                    break;
                                                }
                                                case 5: //5 - add fishing pole
                                                {
                                                    player.addItem("Strength", 5, "Health", 7, "Fishing Pole", "fishing pole");
                                                    break;
                                                }
                                                default: //default case for glitches
                                                {
                                                    b = false; //end buy loop by falsifying b boolean variable
                                                    break;
                                                }
                                            }
                                            player.changeMoney(-10); //reduce player's money by 10
                                        }
                                    }
                                    else break; //if number input is invalid, assume player wants to quit buy loop
                                }
                                else break; //if input is not numerical, assume player wants to quit buy loop
                            }
                        }
                        else if (ans2.equals("s")) { //if player chooses to sell
                            while(true) { //infinite sell loop
                                System.out.println("\n\nMoney: " + player.getMoney()); //print player's money
                                player.printInv(); //print player's inventory
                                //print choices
                                System.out.print("\nAll items can be sold for 6 coins.\nWhich one would you like to sell? (Type the number or any other key to leave): ");
                                String ans3s = rS.next(); //get user input
                                System.out.println(c); //clear terminal window
                                if(isNumeric(ans3s)) { //if user input is numeric, they want to buy
                                    int ans3 = Integer.parseInt(ans3s); //convert input to int
                                    if ((ans3 > 0) && (ans3 <= player.getInvSize())) { //if input is within bounds of inventory (total amount of items), it is valid
                                        if (player.getItem(ans3 - 1).getQuest()) System.out.println("\n\nYou cannot sell a quest item."); //if item is quest-related item, refuse sale
                                        else { //if item is not quest-related item
                                            //if item is countable and player has more that one of item, subtract one from item amount count
                                            if (player.getItem(ans3 - 1).getV1n().equals("Amount") && (player.getItem(ans3 - 1).getV1() > 1)) player.getItem(ans3 - 1).changeV1(-1);
                                            else player.removeItem(ans3 - 1); //if item is not countable and/or player has only one, remove item from inventory
                                            player.changeMoney(6); //add 6 coins to player's money
                                        }
                                    } else break; //if input is not within bounds of inventory, assume user wants to quit sell loop
                                }
                                else break; //if input is not numerical, assume user wants to quit sell loop
                            }
                        }
                        else break; //if user enters invalid command, assume user wants to quit store loop
                        //System.out.println(c);
                    }
                }
                else if (ans.equals("t")) { //if user wants to visit tavern
                    while (true) { //infinite tavern loop
                        System.out.println("\n" + currCell.getName() + " Tavern\n"); //print tavern name
                        //print choices
                        System.out.print("t - talk to the bartender\n" +
                            "b - buy a drink\n" +
                            "any other key - exit the tavern\n\n" +
                            "What would you like to do? ");
                        String s = rS.next(); //get user input
                        System.out.println(c); //clear screen
                        if (s.equals("t")) { //if user chooses to talk to bartender
                            //if user is not at correct stage, print that bartender is busy
                            if ((player.getQN().equals("")) || ((player.getQN().equals("The Mysterious Gem")) && (player.getQS() > 1))) System.out.println("The bartender is busy.");
                            //if user is at correct stage...
                            else {
                                //quest-related dialogue
                                System.out.print("\n\n" +
                                    "Bartender: How are you, traveler? You look weary. Would you like a drink on the house?\n" +
                                    player.getName() + ": Yes, thank you. Look at this gem I found! Any idea what it is?\n" +
                                    "Bartender: Wow. It looks very valuable. I would take it to the king, he might reward you!\n" +
                                    player.getName() + ": I will, and thank you, my friend. I shall go.\n" +
                                    "Bartender: You're welcome, my friend. Make haste, for bandits guard the roads.\n\nGood Luck!\n" +
                                    "Bid goodbye and leave (type any key): ");
                                String f = rS.next(); //get user input
                                //quest update
                                System.out.println(c + "Quest objective stage " + player.getQS() + " completed: " + player.getQL());
                                player.changeQS(1);
                                player.setQL("Visit the palace");
                                System.out.println("Quest objective stage " + player.getQS() + " added: " + player.getQL());
                                System.out.print("\nType any key to continue: "); //confirm continuation
                                f = rS.next(); //wait for user input
                                System.out.println(c); //clear screen
                            }
                        }
                        else if (s.equals("b")) { //if user chooses to buy a drink
                            while (true) { //infinite drink loop
                                System.out.print("Money: " + player.getMoney() + "\nHealth: " + player.getHealth()); //print money and health of player
                                //prit drink options
                                System.out.print("\n\nDrinks:\n" +
                                    "a. Murky Ale - 5 coins, +5 Health\n" +
                                    "b. " + currCell.getName() + " Wine - 10 coins, +10 Health\n" +
                                    "c. or any other key to leave\n\n" +
                                    "What will you have? ");
                                String ans1 = rS.next(); //get user input
                                System.out.println(c); //clear screen
                                if (ans1.equals("a")) { //if user chooses Murky Ale
                                    //if user does not have enough money, print it so
                                    if(player.getMoney() < 10) System.out.println("You do not have enough money to buy that item!");
                                    else {
                                        //subtract the correct charge and add the correct health
                                        player.changeMoney(-5);
                                        player.changeHealth(5);
                                    }
                                }
                                else if (ans1.equals("b")) { //if user chooses the regional wine
                                    //if user does not have enough money, print it so
                                    if(player.getMoney() < 10) System.out.println("You do not have enough money to buy that item!");
                                    else {
                                        //subtract the correct charge and add the correct health
                                        player.changeMoney(-10);
                                        player.changeHealth(10);
                                    }
                                }
                                else break; //if the user did not enter a valid command, assume he wants to quit the drink loop
                            }
                        }
                        else break; //if the user did not enter a valid command, assume he wants to quit the tavern loop
                    }
                }
                else break; //if the user did not enter a valid command, assumer he wants to quit the village loop
                System.out.println(c); //clear the screen
            }
        }
        else { //if the user is in a cell of any other type (glitch)
            //print the error message
            System.out.println("Unknown cell! Leave or start the game over.");
        }
        System.out.println(); //print a black line at the end of this method
    }
}

