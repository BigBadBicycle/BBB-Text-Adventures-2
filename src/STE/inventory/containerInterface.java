package STE.inventory;

import STE.player;

public class containerInterface extends inventoryInterface{

    container container;
    public containerInterface(player player,container container) {
        super(player);
        this.container=container;
    }

    @Override
    public void openInventory(){
        System.out.println("");
        System.out.println("<============================>");
        System.out.println("container:");
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

    public void takeItem(player player){
        if(container.getSelectedItem()!=null){
            player.getInventory().addItem(container.getSelectedItem());
            container.getSlots().remove(container.getSelectedItem());
            container.setSelectedItem(null);

        } else{
            System.out.println("Please select item");
        }
    }

    public void putAwayItem(player player){
        if(player.getInventory().getSelectedItem()!=null) {
            container.addItem(player.getInventory().getSelectedItem());
            player.getInventory().getSlots().remove(player.getInventory().getSelectedItem());
            player.getInventory().setSelectedItem(null);
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
    public container getContainer(){ return this.container;}

}
