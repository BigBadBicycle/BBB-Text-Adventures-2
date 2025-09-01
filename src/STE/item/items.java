package STE.item;

import STE.universalVariables;

import java.util.ArrayList;

public class items {

    private universalVariables uV = new universalVariables();
    public ArrayList<item> allItemsList;
    public ArrayList<item> veryCommonItemsList;
    public ArrayList<item> commonItemsList;
    public ArrayList<item> uncommonItemsList;
    public ArrayList<item> rareItemsList;

    //=====================================================================================
    public item banana = new consumable("Banana", uV.COMMON, 1, 2, true);
    public item coffee = new consumable("Coffee",uV.COMMON,1,4, false);
    public item tomato_soup = new consumable("Tomato Soup",uV.UNCOMMON,1,5, true);

    public item gold_coin = new item("Gold Coin", uV.RARE, 1);
    //=====================================================================================

    public items(){
        //========
        allItemsList = new ArrayList<item>();

        allItemsList.add(banana);
        allItemsList.add(coffee);
        allItemsList.add(tomato_soup);

        //========
        veryCommonItemsList = new ArrayList<item>();


        //========
        commonItemsList = new ArrayList<item>();

        commonItemsList.add(banana);
        commonItemsList.add(coffee);
        //========
        uncommonItemsList = new ArrayList<item>();


        //========
        rareItemsList = new ArrayList<item>();

        //========

    }

    public item findItemByName(item item){
        item tempitem = null;
        for (int i = 0; i < allItemsList.size(); i++) {
            if (allItemsList.get(i).getName() == item.getName()) {
                tempitem = allItemsList.get(i);
            }
        }
        return tempitem;
    }
}
