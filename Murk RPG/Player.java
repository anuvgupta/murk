//import neccessary class
import java.util.ArrayList;

//declare class Player
public class Player
{
    //declare constant for clearing screen
    public final String c = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    //declare instance field variables
    private int health; //player health
    private int stamina; //player stamina
    private int money; //player money in coins
    private int x; //player position by x coordinate
    private int y; //player position by y coordinate
    private ArrayList<Item> i; //ArrayList of player's items (inventory)
    private String n; //player name
    private String o; //player origin
    private String q; //player's current quest's name
    private String qL; //player's current quest level objective
    private int qS; //player's current quest stage

    //constructor for player needs no parameters
    public Player()
    {
        //set instance fields
        health = 50;
        stamina = 50;
        money = 50;
        x = 1; //start player off
        y = 5; //in a meadow
        i = new ArrayList<Item>();
        n = "";
        o = "";
        q = ""; //no initial quest
        qL = "";
        qS = 0;
    }

    //methods for retrieving and changing instance field variables
    public int getHealth() {
        return health;
    }
    
    public int getStamina() {
        return stamina;
    }

    public int getMoney() {
        return money;
    }

    public String getQN() {
        return q;
    }

    public String getQL() {
        return qL;
    }
    
    public int getQS() {
        return qS;
    }
    
    public void setQN(String q) {
        this.q = q;
    }

    public void setQL(String q) {
        qL = q;
    }
    
    public void setQS(int q) {
        qS = q;
    }
    
    public void changeQS(int q) {
        qS += q;
    }

    //method that prints the current quest
    public void printQuest() {
        //if player has no quests, say so
        if (q.equals("")) System.out.println("You have no quests.");
        //if user has a quest, print all it's info
        else System.out.println("Quest: " + q + " - " + qL + " (Stage " + qS + ")");
        System.out.println(); //print a blank line
    }

    public void setHealth(int h) {
        health = h;
    }
    
    public void setStamina(int s) {
        stamina = s;
    }

    public void setMoney(int m) {
        money = m;
    }

    public void changeHealth(int h) {
        health += h;
    }
    
    public void changeStamina(int s) {
        stamina += s;
    }

    public void changeMoney(int m) {
        money += m;
    }

    //remove item by type (removes all items of type)
    public void removeItem(String t) {
        for (int o = 0; o < i.size(); o++) if(i.get(o).getType().equals(t)) i.remove(o);
    }
    
    //remove item by index in inventory
    public void removeItem(int o) {
        i.remove(o);
    }
    
    //add item to inventory
    public void addItem(String v1n, int v1, String v2n, int v2, String n, String t) {
        if (v2n.equals("") && (v2 == 0)) i.add(new Item(v1n, v1, n, t));
        else i.add(new Item(v1n, v1, v2n, v2, n, t));
    }

    //get item by type
    public Item getItem(String t) {
        for (int o = 0; o < i.size(); o++) if(i.get(o).getType().equals(t)) return i.get(o);
        return null;
    }
    
    //get item by index in inventory
    public Item getItem(int o) {
        return i.get(o);
    }

    public String getName() {
        return n;
    }

    public void setName(String newN) {
        n = newN;
    }

    public String getOrigin() {
        return o;
    }

    public void setOrigin(String newO) {
        o = newO;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int nX) {
        x = nX;
    }

    public void setY(int nY) {
        x = nY;
    }

    public void changeX(int nX) {
        x += nX;
    }

    public void changeY(int nY) {
        y += nY;
    }

    public int getInvSize() {
        return i.size();
    }
    
    //print player inventory
    public void printInv() {
        if(i.size() > 0) { //if player has items
            System.out.println("Your inventory:"); //print inventory title
            for (int o = 0; o < i.size(); o++) { //loop through inventory arraylist and print each item and its effects
                System.out.print((o + 1) + ". " + i.get(o).getName() + " (" + i.get(o).getType() + ") - " + i.get(o).getV1n() + ": " + i.get(o).getV1());
                if(!(i.get(o).getV2n().equals("null"))) System.out.println(", " + i.get(o).getV2n() + ": " + i.get(o).getV2());
                else System.out.println();
            }
        }
        else System.out.println("You have no items."); //if player has no items, say so
        System.out.println(); //print blank space
    }

    //moves player in world
    public void move(String d) {
        //changes player coordinates based on given direction
        if ((d.equals("n")) && ((y - 1) >= 1)) changeY(-1);
        else if ((d.equals("s")) && ((y + 1) <= 6)) changeY(1);
        else if ((d.equals("w")) && ((x - 1) >= 1)) changeX(-1);
        else if ((d.equals("e")) && ((x + 1) <= 6)) changeX(1);
        else System.out.println("You cannot cross a boundary of MURK!\n"); //does not let player cross boundaries
    }

    //checks if player has item (by type)
    public boolean has(String it) {
        for (int x = 0; x < i.size(); x++) if (i.get(x).getType().equals(it)) return true;
        return false;
    }
}
