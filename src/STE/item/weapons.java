package STE.item;

public class weapons {

   final private int DEFAULT_DURABILITY = 100;

   //Valuable variables; copied from items because too lazy to make this code good :p
   final private int VERY_COMMON = 1;
   final private int COMMON = 2;
   final private int UNCOMMON = 3;
   final private int RARE = 4;
   final private int STORY = 5;

   public weapon throwing_spear = new rangedWeapon("Throwing Spear",RARE,10,DEFAULT_DURABILITY, 50);

}
