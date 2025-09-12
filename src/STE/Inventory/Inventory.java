package STE.Inventory;

import STE.Variables.UniversalVariables;
import STE.Item.Item;
import STE.Item.Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> slots; //creates the inventory slots (by default is 30)
    private Item selectedItem;
    private int slotNumber;  //how many slots are in the inventory
    private boolean inventoryFull = false;
    private boolean isEmpty;
    public Items items;
    private UniversalVariables uV;

    public Inventory() {
        uV = new UniversalVariables();
        uV.createGameItems();
        items = uV.gameItems;
        this.slotNumber = uV.SLOT_AMOUNT;
        slots = new ArrayList<Item>(slotNumber);

    }
    public void isInventoryFull(){
        if(slots.size()>=slotNumber){
            inventoryFull=true;
        } else{
            inventoryFull=false;
        }
    }
    public void addItem(Item item){
        isInventoryFull();
        if(inventoryFull==false){
            if(isAlreadyInSlots(item)==true){
                slots.get(slots.indexOf(items.findItemByName(item))).addToAmount(item.getAmount());
                System.out.println("added: "+item.getName()+"; added by: "+item.getAmount());
            } else{
                Item tempItem = items.findItemByName(item);
                tempItem.setAmount(item.getAmount());
                slots.add(tempItem);
                System.out.println("added item "+item.getName());
            }


        } else {
            System.out.println("Inventory is Full!");
        }
    }

    private boolean isAlreadyInSlots(Item item){
        boolean tempbool = false;
        if(slots.size()!=0) {
            Item tempitem = items.findItemByName(item);
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
    public Item getSelectedItem() { return selectedItem;}
    public ArrayList<Item> getSlots() { return slots;}
    public Items getItems() { return items;}

    public void setSelectedItem(Item item) { selectedItem=item;}
    public void setItems(Items items) { this.items = items;}

}