package STE.Item;

public class Item {

    private int value;
    private String name;
    private int amount;
    private boolean isEquiped;

    public Item(String name, int value, int amount) {

        this.name = name;
        this.value = value;
        this.amount = amount;

    }
    //uses the item
    public void use(){
        System.out.println("no current use");
    }

    //getters and setters
    //advanced
    public void addToAmount(int amount1){
            amount= amount1+amount;
    }
    public void removeToAmount(int amount1){
        if(amount-amount1<0){
            System.out.println("can't subtract that much from amount");
        } else{
            amount = amount-amount1;
        }
    }

    public String getName(){ return this.name;}
    public int getValue(){ return this.value;}
    public int getAmount() { return this.amount;}
    public boolean getIsEquiped(){ return this.isEquiped;}

    public void setAmount(int amount1){ this.amount = amount1;}
    public void setIsEquiped(boolean isEquiped1) { this.isEquiped=isEquiped1;}
}

