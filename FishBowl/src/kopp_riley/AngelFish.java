package kopp_riley;

public class AngelFish extends Fish{
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
