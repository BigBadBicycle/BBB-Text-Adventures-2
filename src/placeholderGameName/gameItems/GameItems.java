package placeholderGameName.gameItems;

import STE.Variables.ItemVariables;
import STE.Item.Consumable;
import STE.Item.Item;
import STE.Item.Items;

import java.util.ArrayList;

public class GameItems extends Items {

    private ItemVariables uV= new ItemVariables();

    //=====================================================================================
    public Item banana = new Consumable("Banana", uV.COMMON, 1, 2, true);
    public Item coffee = new Consumable("Coffee",uV.COMMON,1,4, false);
    public Item tomato_soup = new Consumable("Tomato Soup",uV.UNCOMMON,1,5, true);

    public Item gold_coin = new Item("Gold Coin", uV.RARE, 1);
    //=====================================================================================

    public GameItems(){
        //========
        allItemsList = new ArrayList<Item>();

        allItemsList.add(banana);
        allItemsList.add(coffee);
        allItemsList.add(tomato_soup);

        //========
        veryCommonItemsList = new ArrayList<Item>();


        //========
        commonItemsList = new ArrayList<Item>();

        commonItemsList.add(banana);
        commonItemsList.add(coffee);
        //========
        uncommonItemsList = new ArrayList<Item>();


        //========
        rareItemsList = new ArrayList<Item>();

        //========
    }

}
