package placeholderGameName;

import STE.gameInput;
import STE.inventory.inventoryInterface;
import STE.player;

import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String args[]) {

    }

    public void setupGame(){
        player player = new player("Donald");
        gameInput gameInput = new gameInput(player);
    }
}
//to do list
//1. make a good input system
//2. make it so you can use the item and select it
//3.