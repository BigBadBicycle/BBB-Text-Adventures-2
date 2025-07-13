package STE;

import STE.inventory.inventoryInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class gameInput {
    boolean inputReaderOn = true;
    Scanner scanner;
    player player;

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
        System.out.println("Options: " +
                "1: inventory; " +
                "2: use equiped item");
        int result = scanner.nextInt();

        switch (result) {
            case 1:
                inventoryInterface playerInterface = new inventoryInterface(player);
                readInventoryInputs();
                break;

            case 2:

                break;

            default:
                System.out.println("Invalid Input");
                break;
        }
    }

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
                System.out.println(player.getInventory().getSelectedItem().getIsEquiped());
                player.getInventory().getSelectedItem().use();
                readInventoryInputs();
                break;
            case 4:
                player.getInventory().getSelectedItem().equip();
                readInventoryInputs();
                break;
        }
    }
}