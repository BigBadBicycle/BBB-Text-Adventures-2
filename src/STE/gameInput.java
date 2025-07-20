package STE;

import STE.inventory.inventoryInterface;
import STE.map.roomInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class gameInput {
    private boolean inputReaderOn = true;
    private Scanner scanner;
    private player player;
    roomInterface roomInterface;

    inventoryInterface inventoryInterface;

    public gameInput(player player) {
        scanner = new Scanner(System.in);
        this.player = player;
        inventoryInterface = new inventoryInterface(player);
        roomInterface = new roomInterface(player);

        while (inputReaderOn == true) {
            readDefaultInputs();
        }
    }

    //will have all basic input options; also the main input of a game
    public void readDefaultInputs() {
        System.out.println("=============\nOptions: \n1: open inventory; 2: interact;\n3: move; 4: map;\n5: exit game;");
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
                
                break;

            case 5:
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
        clearConsole();
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

    //prints to get rid of all things
    private void clearConsole(){
        for(int i=0;i<30;i++){
            System.out.println();
        }
    }


}