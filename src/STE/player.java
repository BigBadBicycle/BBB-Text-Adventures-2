package STE;

import STE.inventory.inventory;
import STE.inventory.inventoryInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class player {

    //health
    int hp;
    //energy
    int energy;
    //how many slots in the inventory the player has
    int slotNumber =30;
    //in game name of the player
    String name;
    //creates the player's inventory
    private inventory inventory;

    public player(String name){
        this.name = name;
        hp = 100;
        inventory = new inventory(slotNumber);
        System.out.println("Hello "+name);

    }

    //getters and setters:

    public int getHp(){ return hp;}
    public int getSlotNumber(){ return this.slotNumber;}
    public int getEnergy() { return this.energy;}
    public String getName(){ return name;}
    public inventory getInventory(){ return this.inventory;}

    public void setHp(int hp1) { this.hp = hp1;}
    public void setSlotNumber(int slotNumber1){this.slotNumber=slotNumber1;}
    public void setEnergy(int energy1) {this.energy=energy1;}


}
