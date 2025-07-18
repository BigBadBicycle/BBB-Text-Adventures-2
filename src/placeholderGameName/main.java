package placeholderGameName;

import STE.gameInput;
import STE.inventory.inventoryInterface;
import STE.map.room;
import STE.player;

import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String args[]) {
       // setupGame();
        room room = new room("test",5,0,false);
        room.getTile(4,4).setHasContainer(true);
        room.drawRoom();

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