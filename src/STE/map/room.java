package STE.map;

import java.util.ArrayList;
import java.util.Objects;

public class room {

    private String type; //will display the room's purpose
    private int danger; //determines chance of enemies
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private ArrayList<tile> tiles; //all tiles
    private int size;
    boolean isStory;

    public room(String type,int size,int danger,boolean isStory) {
        this.type = type;
        this.size = size;
        this.danger = danger;
        this.isStory = isStory;

        x = new ArrayList<Integer>(size);
        y = new ArrayList<Integer>(size);
        tiles = new ArrayList<tile>(size*size);

        create();
    }

    //creates the room
    private void create(){
        createAxis(x);
        createAxis(y);

        for(int i=0;i<y.size();i++){
            for(int j=0;j<x.size();j++){
                tiles.add(new tile(j,i,this));
            }
        }

        System.out.println("created room!");

    }

    //makes the rows
    private void createAxis(ArrayList<Integer> c){
        for(int i=0;i<size;i++){
            c.add(i);
        }
    }

    //gets tile (you need to use tempTile if you want to access the tile)
    public tile getTile(int x, int y){
            tile tempTile = null;
            for (int i = 0; i < tiles.size(); i++) {
                if (tiles.get(i).getCords().get(0) == x && tiles.get(i).getCords().get(1) == y) {
                    tempTile = tiles.get(i);
                }
            }
            return tempTile;
    }

    //getters and setters
    public String getType() { return this.type;}
    public int getDanger() { return this.danger;}
    public int getSize() {return this.size;}
    public ArrayList<Integer> getX(){ return this.x;}
    public ArrayList<Integer> getY(){ return this.y;}
    public boolean getIsStory() { return this.isStory;}
    public ArrayList<tile> getTiles(){ return this.tiles;}

    
}
