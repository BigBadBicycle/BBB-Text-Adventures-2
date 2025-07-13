package STE.inventory;

import STE.item.item;
import placeholderGameName.items.items;
import placeholderGameName.items.weapons;

import java.util.ArrayList;

public class inventory {
    items allItems;
    weapons allWeapons;
    ArrayList<item> slots; //creates the inventory slots (by default is 30)
    item selectedItem;
    int slotNumber;  //how many slots are in the inventory
    boolean inventoryFull = false;
    boolean isEmpty;

    public inventory(int slotNumber) {
        //allItems = new items();
        //allWeapons = new weapons();
        this.slotNumber = slotNumber;
        slots = new ArrayList<item>(slotNumber);


        addItem(allItems.coffee);
        addItem(allWeapons.throwing_spear);

    }
    //the method to tell if the inventory is full
    public void canAddItems(){
        if(slots.size()==slotNumber){
            inventoryFull=false;
        } else{
            inventoryFull=true;
        }
    }

    public void addItem(item item){
        if(inventoryFull==false){
            slots.add(item);
            System.out.println("Picked up: "+item.getName());
        } else {
            System.out.println("Inventory is Full!");
        }
    }

    //getters and setters
    public boolean getInventoryFull() {return inventoryFull;}
    public boolean getIsEmpty() { return isEmpty;}
    public item getSelectedItem() { return selectedItem;}
    public ArrayList<item> getSlots() { return slots;}


    public void setSelectedItem(item item) { selectedItem=item;}

}