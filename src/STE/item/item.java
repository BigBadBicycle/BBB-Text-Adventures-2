package STE.item;

public abstract class item {

    //gives the value of the object. 1 is the lowest and 10 being the highest.
    // 11 being important to the story
    int valuable;
    //name of item
    String name;
    //if object can be equiped
    boolean isEquipable;
    //if object is equiped
    boolean isEquiped;

    item(String name, int valuable,boolean isEquipable) {

        this.name = name;
        this.valuable = valuable;
        this.isEquipable = isEquipable;

    }
    //uses the item
    public void use(){
        if(isEquiped==true){
            System.out.println("No Current Use");

        }
    }
    //equips the item
    public void equip(){
        if(isEquipable==true){

        }
    }

    //Info Getters
    public String getName(){ return this.name;}
    public int getValuable(){ return this.valuable;}
    public boolean getIsEquipable(){ return this.isEquipable;}
    public boolean getIsEquiped(){ return this.isEquiped;}
}
