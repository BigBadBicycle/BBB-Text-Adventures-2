package STE.map;

import STE.inventory.container;

import java.util.ArrayList;

public class tile {

    private int x;
    private int y;
    private boolean hasContainer = false;
    private container container;
    private boolean hasNPC = false;
    private boolean hasPlayer = false;

    room room;
    public tile(int column, int row, room room){
        this.x = column;
        this.y = row;
        this.room = room;

    }

    public void drawTile(){
        if(hasContainer==true){
            if(hasPlayer==true){
                System.out.print("[C]");
            } else{
                System.out.print("[c]");
            }
        }else if(hasNPC==true){
            System.out.print("[n]");
        } else if(hasPlayer==true){
            System.out.print("[P]");
        } else{
            System.out.print("[ ]");
        }
    }

    public void createContainer(String type,int slotNumber, int rarity){
        if(hasContainer==true){
            container = new container(type,slotNumber,rarity);
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


    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setHasContainer(boolean hasContainer) { this.hasContainer=hasContainer;}
    public void setHasNPC(boolean hasNPC) { this.hasNPC=hasNPC;}
    public void setHasPlayer(boolean hasPlayer) { this.hasPlayer=hasPlayer;}
}
