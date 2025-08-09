package placeholderGameName;

import STE.gameInput;
import STE.temp_Dev_testing;
import STE.player;

public class main {
    public static void main(String args[]) {
       setupGame();

    }

    public static void setupGame(){
        String version = "Alpha 0.03";
        System.out.println("--------------------\nVersion: "+version+"\n--------------------");
        player player = new player("Donald");
        temp_Dev_testing temp_Dev_testing = new temp_Dev_testing(player);
        gameInput gameInput = new gameInput(player, temp_Dev_testing);


    }

}
/*to do list:
==========================================
//****FIX ITEM ADDING IN INVENTORIES****
//
procedrally gen rooms
    -create a map system with generating doors and room connections
    -be able to travel to different rooms
    -have room data save
    -have containers generate loot
make a combat system
make some npcs or smth similar
create a better input system (less input needed/ easier)
make a save file
==========================================
 */