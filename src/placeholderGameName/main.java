package placeholderGameName;

import STE.gameInput;
import STE.inventory.inventoryInterface;
import STE.map.room;
import STE.player;

import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String args[]) {
       setupGame();

    }

    public static void setupGame(){
        String version = "Alpha 0.02";
        System.out.println("--------------------\nVersion: "+version+"\n--------------------");
        player player = new player("Donald");
        gameInput gameInput = new gameInput(player);

    }
}
/*to do list:
==========================================
make rooms
make a combat system
make some npcs or smth similar
make a save file
==========================================
 */