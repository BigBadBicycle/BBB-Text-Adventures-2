package STE.item;

import java.util.Random;

public abstract class weapon extends item{

    //how much damage a weapon does
    int dmg;
    //how much durability it has
    int durability;
    //anything = or below this number is a miss
    int missChance;
    //creates a number from 0-100 on chance.
    Random random;
    final int numGen = 101;

    weapon(String name, int valuable, boolean isEquipable, int dmg, int durability, int missChance) {
        super(name, valuable, isEquipable);
        this.dmg = dmg;
        this.durability = durability;
        this.missChance = missChance;

        random = new Random();
    }
    //will attempt a hit on the enemy
    public void attemptHit(){
        if(random.nextInt(numGen)>missChance){

        } else {
            System.out.println("You Missed!");
        }

    }
    //makes the use only for the weapon
    @Override
    public void use(){
        if(isEquiped==true){
            attemptHit();

        }
    }

    //Info Getters
    public int getDmg(){ return this.dmg;}
    public int getDurability(){ return this.durability;}
    public int getMissChance(){ return this.missChance;}


}
