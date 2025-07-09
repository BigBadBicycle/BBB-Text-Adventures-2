package STE.inventory;

import STE.player;

public class inventoryInterface {

    //creates inventory
    inventory inventory;
    //gets player's data
    player player;

    public inventoryInterface(player player){
        this.inventory = player.getInventory();
        this.player = player;

    }

    //will open the inventory
    public void openInventory(){
         System.out.println("<============================>");
         System.out.println(player.getName()+"'s Inventory:");
         System.out.println("<============================>");
        for(int i =0; i<=player.getInventory().slots.size()-1; i++){
                System.out.println(i+1+". "+player.getInventory().slots.get(i).getName()
                        +": #"+player.getInventory().slots.get(i).getAmount());
        }
        System.out.println("<============================>");
    }
}
