package STE.Map;

import java.util.ArrayList;

public class Room {

    private String type; //will display the room's purpose
    private int danger; //determines chance of enemies
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private ArrayList<Tile> tiles; //all tiles
    private Tile playerTile;
    private int size;
    boolean isStory;

    public Room(String type, int size, int danger, boolean isStory) {
        this.type = type;
        this.size = size;
        this.danger = danger;
        this.isStory = isStory;

        x = new ArrayList<Integer>(size);
        y = new ArrayList<Integer>(size);
        tiles = new ArrayList<Tile>(size*size);

        create();
    }
//=====================================================================================
    //creates the room
    private void create(){
        createAxis(x);
        createAxis(y);

        for(int i=0;i<y.size();i++){
            for(int j=0;j<x.size();j++){
                tiles.add(new Tile(j,i,this));
            }
        }

    }

    //gets tile (you need to use tempTile if you want to access the tile)
    public Tile getTile(int x, int y){
        Tile tempTile = null;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getX() == x && tiles.get(i).getY() == y) {
                tempTile = tiles.get(i);
            }
        }
        return tempTile;
    }
    public Tile getPlayerTile(){
        Tile tempTile = null;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getHasPlayer() == true) {
                tempTile = tiles.get(i);
            }
        }
        return tempTile;
    }

    public ArrayList<Tile> getContainerTiles(){
        ArrayList<Tile> tempTile1 = new ArrayList<Tile>();
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getHasContainer() == true) {
                tempTile1.add(tiles.get(i));
            }
        }
        return tempTile1;
    }


    //====================================================
    //private

    //makes the rows
    private void createAxis(ArrayList<Integer> c){
        for(int i=0;i<size;i++){
            c.add(i);
        }
    }

    // simple getters and setters
    public String getType() { return this.type;}
    public int getDanger() { return this.danger;}
    public int getSize() {return this.size;}
    public ArrayList<Integer> getX(){ return this.x;}
    public ArrayList<Integer> getY(){ return this.y;}
    public boolean getIsStory() { return this.isStory;}
    public ArrayList<Tile> getTiles(){ return this.tiles;}

    
}
