package STE.inventory;

import STE.item.item;
import STE.item.items;
import STE.item.weapons;

import java.util.ArrayList;

public class inventory {
    //adds all items
    items allItems;
    //adds all weapons
    weapons allWeapons;
    //creates the inventory slots (by default is 30)
    ArrayList<item> slots;
    //how many slots are in the inventory
    int slotNumber;
    //checks if the inventory is full
    boolean inventoryFull = true;

    public inventory(int slotNumber) {
        allItems = new items();
        allWeapons = new weapons();
        this.slotNumber = slotNumber;
        slots = new ArrayList<item>(slotNumber);

        slots.add(allItems.banana);
        slots.add(allItems.coffee);
        slots.add(allItems.tomato_soup);

    }
    //the method to tell if the inventory is full
    public void canAddItems(){
        if(slots.size()==slotNumber){
            inventoryFull=false;
        } else{
            inventoryFull=true;
        }
    }

    //getters and setters
    public boolean getInvetoryFull() {return inventoryFull;}

}