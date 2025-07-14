package STE;

import STE.inventory.inventory;
import STE.inventory.inventoryInterface;
import STE.item.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class player {

    private int hp;
    private int energy;
    //how many slots in the inventory the player has
    private int slotNumber =30;
    String name;
    //creates the player's inventory
    private inventory inventory;
    item equipedItem;

    public player(String name){
        this.name = name;
        hp = 100;
        inventory = new inventory(slotNumber);
        System.out.println("Hello "+name);

    }

    public void equipItem(item item){
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
    public int getSlotNumber(){ return this.slotNumber;}
    public int getEnergy() { return this.energy;}
    public String getName(){ return name;}
    public inventory getInventory(){ return this.inventory;}
    public item getEquipedItem() { return equipedItem;}

    public void setHp(int hp1) { this.hp = hp1;}
    public void setSlotNumber(int slotNumber1){this.slotNumber=slotNumber1;}
    public void setEnergy(int energy1) {this.energy=energy1;}
    public void setEquipedItem(item equipedItem) { this.equipedItem = equipedItem;}
}
