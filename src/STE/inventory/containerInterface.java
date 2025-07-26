package STE.inventory;

import STE.player;

public class containerInterface extends inventoryInterface{

    container container;
    String type;
    public containerInterface(player player,container container) {
        super(player);
        this.container=container;
        this.type = container.getType();
    }

    @Override
    public void openInventory(){
        System.out.println("");
        System.out.println("<============================>");
        System.out.println(type+" container:");
        System.out.println("<============================>");
        if(container.getSlots().isEmpty()){
            System.out.println("Nothing in container");
        } else {
            for (int i = 0; i < container.getSlots().size(); i++) {
                if(container.getSlots().get(i)==container.getSelectedItem()) {
                    super.printItemForInventory(" *selected*", i);
                }
                else {
                    super.printItemForInventory(null,i);
                }
            }
        }
        System.out.println("<============================>");
        System.out.println("");
    }

    public void containerInteract(){

    }

}
