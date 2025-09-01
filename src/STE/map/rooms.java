package STE.map;

import STE.item.items;
import STE.universalVariables;

public class rooms {

    universalVariables uV = new universalVariables();

    //where you create all the rooms
    public room start_room = new room("start room",uV.MASSIVE,uV.NO_DANGER,uV.NOT_STORY);

    //===============================================
    //where you generate all the rooms
    private roomGen roomGen = new roomGen();

    public rooms(){
        roomGen.generateContainers(start_room,50);
    }

    //getters and setters
    public roomGen getRoomGen(){ return roomGen;}
}
