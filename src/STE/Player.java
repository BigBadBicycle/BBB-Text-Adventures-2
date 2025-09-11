package STE;

import STE.Inventory.Inventory;
import STE.Item.Item;
import STE.Map.Room;

public class Player {

    private int hp;
    private int energy;
    private String name;
    private Inventory inventory;
    private Room currentRoom;
    private Item equipedItem;

    public Player(String name){
        this.name = name;
        hp = 100;
        inventory = new Inventory();

    }

    public void equipItem(Item item){
        if(item.getIsEquiped()==false){
            if(this.equipedItem!=null){
                this.equipedItem.setIsEquiped(false);
                this.equipedItem=null;
            }
            item.setIsEquiped(true);
            this.equipedItem=item;
        } else {
            System.out.println(item.getName()+" is already equiped");
        }
    }

    //getters and setters:

    public int getHp(){ return hp;}
    public int getEnergy() { return this.energy;}
    public String getName(){ return name;}
    public Inventory getInventory(){ return this.inventory;}
    public Item getEquipedItem() { return equipedItem;}
    public Room getCurrentRoom() { return this.currentRoom;}

    public void setHp(int hp1) { this.hp = hp1;}
    public void setEnergy(int energy1) {this.energy=energy1;}
    public void setEquipedItem(Item equipedItem) { this.equipedItem = equipedItem;}
    public void setCurrentRoom(Room room) { this.currentRoom= room;}

}
