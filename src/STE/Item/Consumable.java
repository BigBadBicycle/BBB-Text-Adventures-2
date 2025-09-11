package STE.Item;

public class Consumable extends Item {

    //how much it will give in either health or energy
    private int consumeValue;
    //if the consumable adds health
    private boolean isHealth;

    public Consumable(String name, int valuable, int amount, int consumeValue, boolean isHealth) {
        super(name, valuable,amount);
        this.isHealth = isHealth;
        this.consumeValue = consumeValue;
    }

    //setters and getters
    public int getConsumeValue(){ return this.consumeValue;}
    public boolean getIsHealth() { return this.isHealth;}
}
