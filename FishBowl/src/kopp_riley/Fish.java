package kopp_riley;



/***********************************************************************************************
 * @author Riley Kopp
 * The base class for all fish instances
 **********************************************************************************************/
public abstract class Fish implements Cloneable{
    protected String   type;
    protected Integer  health;
    protected Integer  hunger;
    protected Integer  healthLossRate;
    protected Integer  hungerRate;
    protected Integer  hungerThreshold;
    protected Boolean  visited;


    /***********************************************************************************************
     * Removes the amount fed from hunger
     **********************************************************************************************/
    void feedFish(Integer amt){
        hunger -= amt;
        if (hunger < 0 ) hunger = 0;
        return;
    }

    /***********************************************************************************************
     * Applies health loss and hunger gain
     **********************************************************************************************/
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

    /***********************************************************************************************
     * getters
     **********************************************************************************************/
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
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
