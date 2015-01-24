package epic.platformer.game;


import java.util.ArrayList;

/**
 * Created by god on 15.1.24.
 */
public class Engine {

    private Platformer game;
    private Player player;

    private ArrayList<Mob> mobList;

    public Engine(Platformer game){
        this.game = game;
        mobList = new ArrayList<Mob>();
        player = new Player(40, 100, 16, 16, Assets.sprite1);

    }

    private void addMob(Mob mob, int x, int y){
       // mobList.add();
    }
}
