package STE.map;

import STE.item.item;
import STE.item.items;

import java.util.ArrayList;
import java.util.Random;

public class roomGen {

    private Random random;
    private ArrayList<Integer> candidateTilesIndex;
    private int defaultSlotNumber = 30;
    private items items;

    public roomGen(){
        random = new Random();
    }

    public void generateContainers(room room,int contChance){
        getCandidateContainers(room,contChance);
        makeToContainers(room);
        generateContainerItems(room, items);

        //reset candidateTilesIndex
        candidateTilesIndex = null;

        System.out.println("generated "+room.getType());
    }

    //private methods

    //containers
    private void getCandidateContainers(room room, int contChance){
        //contChance is the chance that a tile is made into a container.
        //if contChance is below or = to result, tile is made to a container
        //contChance can only be between 0-1000

        ArrayList<tile> tempTiles = room.getTiles();
        candidateTilesIndex = new ArrayList<Integer>();

        for(int i = 0; i<tempTiles.size(); i++){
            int result = random.nextInt(1001);
            if(contChance>=result){
                if(tempTiles.get(i).getIsEmptyTile()){
                    candidateTilesIndex.add(i);
                }
            }
        }
    }

    private void makeToContainers(room room){
        System.out.println("making container tiles in: "+room.getType());
        for(int i = 0; i<candidateTilesIndex.size(); i++){
            room.getTiles().get(candidateTilesIndex.get(i)).setHasContainer(true);
            room.getTiles().get(candidateTilesIndex.get(i)).createContainer(defaultSlotNumber);
        }
    }

    //*** add custom options for item generation
    //***also factor in item rarity
    private void generateContainerItems(room room,items items){
        System.out.println("generating items in containers in: "+room.getType());

        for(int i =0;i<room.getContainerTiles().size();i++){
            int items_to_add = random.nextInt(defaultSlotNumber);
            for(int j = 0; j<=items_to_add;j++){
                item tempItem = items.allItemsList.get(random.nextInt(items.allItemsList.size()));
                room.getContainerTiles().get(i).getContainer().addItem(tempItem);
            }
        }
    }


    //getters and setters
    public int getDefaultSlotNumber(){ return this.defaultSlotNumber;}

    public void setDefaultSlotNumber(int defaultSlotNumber) { this.defaultSlotNumber=defaultSlotNumber;}
    public void setItems(items items) {this.items = items;}

}
