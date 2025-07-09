package STE;

import STE.inventory.inventoryInterface;

import java.util.Scanner;

public class gameInput {
    //if the input reader is on or off
    boolean inputReaderOn = true;
    Scanner scanner;
    player player;

    public gameInput(player player) {
        scanner = new Scanner(System.in);
        this.player = player;

        while (inputReaderOn == true) {
            readDefaultInputs();
        }
    }

    //will have all basic input options; also the main input of a game
    public void readDefaultInputs() {
        System.out.println("Options: 1: inventory; ");
        int result = scanner.nextInt();

        if (result == 1) {
            inventoryInterface playerInterface = new inventoryInterface(player);
            playerInterface.openInventory();
        } else {
            System.out.println("Invalid Input");
        }
    }

    public void readInventoryInputs() {
        System.out.println("Inventory Options: 1");

    }
}