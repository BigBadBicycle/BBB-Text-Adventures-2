package STE.item;

import STE.universalVariables;

public class weapons {

   final private int DEFAULT_DURABILITY = 100;

   universalVariables uV = new universalVariables();

   //=====================================================================================
   public weapon throwing_spear = new rangedWeapon("Throwing Spear",uV.RARE,10,DEFAULT_DURABILITY, 50);

}
