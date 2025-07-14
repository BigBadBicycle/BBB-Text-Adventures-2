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
         if(player.getInventory().getSlots().size()==0){
             System.out.println("Nothing in inventory");
         } else {
             for (int i = 0; i <= player.getInventory().getSlots().size() - 1; i++) {
                 if(player.getInventory().getSlots().get(i)==player.getEquipedItem()){
                     if(player.getInventory().getSlots().get(i)==player.getInventory().getSelectedItem()){
                         printItemForInventory(" [equiped] *selected*",i);
                     } else{
                         printItemForInventory(" [equiped]",i);
                     }
                 }
                 else if(player.getInventory().getSlots().get(i)==player.getInventory().getSelectedItem()) {
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

    private void printItemForInventory(String extraDetail,int i){
        if(extraDetail==null){
            extraDetail="";
        }

        System.out.println(i + 1 + ". " + player.getInventory().getSlots().get(i).getName()
                + ": #" + player.getInventory().getSlots().get(i).getAmount()+extraDetail);
    }

}
