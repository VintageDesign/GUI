package kopp_riley;

public class Tile {
    private Fish fish;

    Tile(){

    }

    void newFish(Integer action){
        switch (action){
            case 0:
            case 1:
                fish = new Fish();
                break;
            case 3:
                fish = null;
                break;
        }
    }
}
