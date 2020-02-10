package kopp_riley;

public class Tile {
    private Fish fish;

    Tile(){

    }

    void newFish(Integer action){
        switch (action){
            case 0:
                fish = new GoldFish();
                break;
            case 1:
                fish = new AngelFish();
                break;
            case 3:
                fish = null;
                break;
        }
    }
}