package STE;

import STE.inventory.container;
import STE.inventory.inventoryInterface;
import STE.inventory.containerInterface;
import STE.item.items;
import STE.map.roomInterface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class gameInput {
    private boolean inputReaderOn = true;
    private Scanner scanner;
    private player player;
    private container tempContainer;
    roomInterface roomInterface;
    containerInterface containerInterface;
    inventoryInterface inventoryInterface;

    public gameInput(player player) {
        scanner = new Scanner(System.in);
        this.player = player;
        inventoryInterface = new inventoryInterface(player);
        roomInterface = new roomInterface(player);
        //containerInterface = new containerInterface(player,);
        roomInterface.randomPlacePlayer();

        player.getCurrentRoom().makeContainerTile(1,1,"test",30,1);

        while (inputReaderOn == true) {
            readDefaultInputs();
        }
    }

    //========================================================================================
    //will have all basic input options; also the main input of a game
    public void readDefaultInputs() {

        final int OPEN_INVENTORY = 1;
        final int INTERACT = 2;
        final int MOVE = 3;
        final int MAP = 4;
        final int EXIT = 5;

        final int UP = -1;
        final int DOWN = 1;
        final int LEFT = -1;
        final int RIGHT = 1;


        clearConsole();
        System.out.println("=============");
        roomInterface.drawRoom();
        System.out.println("=============\nOptions: 1: open inventory; 2: interact; 3: move; 4: map; 5: exit game;");
        int result = scanner.nextInt();

        switch (result) {
            case OPEN_INVENTORY:
                readInventoryInputs();
                break;

            case INTERACT:
                    if(player.getCurrentRoom().getPlayerTile().getHasContainer()==true){

                        tempContainer = player.getCurrentRoom().getPlayerTile().getContainer();
                        containerInterface = new containerInterface(player,tempContainer);
                        readContainerInputs();
                    } else{
                        System.out.println("Nothing on tile");
                    }
                break;

            case MOVE:

                System.out.println("type: w->up; s->down; a->left; d->right");
                String result2 = scanner.next();
                switch(result2){

                    case "w":
                        roomInterface.mvPlayerBy1(0,UP);
                        break;
                    case "s":
                        roomInterface.mvPlayerBy1(0,DOWN);
                        break;
                    case "a":
                        roomInterface.mvPlayerBy1(LEFT,0);
                        break;
                    case "d":
                        roomInterface.mvPlayerBy1(RIGHT,0);
                        break;
                    default: System.out.println("invalid. please try again");

                }

                break;

            case MAP:
                break;

            case EXIT:
                inputReaderOn=false;
                break;

            default:
                System.out.println("Invalid Input");
        }
    }
    //========================================================================================
    //in charge of all inventory actions
    public void readInventoryInputs() {

        final int SELECT_ITEM = 1;
        final int CLOSE_INVENTORY = 2;
        final int USE_SEL_ITEM = 3;
        final int EQUIP_SEL_ITEM = 4;

        inventoryInterface.openInventory();
        System.out.println("Inventory Options: " +
                "1: select item; " +
                "2. close inventory; " +
                "3. use selected item; " +
                "4. equip selected item; ");

        int result1 = scanner.nextInt();
        switch(result1){
            case SELECT_ITEM:
                System.out.println("Select Item (by number)");
                int result2 = scanner.nextInt();
                inventoryInterface.selectItem(result2);
                readInventoryInputs();

                break;
            case CLOSE_INVENTORY:
                //left empty to close
                break;
            case USE_SEL_ITEM:
                inventoryInterface.useSelectedItem();
                readInventoryInputs();
                break;
            case EQUIP_SEL_ITEM:
                inventoryInterface.equipSelectedItem();
                readInventoryInputs();
                break;
        }
    }
    //========================================================================================
    //in charge of all container actions

    public void readContainerInputs() {

        final int SELECT_ITEM = 1;
        final int CLOSE_INVENTORY = 2;
        final int TAKE_ITEM = 3;
        final int PUT_AWAY_ITEM = 4;

        items items = new items();
        tempContainer.addItem(items.coffee);

        containerInterface.openInventory();

        System.out.println("Inventory Options: " +
                "1: select item; " +
                "2. close inventory; " +
                "3. take item; " +
                "4. put away item;");
    int result = scanner.nextInt();
    switch (result){
        case SELECT_ITEM:
            System.out.println("Select Item (by number)");
            int result1 = scanner.nextInt();
            containerInterface.selectItem(result1);
            readContainerInputs();
            break;

        case CLOSE_INVENTORY:
            //left empty to close
            break;

        case TAKE_ITEM:
            inventoryInterface.useSelectedItem();
            readInventoryInputs();
            break;

        case PUT_AWAY_ITEM:
            inventoryInterface.equipSelectedItem();
            readInventoryInputs();
            break;

        default:
            System.out.println("Invalid Input");
    }
    }

    //========================================================================================

    //prints to get rid of all things
    private void clearConsole(){
        for(int i=0;i<30;i++){
            System.out.println();
        }
    }


}