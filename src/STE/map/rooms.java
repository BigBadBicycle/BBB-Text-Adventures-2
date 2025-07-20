package STE.map;

public class rooms {

    //good variables
    //room size
    private final int TINY = 2;
    private final int SMALL = 3;
    private final int REGULAR = 4;
    private final int BIG = 5;
    private final int LARGE = 6;
    private final int MASSIVE =7;

    //story
    private final boolean NOT_STORY = false;
    private final boolean IS_STORY = true;

    //dangers
    private final int NO_DANGER = 0;
    private final int MINOR_DANGER = 1;
    private final int SOME_DANGER = 2;
    private final int DANGER = 3;
    private final int DANGEROUS = 4;
    private final int EXTREMELY_DANGEROUS =5;
    //===============================================

    public room start_room = new room("start room",SMALL,NO_DANGER,NOT_STORY);

}
