package STE.item;

public class ammo extends item{

    int amount;
    ammo(String name, int valuable, boolean isEquipable,int amount) {
        super(name, valuable, isEquipable);
        this.amount = amount;
    }
}
