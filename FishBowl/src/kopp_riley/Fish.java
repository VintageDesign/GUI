package kopp_riley;

public abstract class Fish {
    protected String   type;
    protected Integer  health;
    protected Integer  hunger;
    protected Integer  healthLossRate;
    protected Integer  hungerRate;
    protected Integer  hungerThreshold;

    void feedFish(Integer amt){
        hunger -= amt;
        return;
    }

    void newDay(){
        hunger += hungerRate;
        if(hunger < hungerThreshold){
            health -= healthLossRate;
        }
        else {
            health -= (2 * healthLossRate);
        }

        if( hunger > 100)
        {
            hunger = 100;
        }
    }

    public Integer getHealth() {
        return health;
    }
    public String  getType(){ return type;}
    public Integer getHunger() {
        return hunger;
    }
}
