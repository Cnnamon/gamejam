package epic.platformer.game;


import java.util.ArrayList;

/**
 * Created by god on 15.1.24.
 */
public class Engine {

    private Platformer game;
    private Player player;

    private ArrayList<Mob> mobList;

    private final int snailId = 0;

    private final int snailSpawnY = Assets.screenSizeHeight - 100;
    private final int snailSpawnX = Assets.screenSizeWidth / 4;

    public Engine(Platformer game){
        this.game = game;
        mobList = new ArrayList<Mob>();
        player = new Player(40, 100, 16, 16, Assets.sprite1);
        //mobList.add(new Snail(snailSpawnX,snailSpawnY, ));

    }

    public void addMob(Mob mob, int x, int y){
       // mobList.add();
        mobList.add(mob);

    }

    public void update(){
        //updating cycle



    }
}
