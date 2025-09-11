package STE.Map;

import STE.Variables.UniversalVariables;
import STE.Item.Item;
import STE.Item.Items;

import java.util.ArrayList;
import java.util.Random;

public class RoomGen {

    private Random random;
    private ArrayList<Integer> candidateTilesIndex;
    private Items items;
    UniversalVariables uV;

    public RoomGen(){
        random = new Random();
        uV = new UniversalVariables();
        this.items = uV.gameItems;
    }

    public void generateContainers(Room room, int contChance){
        getCandidateContainers(room,contChance);
        makeToContainers(room);
        generateContainerItems(room, items);

        //reset candidateTilesIndex
        candidateTilesIndex = null;

        System.out.println("generated "+room.getType());
    }

    //private methods

    //containers
    private void getCandidateContainers(Room room, int contChance){
        //contChance is the chance that a tile is made into a container.
        //if contChance is below or = to result, tile is made to a container
        //contChance can only be between 0-1000

        ArrayList<Tile> tempTiles = room.getTiles();
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

    private void makeToContainers(Room room){
        System.out.println("making container tiles in: "+room.getType());
        for(int i = 0; i<candidateTilesIndex.size(); i++){
            room.getTiles().get(candidateTilesIndex.get(i)).createContainer();
        }
    }

    //*** add custom options for item generation
    //***also factor in item rarity
    private void generateContainerItems(Room room, Items items){
        System.out.println("generating items in containers in: "+room.getType());

        for(int i =0;i<room.getContainerTiles().size();i++){
            int items_to_add = random.nextInt(uV.SLOT_AMOUNT);
            for(int j = 0; j<=items_to_add;j++){
                Item tempItem = items.allItemsList.get(random.nextInt(items.allItemsList.size()));
                room.getContainerTiles().get(i).getContainer().addItem(tempItem);
            }
        }
    }

}
