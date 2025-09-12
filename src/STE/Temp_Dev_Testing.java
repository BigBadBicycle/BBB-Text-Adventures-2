package STE;

import STE.Item.Items;
import STE.Map.RoomInterface;
import STE.Map.Rooms;

public class Temp_Dev_Testing {


    public Temp_Dev_Testing(Player player, Items items, Rooms rooms){

        player.setCurrentRoom(rooms.start_room);
        RoomInterface roomInterface = new RoomInterface(player);
        roomInterface.randomPlacePlayer();


    }

}
