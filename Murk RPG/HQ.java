//import necessary library
import java.util.Scanner;

//declare headquarters (gamebrain) class
public class HQ
{
    //declare and initialize constants: clear string of many line breaks to clear terminal window, scanner to read user input
    public final String c = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public final Scanner rS = new Scanner(System.in);
    
    //declare World type instance field variable
    private World world;

    //HQ constructor needs no parameters
    public HQ()
    {
        //intialize world instance field to a new World object
        world = new World();
    }

    public void run() { //method called upon by Main
        System.out.println(c + "~MURK~" + "\n"); //print game title to terminal window
        System.out.print("Type x to quit, type any other key to play Murk: "); //confirm with user
        if(!rS.next().equals("x")) { //if user does not enter "x", start game
            //invoke intro() on world object to play the intro
            if (world.intro()) { //if intro completed, go to next stage
                //invoke start() on world to start the actual game
                if(world.start()) { //if start (beginning of game) completed, drop user into world
                    world.play(); //invoke play on world to drop user into world
                }
            }
        }
        System.out.println("\nBye."); //once world.play() is complete, print bye to the terminal no matter what outcome
    }
}
