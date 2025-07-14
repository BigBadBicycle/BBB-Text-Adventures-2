package STE;

import STE.inventory.inventoryInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class gameInput {
    private boolean inputReaderOn = true;
    private Scanner scanner;
    private player player;

    inventoryInterface inventoryInterface;

    public gameInput(player player) {
        scanner = new Scanner(System.in);
        this.player = player;
        inventoryInterface = new inventoryInterface(player);

        while (inputReaderOn == true) {
            readDefaultInputs();
        }
    }

    //will have all basic input options; also the main input of a game
    public void readDefaultInputs() {
        System.out.println("=============\nOptions: \n1: open inventory; \n2: use equiped item;\n3: move;\n4: exit game;");
        int result = scanner.nextInt();

        switch (result) {
            case 1:
                inventoryInterface playerInterface = new inventoryInterface(player);
                readInventoryInputs();
                break;

            case 2:
                if(player.getEquipedItem()!=null) {
                    player.getEquipedItem().use();
                } else {
                    System.out.println("no item equiped");
                }
                readDefaultInputs();
                break;

            case 3:
                System.out.println("Function not implemented");
                break;

            case 4:
                inputReaderOn=false;
                break;

            default:
                System.out.println("Invalid Input");
                readDefaultInputs();
                break;
        }
    }

    //in charge of all inventory actions
    public void readInventoryInputs() {
        inventoryInterface.openInventory();
        System.out.println("Inventory Options: " +
                "1: select item; " +
                "2. close inventory; " +
                "3. use selected item; " +
                "4. equip selected item; ");
        int result1 = scanner.nextInt();
        switch(result1){
            case 1:
                System.out.println("Select Item (by number)");
                int result2 = scanner.nextInt();
                try{
                    System.out.println("******************");
                    System.out.println(player.getInventory().getSlots().get(result2-1).getName()+ " is selected");
                    System.out.println("******************");
                    player.getInventory().setSelectedItem(player.getInventory().getSlots().get(result2-1));
                } catch(Exception e){
                    System.out.println("Error, try again");
                }
                readInventoryInputs();

                break;
            case 2:
                    //left empty to leave inventory
                break;
            case 3:
                player.getInventory().getSelectedItem().use();
                readInventoryInputs();
                break;
            case 4:
                player.equipItem(player.getInventory().getSelectedItem());
                readInventoryInputs();
                break;
        }
    }
}