package placeholderGameName;

import STE.gameInput;
import STE.inventory.inventoryInterface;
import STE.player;

import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String args[]) {
        setupGame();
    }

    public static void setupGame(){
        player player = new player("Donald");
        gameInput gameInput = new gameInput(player);
    }
}
/*to do list:
==========================================
make events / areas
make a combat system
make some npcs or smth similar
==========================================
 */