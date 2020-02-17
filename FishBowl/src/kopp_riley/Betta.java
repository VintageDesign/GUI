package kopp_riley;


/***********************************************************************************************
 * @author Riley Kopp
 * Betta Initialization
 *
 * This acts as the Pirrana Bonus assignment, I just wanted to be different and call it a Betta
 **********************************************************************************************/
public class Betta extends Fish {

    Betta(){
        visited         = false;
        type            = "Betta";
        health          = 15;
        hunger          = 0;
        healthLossRate  = 1;
        hungerRate      = 10;
        hungerThreshold = 90;
    }

}
