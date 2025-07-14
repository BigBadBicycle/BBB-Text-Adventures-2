package STE.item;

import java.util.Random;

public abstract class weapon extends item{

    private int dmg;
    private int durability;
    //anything = or below this number is a miss
    private int missChance;
    private Random random;
    final private int NUM_GEN = 101;

    weapon(String name, int valuable,int amount, int dmg, int durability) {
        super(name, valuable,amount);
        this.dmg = dmg;
        this.durability = durability;
        this.missChance = missChance;
        this.setAmount(1);

        random = new Random();
    }
    public void attemptHit(){
        if(random.nextInt(NUM_GEN)>missChance){
            System.out.println("you used your weapon!!!!");
        } else {
            System.out.println("You Missed!");
        }

    }
    @Override
    public void use(){
        if(this.getIsEquiped()==true){
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
