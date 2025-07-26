package STE.map;

import STE.player;

import java.util.Random;

public class roomInterface {

    private player player;
    private room room;
    private Random random;

    public roomInterface(player player){
        this.player=player;
        this.room = player.getCurrentRoom();

        random = new Random();
    }

    //draws room
    public void drawRoom() {
        drawRoomBorders();
        System.out.println();
        for (int i = 0; i < room.getY().size(); i++) {
            for (int j = 0; j < room.getX().size(); j++) {
                room.getTile(j, i).drawTile();
            }
            System.out.println();
        }
        drawRoomBorders();
        System.out.println();
    }

    //only call once because it might place more than one player!!!
    public void randomPlacePlayer(){
        room.getTile(random.nextInt(room.getX().size()),random.nextInt(room.getY().size())).setHasPlayer(true);
    }

    public void changePlayerTile(int x, int y){
        if(room.getPlayerTile()!=null){
            room.getPlayerTile().setHasPlayer(false);
            room.getTile(x,y).setHasPlayer(true);
        } else{
            room.getTile(x,y).setHasPlayer(true);
        }

    }

    public void interactWithContainer(){

    }

    public void mvPlayerBy1(int x,int y){
        if(room.getPlayerTile().getX()+x<0||room.getPlayerTile().getX()+x>=room.getSize()){
            System.out.println("you hit a wall");
        } else if(room.getPlayerTile().getY()+y<0||room.getPlayerTile().getY()+y>=room.getSize()){
            System.out.println("you hit a wall");
        } else{
            changePlayerTile(room.getPlayerTile().getX()+x,room.getPlayerTile().getY()+y);
        }
    }

    //private
    private void drawRoomBorders(){
        for(int b=0;b<room.getY().size();b++){
            System.out.print("###");
        }
    }

}
