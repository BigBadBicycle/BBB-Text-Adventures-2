package STE.item;

public class item {

    //gives the value of the object. 1 is the lowest and 10 being the highest.
    // 11 being important to the story
    int valuable;
    String name;
    int amount;
    boolean isEquiped;

    item(String name, int valuable,int amount) {

        this.name = name;
        this.valuable = valuable;
        this.amount = amount;

    }
    //uses the item
    public void use(){
        if(isEquiped==true){
            System.out.println("No Current Use");

        }
    }
    //equips the item
    public void equip(){
        if (this.isEquiped=!true) {
            isEquiped=true;
        } else {
            System.out.println("already equiped");
        }
    }

    //getters and setters
    public String getName(){ return this.name;}
    public int getValuable(){ return this.valuable;}
    public int getAmount() { return this.amount;}
    public boolean getIsEquiped(){ return this.isEquiped;}

    public void setAmount(int amount1){ this.amount = amount1;}
    public void setIsEquiped(boolean isEquiped1) { this.isEquiped=isEquiped1;}
}

