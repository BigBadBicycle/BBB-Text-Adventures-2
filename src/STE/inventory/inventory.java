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
    private items items;

    public inventory(int slotNumber) {
        this.slotNumber = slotNumber;
        slots = new ArrayList<item>(slotNumber);
        items = new items();

    }
    public void isInventoryFull(){
        if(slots.size()>=slotNumber){
            inventoryFull=true;
        } else{
            inventoryFull=false;
        }
    }
    public void addItem(item item){
        isInventoryFull();
        if(inventoryFull==false){
            if(isAlreadyInSlots(item)==true){
                slots.get(slots.indexOf(items.findItemByName(item))).addToAmount(item.getAmount());
                System.out.println("added more items: "+item.getName()+" added by: "+item.getAmount());
            } else{
                item tempItem = items.findItemByName(item);
                tempItem.setAmount(item.getAmount());
                slots.add(tempItem);
                System.out.println("added item "+item.getName());
            }


        } else {
            System.out.println("Inventory is Full!");
        }
    }

    private boolean isAlreadyInSlots(item item){
        boolean tempbool = false;
        if(slots.size()!=0) {
            item tempitem = items.findItemByName(item);
            for(int i =0; i<slots.size();i++) {
                if (slots.get(i) == tempitem) {
                    tempbool = true;
                }
            }
        }
        return tempbool;
    }

    //getters and setters
    public boolean getInventoryFull() {return inventoryFull;}
    public boolean getIsEmpty() { return isEmpty;}
    public item getSelectedItem() { return selectedItem;}
    public ArrayList<item> getSlots() { return slots;}
    public items getItems() { return items;}

    public void setSelectedItem(item item) { selectedItem=item;}

}