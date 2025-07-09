package STE.item;

import STE.player;

public class consumable extends item{

    //how much it will give in either health or energy
    int consumeValue;
    //if the consumable adds health
    boolean isHealth;

    consumable(String name, int valuable,int amount, int consumeValue, boolean isHealth) {
        super(name, valuable,amount);
        this.isHealth = isHealth;
        this.consumeValue = consumeValue;
    }

    @Override
    public void use(){
        if(isEquiped==true){
            System.out.println("No Current Use");

        }
    }

    //setters and getters

}
