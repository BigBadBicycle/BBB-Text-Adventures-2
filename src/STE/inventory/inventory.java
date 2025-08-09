package STE.inventory;

import STE.item.item;
import STE.item.items;
import STE.item.weapons;

import java.util.ArrayList;

public class inventory {
    private ArrayList<item> slots; //creates the inventory slots (by default is 30)
    private item selectedItem;
    private int slotNumber;  //how many slots are in the inventory
    private boolean inventoryFull = false;
    private boolean isEmpty;

    public inventory(int slotNumber) {
        this.slotNumber = slotNumber;
        slots = new ArrayList<item>(slotNumber);

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
            if(item.getName()==slots.get(slots.indexOf(item)).getName()==false){
                slots.add(item);
            } else{
                slots.get(slots.indexOf(item)).addToAmount(item.getAmount());
            }
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