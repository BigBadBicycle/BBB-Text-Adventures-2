package STE.map;

import STE.inventory.container;

import java.util.ArrayList;

public class tile {

    private int x;
    private int y;
    private String tileSymbol;
    private boolean hasContainer = false;
    private container container;
    private boolean hasNPC = false;
    private boolean hasPlayer = false;
    private boolean isEmptyTile = true;

    room room;
    public tile(int column, int row, room room){
        this.x = column;
        this.y = row;
        this.room = room;
        checkTile();

    }

    public void checkTile(){
        if(hasContainer==true){
            if(hasPlayer==true){
                isEmptyTile = false;
                tileSymbol = "[C]";
            } else{
                isEmptyTile = false;
                tileSymbol = "[c]";
            }
        }else if(hasNPC==true){
            isEmptyTile = false;
            tileSymbol = "[n]";
        } else if(hasPlayer==true){
            isEmptyTile = false;
            tileSymbol = "[P]";
        } else{
            isEmptyTile = true;
            tileSymbol = "[ ]";
        }
    }

    public void drawTile(){
        checkTile();
        System.out.print(tileSymbol);
    }

    public void createContainer(int slotNumber){
        if(hasContainer==true){
            container = new container(slotNumber);
        } else{
            System.out.println("Tile does not have container");
        }

    }


    //getters and setters

    public int getX() { return x;}
    public int getY() { return y;}
    public boolean getHasContainer() { return hasContainer;}
    public boolean getHasNPC() { return hasNPC;}
    public boolean getHasPlayer() { return hasPlayer;}
    public container getContainer() { return container;}
    public boolean getIsEmptyTile() { return isEmptyTile;}


    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setHasContainer(boolean hasContainer) { this.hasContainer=hasContainer;}
    public void setHasNPC(boolean hasNPC) { this.hasNPC=hasNPC;}
    public void setHasPlayer(boolean hasPlayer) { this.hasPlayer=hasPlayer;}
    public void setEmptyTile(boolean isEmptyTile) { this.isEmptyTile= isEmptyTile;}
}
