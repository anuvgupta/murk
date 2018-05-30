//import necessary classes
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

//declare class Cell
public class Cell
{
    //declare constants for clear screen, integer input, scanner input, and random number generator
    public final String c = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public final Scanner rI = new Scanner(System.in);
    public final Scanner rS = new Scanner(System.in);
    public final Random rand = new Random();

    //declare instance field variables
    private int x, y; //x and y are coordinated defining the cell's position
    private String t, n; //t is cell type, n is cell name
    private ArrayList<String> actions; //actions is the list of possible actions (only one used but others could be used as well in future versions of this game)
    private boolean gem; //boolean that defines whether user has take gem from this cell or not
    private boolean hasG; //boolean that defines whether this cell has a gem in it or not
    private int capacity; //int that represents the amount of resources in the cell

    //constructor takes in x, y, type, and name parameter variables
    public Cell(int x, int y, String t, String n) {
        //initialize the instance fields
        this.x = x;
        this.y = y;
        this.t = t;
        this.n = n;
        capacity = 10; //all cells have 10 levels of natural resources
        hasG = true; //default evry cell to having a gem

        actions = new ArrayList<String>();
        gem = false; //all cells start off with an unfound gem

        //add a different action for every type of cell
        if (t.equals("forest")) {
            actions.add("Chop down some trees");
        }
        else if (t.equals("field")) {
            actions.add("Hunt in the fields");
        }
        else if (t.equals("volcano")) {
            actions.add("Jump into the magma below...");
            hasG = false; //volcanoes have no gems
        }
        else if (t.equals("mountain")) {
            actions.add("Climb the mountain");
        }
        else if (t.equals("gardens")){
            actions.add("Explore the gardens");
        }
        else if (t.equals("beach")){
            actions.add("Look for shells");
        }
        else if (t.equals("palace")) {
            actions.add("Enter the palace");
            hasG = false; //the palace has no gem
        }
        else if (t.equals("sea")) {
            actions.add("Fish for some angelfish");
        }
        else if (t.equals("lake")) {
            actions.add("Swim in the lake");
        }
        else if (t.equals("village")) {
            actions.add("Enter village of " + n);
            hasG = false; //villages have no gems
        }
    }

    //basic methods for retrieving and changing the instance fields
    public boolean hasGem() {
        return hasG;
    }

    public String getType() {
        return t;
    }

    public String getName() {
        return n;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void changeCap(int x) {
        capacity += x;
    }

    public int getCap() {
        return capacity;
    }

    public boolean getGem() {
        return gem;
    }

    public void setGem(boolean s) {
        gem = s;
    }

    //method called upon by a World object to get user input with cell action options included
    public String choose() {
        String numAnswers = "", chAnswers = "xmciqnsew", com = ""; //possible numbered answers, possible character answers, input command variable
        for(int i = 1; i < actions.size() + 1; i++) { //loop through actions ArrayList
            System.out.println(i + ". " + actions.get(i - 1)); //print each action
            numAnswers = numAnswers + i; //add each number to the possible numbered answers string
        }
        System.out.println("x. quit"); //print quit option

        while(true) { //infinite ask loop
            System.out.print("\nWhat would you like to do? "); //ask for input
            com = rS.next(); //get user input
            //if input is valid, break asking loop
            if ((com.length() == 1) && ((numAnswers.contains(com)) || (chAnswers.contains(com)))) break;
            else System.out.println("Invalid command!"); //if input is invalid, print it so
        }
        return com; //if method reaches this point, input is valid, so return the input to whatever called this method (usually a World object)
    }
}

/*
public int getContents() {
if (t.equals("forest")) return forest;
else if (t.equals("field")) return field;
else if (t.equals("volcano")) return volcano;
else if (t.equals("mountain")) return mountain;
else if (t.equals("village")) return village;
else if (t.equals("gardens")) return gardens;
else if (t.equals("beach")) return beach;
else if (t.equals("palace")) return palace;
else if (t.equals("sea")) return sea;
else if (t.equals("lake")) return lake;
}
 */
