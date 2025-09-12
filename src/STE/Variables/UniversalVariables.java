package STE.Variables;

import placeholderGameName.gameItems.GameItems;

public class UniversalVariables {

    //===============================================
    public GameItems gameItems;
    public final int SLOT_AMOUNT =30;

    public UniversalVariables(){
    }

    public void createGameItems(){
        gameItems = new GameItems();
    }

}
