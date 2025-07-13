package STE.item;

import java.util.Random;

public abstract class weapon extends item{

    int dmg;
    int durability;
    //anything = or below this number is a miss
    int missChance;
    Random random;
    final int numGen = 101;

    weapon(String name, int valuable,int amount, int dmg, int durability) {
        super(name, valuable,amount);
        this.dmg = dmg;
        this.durability = durability;
        this.missChance = missChance;
        this.amount = 1;

        random = new Random();
    }
    public void attemptHit(){
        if(random.nextInt(numGen)>missChance){
            System.out.println("you used your weapon!!!!");
        } else {
            System.out.println("You Missed!");
        }

    }
    @Override
    public void use(){
        if(isEquiped==true){
            attemptHit();
        }
    }

    //setters and getters
    public int getDmg(){ return this.dmg;}
    public int getDurability(){ return this.durability;}
    public int getMissChance(){ return this.missChance;}

    public void setDurability(int durability1){ this.durability=durability1;}
    public void setMissChance(int missChance1){ this.missChance=missChance1;}

}
