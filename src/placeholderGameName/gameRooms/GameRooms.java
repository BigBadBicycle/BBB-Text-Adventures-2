package placeholderGameName.gameRooms;

import STE.Variables.RoomVariables;
import STE.Item.Items;
import STE.Map.RoomGen;
import STE.Map.Rooms;

public class GameRooms extends Rooms {

    RoomVariables uV = new RoomVariables();
    //rooms
    //===================================================

    //===================================================

    public GameRooms(Items items){
        RoomGen rG = new RoomGen();
        rG.generateContainers(this.start_room,50);
    }
}
