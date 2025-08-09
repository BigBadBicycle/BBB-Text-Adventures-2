package STE.map;

import STE.item.item;
import STE.item.items;

import java.util.ArrayList;
import java.util.Random;

public class roomGen {

    private Random random;
    private ArrayList<Integer> candidateTilesIndex;
    private int defaultSlotNumber = 30;

    roomGen(){
        random = new Random();
    }

    public void generateContainers(room room,int contChance){
        getCandidateContainers(room,contChance);
        makeToContainers(room);
        generateContainerItems(room);

        //reset candidateTilesIndex
        candidateTilesIndex = null;

        System.out.println("generated "+room.getType());
    }

    //private methods

    //containers
    private void getCandidateContainers(room room, int contChance){
        //contChance is the chance that a tile is made into a container.
        //if contChance is below or = to result, tile is made to a container

        ArrayList<tile> tempTiles = room.getTiles();
        candidateTilesIndex = new ArrayList<Integer>();

        for(int i = 0; i<tempTiles.size(); i++){
            int result = random.nextInt(1001);
            System.out.println(result);
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
    private void generateContainerItems(room room){
        System.out.println("generating items in containers in: "+room.getType());

        for(int i =0;i<room.getContainerTiles().size();i++){
            int items_to_add = random.nextInt(defaultSlotNumber);
            for(int j = 0; j<=items_to_add;j++){
                items allItems = new items();
                item tempItem = allItems.allItemsList.get(random.nextInt(allItems.allItemsList.size()));
                room.getContainerTiles().get(i).getContainer().addItem(tempItem);
            }
        }
    }


    //getters and setters
    public int getDefaultSlotNumber(){ return this.defaultSlotNumber;}

    public void setDefaultSlotNumber(int defaultSlotNumber) { this.defaultSlotNumber=defaultSlotNumber;}

}
