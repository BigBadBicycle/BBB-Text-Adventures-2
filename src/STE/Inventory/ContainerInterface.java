package STE.Inventory;

import STE.Item.Item;
import STE.Player;

public class ContainerInterface extends InventoryInterface {
    Player player;
    Container container;
    public ContainerInterface(Player player, Container container) {
        super(player);
        this.player = player;
        this.container=container;
    }

    @Override
    public void openInventory(){
        System.out.println("");
        System.out.println("<============================>");
        System.out.println("Container:");
        System.out.println("<============================>");
        if(container.getSlots().isEmpty()){
            System.out.println("Nothing in container");
        } else {
            for (int i = 0; i < container.getSlots().size(); i++) {
                if(container.getSlots().get(i)==container.getSelectedItem()) {
                    this.printItemForInventory(" *selected*", i);
                }
                else {
                    this.printItemForInventory(null,i);
                }
            }
        }
        System.out.println("<============================>");
        System.out.println("");
    }

    public void containerInteract(){

    }

    @Override
    public void selectItem(int result2){
        try{
            System.out.println("******************");
            System.out.println(container.getSlots().get(result2-1).getName()+ " is selected");
            System.out.println("******************");
            container.setSelectedItem(container.getSlots().get(result2-1));
        } catch(Exception e){
            System.out.println("Error, try again");
        }
    }

    public void takeItem(int itemNumber, int itemAmount){
        try{
            Item tempItem = container.getSlots().get(itemNumber-1);
            if(tempItem.getAmount()<=itemAmount){
                player.getInventory().addItem(tempItem);
                container.getSlots().remove(tempItem);
            } else{
                final int tempamount = tempItem.getAmount();
                tempItem.setAmount(itemAmount);
                player.getInventory().addItem(tempItem);
                tempItem.setAmount(tempamount);
                container.getSlots().get(itemNumber-1).removeToAmount(itemAmount);
            }

        } catch(Exception e){
            System.out.println("Error, try again");
        }
    }

    public void putAwayItem(Player player, int amount){
        if(player.getInventory().getSelectedItem()!=null) {
            if(amount>=player.getInventory().getSelectedItem().getAmount()) {
                container.addItem(player.getInventory().getSelectedItem());
                player.getInventory().getSlots().remove(player.getInventory().getSelectedItem());
                player.getInventory().setSelectedItem(null);
            } else{

                if(amount<0){
                    System.out.println("can't do negatives sir");
                } else{
                    Item tempItem = player.getInventory().getSelectedItem();
                    final int tempamount = tempItem.getAmount();
                    tempItem.setAmount(amount);
                    container.addItem(tempItem);
                    tempItem.setAmount(tempamount);

                    player.getInventory().getSelectedItem().removeToAmount(amount);
                    //player.getInventory().getSlots().get(player.getInventory().getSlots().indexOf(player.getInventory().getSelectedItem())).removeToAmount(amount);
                }

            }
        } else {
            System.out.println("No selected item in inventory");
        }
    }

    //=================================================
    //private
    @Override
    protected void printItemForInventory(String extraDetail,int i){
        if(extraDetail==null){
            extraDetail="";
        }

        System.out.println(i + 1 + ". " + container.getSlots().get(i).getName()
                + ": #" + container.getSlots().get(i).getAmount()+extraDetail);
    }

    //getters and setters
    public Container getContainer(){ return this.container;}

}
