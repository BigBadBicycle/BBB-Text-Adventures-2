package STE.item;

public class items {

    //Valuable variables :)))) so silly
    final private int VERY_COMMON = 1;
    final private int COMMON = 2;
    final private int UNCOMMON = 3;
    final private int RARE = 4;
    final private int STORY = 5;

    //=====================================================================================
    public item banana = new consumable("Banana", COMMON, 1, 2, true);
    public item coffee = new consumable("Coffee",COMMON,1,4, false);
    public item tomato_soup = new consumable("Tomato Soup",UNCOMMON,1,5, true);
}
