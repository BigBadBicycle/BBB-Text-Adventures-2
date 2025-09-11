package STE.Item;

import java.util.ArrayList;

public class Items {
    public ArrayList<Item> allItemsList;
    public ArrayList<Item> veryCommonItemsList;
    public ArrayList<Item> commonItemsList;
    public ArrayList<Item> uncommonItemsList;
    public ArrayList<Item> rareItemsList;

    public Item findItemByName(Item item){
        Item tempitem = null;
        for (int i = 0; i < allItemsList.size(); i++) {
            if (allItemsList.get(i).getName() == item.getName()) {
                tempitem = allItemsList.get(i);
            }
        }
        return tempitem;
    }
}
