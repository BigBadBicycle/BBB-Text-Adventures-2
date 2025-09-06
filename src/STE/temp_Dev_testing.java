package STE;

import STE.map.rooms;

public class temp_Dev_testing {

    gameInput gameInput;
    public temp_Dev_testing(player player){

        rooms rooms = new rooms();
        player.setCurrentRoom(rooms.start_room);

    }

}
