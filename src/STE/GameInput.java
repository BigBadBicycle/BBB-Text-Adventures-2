package STE;

import STE.Inventory.Container;
import STE.Inventory.InventoryInterface;
import STE.Inventory.ContainerInterface;
import STE.Item.Items;
import STE.Map.RoomInterface;

import java.util.Scanner;

public class GameInput {
    private boolean inputReaderOn = true;
    private Scanner scanner;
    private Player player;
    private Container tempContainer;
    RoomInterface roomInterface;
    ContainerInterface containerInterface;
    InventoryInterface inventoryInterface;

    public GameInput(Player player, Items items) {
        scanner = new Scanner(System.in);
        this.player = player;
        inventoryInterface = new InventoryInterface(player);
        roomInterface = new RoomInterface(player);

        while (inputReaderOn == true) {
            readDefaultInputs();
        }
    }

    //========================================================================================
    //will have all basic input options; also the main input of a game
    public void readDefaultInputs() {

        final String OPEN_INVENTORY = "q";
        final String INTERACT = "e";
        final String MAP = "m";
        final String EXIT = "z";

        final String MOVEUP = "w";
        final String MOVEDOWN = "s";
        final String MOVELEFT = "a";
        final String MOVERIGHT = "d";

        final int UP = -1;
        final int DOWN = 1;
        final int LEFT = -1;
        final int RIGHT = 1;


        clearConsole();
        System.out.println("=============");
        roomInterface.drawRoom();
        System.out.println("=============\nOptions: 'q': open inventory; 'e': interact; 'm': map; 'z': exit game;\n w-UP; s-DOWN; a-LEFT; d-RIGHT");
        String result = scanner.next();

        switch (result) {
            case OPEN_INVENTORY:
                readInventoryInputs();
                break;

            case INTERACT:
                    if(player.getCurrentRoom().getPlayerTile().getHasContainer()==true){

                        tempContainer = player.getCurrentRoom().getPlayerTile().getContainer();
                        containerInterface = new ContainerInterface(player,tempContainer);
                        readContainerInputs();
                    } else{
                        System.out.println("Nothing on tile");
                    }
                break;
            //all movement:
            //======================

            case MOVEUP:
                roomInterface.mvPlayerBy1(0,UP);
                break;
            case MOVEDOWN:
                roomInterface.mvPlayerBy1(0,DOWN);
                break;
            case MOVELEFT:
                roomInterface.mvPlayerBy1(LEFT,0);
                break;
            case MOVERIGHT:
                roomInterface.mvPlayerBy1(RIGHT,0);
                break;

            //==================================

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
            default:
                System.out.println("invalid input");
        }
    }
    //========================================================================================
    //in charge of all container actions

    public void readContainerInputs() {

        final int CLOSE_INVENTORY = 1;
        final int TAKE_ITEM = 2;
        final int PUT_AWAY_ITEM = 3;

        containerInterface.openInventory();

        System.out.println("Inventory Options: " +
                "1. close inventory; " +
                "2. take item; " +
                "3. put away item;");
    int result = scanner.nextInt();
    switch (result){
        case CLOSE_INVENTORY:
            //left empty to close
            break;

        case TAKE_ITEM:
            try {
                System.out.println("select item by number");
                int itemNumber = scanner.nextInt();
                System.out.println("how much do you want");
                int itemAmount = scanner.nextInt();
                containerInterface.takeItem(itemNumber, itemAmount);
            } catch (Exception e) {
                System.out.println("error try again");
            }
            readContainerInputs();
            break;

        case PUT_AWAY_ITEM:
            if(player.getInventory().getSelectedItem()!=null) {
                if (player.getInventory().getSelectedItem().getAmount() == 1) {
                    containerInterface.putAwayItem(player, 1);
                } else {
                    System.out.println("amount you want to put away");
                    int itemAmount = scanner.nextInt();
                    containerInterface.putAwayItem(player, itemAmount);
                }
            } else{
                System.out.println("Try again");
            }
            readContainerInputs();
            break;

        default:
            System.out.println("invalid input");
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