package kopp_riley;

/***************************************************************************************************
 * @author Riley Kopp
 * AngleFish class
 **************************************************************************************************/
public class AngelFish extends Fish{

    /**********************************************************************************************
     * Basic Constructor for the AngelFish
     *********************************************************************************************/
    AngelFish(){
        visited         = false;
        type            = "AngleFish";
        health          = 10;
        hunger          = 0;
        healthLossRate  = 1;
        hungerRate      = 20;
        hungerThreshold = 90;
    }
}
