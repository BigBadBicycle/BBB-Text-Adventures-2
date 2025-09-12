package STE.Map;

import STE.Inventory.Container;

public class Tile {

    private int x;
    private int y;
    private String tileSymbol;
    private boolean hasContainer;
    private Container container;

    private boolean hasNPC;
    private boolean hasPlayer;
    private boolean isEmpty;
    private boolean hasWall;
    private boolean hasDoor;
    private boolean hasBarricade;


    //add a wall tile, door tile, half wall tile (barricade)
    Room room;
    public Tile(int column, int row, Room room){

        isEmpty = true;
        hasNPC = false;
        hasPlayer = false;
        hasWall = false;
        hasContainer = false;
        hasDoor = false;
        hasBarricade = false;


        this.x = column;
        this.y = row;
        this.room = room;
        checkTile();

    }

    public void checkTile(){
        if(hasContainer){
            changeTile("c",false);
        }else if(hasNPC){
            changeTile("n",false);
        } else if(hasPlayer){
            changeTile("P",false);
        } else if(hasWall){
            changeTile("|",false);
        } else if(hasBarricade){
            changeTile("b",false);
        } else if(hasDoor){
            changeTile("d",false);
        } else{
            changeTile(" ",true);
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

    //private methods
    private void changeTile(String symbol, boolean isEmptyTile){
        this.isEmpty = isEmptyTile;
        if(symbol!="P" && hasPlayer==true){
            symbol =symbol.toUpperCase();
        }
        tileSymbol = "["+symbol+"]";
    }


    //getters and setters

    public int getX() { return x;}
    public int getY() { return y;}
    public boolean getHasContainer() { return hasContainer;}
    public boolean getHasNPC() { return hasNPC;}
    public boolean getHasWall() {return this.hasWall;}
    public boolean getHasDoor() {return this.hasDoor;}
    public boolean getHasBarricade() {return this.hasBarricade;}
    public boolean getHasPlayer() { return hasPlayer;}
    public Container getContainer() { return container;}
    public boolean getIsEmpty() { return isEmpty;}


    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public void setHasContainer(boolean hasContainer) { this.hasContainer=hasContainer;}
    public void setHasNPC(boolean hasNPC) { this.hasNPC=hasNPC;}
    public void setHasPlayer(boolean hasPlayer) { this.hasPlayer=hasPlayer;}
    public void setEmpty(boolean isEmptyTile) { this.isEmpty = isEmptyTile;}
}
