package STE.inventory;

import STE.player;

public class inventoryInterface {

    private inventory inventory;
    private player player;

    public inventoryInterface(player player){
        this.inventory = player.getInventory();
        this.player = player;

    }

    //will open the inventory
    public void openInventory(){
        System.out.println("");
         System.out.println("<============================>");
         System.out.println(player.getName()+"'s Inventory:");
         System.out.println("<============================>");
         if(inventory.getSlots().isEmpty()){
             System.out.println("Nothing in inventory");
         } else {
             for (int i = 0; i < inventory.getSlots().size(); i++) {
                 if(inventory.getSlots().get(i)==player.getEquipedItem()){
                     if(inventory.getSlots().get(i)==inventory.getSelectedItem()){
                         printItemForInventory(" [equiped] *selected*",i);
                     } else{
                         printItemForInventory(" [equiped]",i);
                     }
                 }
                 else if(inventory.getSlots().get(i)==inventory.getSelectedItem()) {
                     printItemForInventory(" *selected*", i);
                 }
                 else {
                     printItemForInventory(null,i);
                 }
             }
         }
        System.out.println("<============================>");
        System.out.println("");
    }

    public void selectItem(int result2){
        try{
            System.out.println("******************");
            System.out.println(inventory.getSlots().get(result2-1).getName()+ " is selected");
            System.out.println("******************");
            inventory.setSelectedItem(inventory.getSlots().get(result2-1));
        } catch(Exception e){
            System.out.println("Error, try again");
        }
    }

    public void useSelectedItem(){
        if(player.getInventory().getSelectedItem()!=null){
            player.getInventory().getSelectedItem().use();
        } else{
            System.out.println("no item selected");
        }
    }

    public void equipSelectedItem(){
        player.equipItem(inventory.getSelectedItem());
    }


    //private
    protected void printItemForInventory(String extraDetail,int i){
        if(extraDetail==null){
            extraDetail="";
        }

        System.out.println(i + 1 + ". " + inventory.getSlots().get(i).getName()
                + ": #" + inventory.getSlots().get(i).getAmount()+extraDetail);
    }

}
