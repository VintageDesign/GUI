package kopp_riley;

public abstract class Fish {
    protected String   type;
    protected Integer  health;
    protected Integer  hunger;
    protected Integer  healthLossRate;
    protected Integer  hungerRate;
    protected Integer  hungerThreshold;
    protected Boolean  visited;

    void feedFish(Integer amt){
        hunger -= amt;
        if (hunger < 0 ) hunger = 0;
        return;
    }

    public Integer newDay(){
        hunger += hungerRate;
        if(hunger < hungerThreshold){
            health -= healthLossRate;
        }
        else {
            health -=  healthLossRate + 2;
        }

        if(health < 0){
            health = 0;
        }

        if( hunger > 100)
        {
            hunger = 100;
        }

        return health;
    }

    public Integer getHealth() {
        return health;
    }
    public String  getType(){ return type;}
    public Integer getHunger() {
        return hunger;
    }

    public Boolean isVisited(){
        return visited;
    }

    public void setVisited(Boolean flag){
        visited = flag;
    }
}
