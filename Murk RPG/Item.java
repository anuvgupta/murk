//declare constructor for Item
public class Item
{
    //declare instance fields
    private String v1n; //name of first effect/property
    private int v1; //value of first effect/property
    private String v2n; //name of second effect/property
    private int v2; //value of second effect/property
    private String n; //name of item
    private String t; //type of item
    private boolean quest; //boolean defining if item is quest-related
    
    //constructor for items with one property/effect
    public Item(String v1n, int v1, String n, String t)
    {
        //initialize instance fields
        this.v1n = v1n;
        this.v2n = "null";
        this.v1 = v1;
        this.v2 = 0;
        this.n = n;
        this.t = t;
        quest = t.equals("gem");
    }
    
    //constructor for items with two properties/effects
    public Item(String v1n, int v1, String v2n, int v2, String n, String t)
    {
        //initialize instance fields
        this.v1n = v1n;
        this.v2n = v2n;
        this.v1 = v1;
        this.v2 = v2;
        this.n = n;
        this.t = t;
        quest = t.equals("gem");
    }

    //methods to manipulate and retrieve values of instance fields
    public int getV1()
    {
        return v1;
    }
    
    public String getV1n()
    {
        return v1n;
    }
    
    public int getV2()
    {
        return v2;
    }
    
    public boolean getQuest() {
        return quest;
    }
    
    public void setQuest(boolean q) {
        quest = q;
    }
    
    public String getV2n()
    {
        return v2n;
    }
    
    public String getName()
    {
        return n;
    }
    
    public String getType()
    {
        return t;
    }
    
    public void setV1(int x) {
        v1 = x;
    }
    
    public void setV2(int x) {
        v2 = x;
    }
    
    public void changeV1(int x) {
        v1 += x;
    }
    
    public void changeV2(int x) {
        v2 += x;
    }
}
