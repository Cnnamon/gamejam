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

    private final int snailSpawnY = Assets.screenSizeHeight / 2;
    private final int snailSpawnX = Assets.screenSizeWidth / 2;
    private final int snailWidth = 16;
    private final int snailHeight = 16;

    public Engine(Platformer game){

        this.game = game;
        mobList = new ArrayList<Mob>();
        player = new Player(500, 1000, 50, 50, Assets.playerSprite);
        World.player = player;
        player.group = 2;
        mobList.add(new Snail(snailSpawnX, snailSpawnY, snailWidth, snailHeight, Assets.enemySprite));
        //for(CollisionObject o in Map.){

        //}
        World.addRect(new CollisionObject(50, 250, 500, 16, 1));
        World.addRect(new CollisionObject(550, 100, 50, 16, 1));
        World.addRect(new CollisionObject(0, 0, Assets.screenSizeWidth, 16, 1));

        Relations.addCollision(1, 2);
        Relations.addCollision(2, 1);
        Relations.addCollision(1, 1);

    }

    public void addMob(Mob mob, int x, int y){
       // mobList.add();

        mobList.add(mob);

    }

    public void update(float Delta){
        //updating cycle

        //chasing player


        for (Mob b: mobList){
            b.update(Delta);
        }

        player.update(Delta);

    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Mob> getMobList() {
        return mobList;
    }

}
