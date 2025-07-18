package STE.map;

import java.util.ArrayList;

public class tile {

    private int x;
    private int y;
    private ArrayList<Integer> cords; //coordinates
    private boolean hasContainer = false;
    private boolean hasNPC = false;
    private boolean hasPlayer = false;
    room room;
    public tile(int column, int row, room room){
        this.x = column;
        this.y = row;
        this.room = room;

        cords = new ArrayList<Integer>(2);
        cords.add(x);
        cords.add(y);
    }

    public void drawTile(){
        if(hasContainer==true){
            System.out.print("[c]");
        }else if(hasNPC==true){
            System.out.print("[n]");
        } else if(hasPlayer==true){
            System.out.print("[p]");
        } else{
            System.out.print("[ ]");
        }
    }


    //getters and setters

    public int getX() { return x;}
    public int getY() { return y;}
    public ArrayList<Integer> getCords(){return cords;}
    public boolean getHasContainer() { return hasContainer;}
    public boolean getHasNPC() { return hasNPC;}
    public boolean getHasPlayer() { return hasPlayer;}


    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setHasContainer(boolean hasContainer) { this.hasContainer=hasContainer;}
    public void setHasNPC(boolean hasNPC) { this.hasNPC=hasNPC;}
    public void setHasPlayer(boolean hasPlayer) { this.hasPlayer=hasPlayer;}
}
