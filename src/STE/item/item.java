package STE.item;

public class item {

    /* valuable gives the value of the object from 1-5:
    1 is very common
    2 is common
    3 is uncommon
    4 is rare
    5 is a story item */
    private int valuable;
    private String name;
    private int amount;
    private boolean isEquiped;

    item(String name, int valuable,int amount) {

        this.name = name;
        this.valuable = valuable;
        this.amount = amount;

    }
    //uses the item
    public void use(){
        System.out.println("no current use");
    }

    //getters and setters
    public String getName(){ return this.name;}
    public int getValuable(){ return this.valuable;}
    public int getAmount() { return this.amount;}
    public boolean getIsEquiped(){ return this.isEquiped;}

    public void setAmount(int amount1){ this.amount = amount1;}
    public void setIsEquiped(boolean isEquiped1) { this.isEquiped=isEquiped1;}
}

