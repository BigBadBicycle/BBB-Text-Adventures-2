package STE.Map;

import STE.Inventory.Container;
import STE.Item.Items;

public class Tile {

    private int x;
    private int y;
    private String tileSymbol;
    private boolean hasContainer = false;
    private Container container;
    private boolean hasNPC = false;
    private boolean hasPlayer = false;
    private boolean isEmptyTile = true;
    private Items items;

    Room room;
    public Tile(int column, int row, Room room){
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

    public void createContainer(){
            this.hasContainer = true;
            container = new Container();

    }


    //getters and setters

    public int getX() { return x;}
    public int getY() { return y;}
    public boolean getHasContainer() { return hasContainer;}
    public boolean getHasNPC() { return hasNPC;}
    public boolean getHasPlayer() { return hasPlayer;}
    public Container getContainer() { return container;}
    public boolean getIsEmptyTile() { return isEmptyTile;}


    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setHasContainer(boolean hasContainer) { this.hasContainer=hasContainer;}
    public void setHasNPC(boolean hasNPC) { this.hasNPC=hasNPC;}
    public void setHasPlayer(boolean hasPlayer) { this.hasPlayer=hasPlayer;}
    public void setEmptyTile(boolean isEmptyTile) { this.isEmptyTile= isEmptyTile;}
    public void setItems(Items items) { this.items = items;}
}
