package STE.map;

import STE.universalVariables;

public class rooms {

    universalVariables uV = new universalVariables();
    //rooms
    //===================================================
    public room start_room = new room("start room", uV.BIG,uV.NO_DANGER,uV.NOT_STORY);
    //===================================================

    public rooms(){
        roomGen rG = new roomGen();
    }

}
