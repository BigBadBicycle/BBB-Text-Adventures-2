package placeholderGameName;

import STE.GameInput;
import STE.Temp_Dev_Testing;
import STE.Player;
import placeholderGameName.gameItems.GameItems;
import placeholderGameName.gameRooms.GameRooms;

public class Main {
    public static void main(String args[]) {
       setupGame();

    }

    public static void setupGame(){
        String version = "Alpha 0.03";
        System.out.println("--------------------\nVersion: "+version+"\n--------------------");

        GameItems gameItems = new GameItems();
        GameRooms gameRooms = new GameRooms(gameItems);

        Player player = new Player("Donald");
        Temp_Dev_Testing temp_Dev_testing = new Temp_Dev_Testing(player,gameItems,gameRooms);

        GameInput gameInput = new GameInput(player,gameItems);


    }

}
/*to do list:
==========================================
==========================================
 */