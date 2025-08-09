package STE;

import STE.item.item;
import STE.item.items;
import STE.map.rooms;

public class temp_Dev_testing {

    gameInput gameInput;
    public temp_Dev_testing(player player){
        //testing
        items allItems = new items();

        rooms rooms = new rooms();
        player.setCurrentRoom(rooms.start_room);

    }

    public void setGameInput(gameInput gameInput) {
        this.gameInput = gameInput;
    }
}
