package kopp_riley;

public class Betta extends Fish {

    Betta(){
        type            = "Betta";
        health          = 15;
        hunger          = 0;
        healthLossRate  = 1;
        hungerRate      = 10;
        hungerThreshold = 90;
    }

    @Override
    public Integer newDay() {
        // Move randomly

        return super.newDay();
    }
}
