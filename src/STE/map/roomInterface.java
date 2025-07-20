package STE.map;

import STE.player;

public class roomInterface {

    player player;
    room room;

    public roomInterface(player player){
        this.player=player;
        this.room = player.getCurrentRoom();
    }

    //draws room
    public void drawRoom(){
        for(int i=0;i<room.getY().size();i++){
            for(int j=0;j<room.getX().size();j++){
                room.getTile(j,i).drawTile();
            }
            System.out.println();
        }
    }

}
