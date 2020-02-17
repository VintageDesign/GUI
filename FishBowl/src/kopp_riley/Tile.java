package kopp_riley;

/***************************************************************************************************
 * @author Riley Kopp
 * The tile class
 **************************************************************************************************/
public class Tile {
    private Fish fish;

    Tile(){
        // Intentionally left Empty
    }


    /***************************************************************************************************
     * adds or removes the fish from the tile
     **************************************************************************************************/
    void newFish(Integer action){
        switch (action){
            case 0:
                fish = new GoldFish();
                break;
            case 1:
                fish = new AngelFish();
                break;
            case 2:
                fish = new Betta();
                break;
            case 3:
                fish = null;
                break;
        }
    }

    public Fish getFish() {
        return fish;
    }
    public void setFish(Fish newFish) {
        try {
            fish = (Fish) newFish.clone();
        }
        catch (CloneNotSupportedException e ){

        }
    }

}
