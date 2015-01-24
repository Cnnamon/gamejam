package epic.platformer.game;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by god on 15.1.24.
 */
public class Engine {

    private Platformer game;
    public static Player player;

    private static ArrayList<Mob> mobList;

    private final int snailId = 0;

    private final int snailSpawnY = Assets.screenSizeHeight / 2;
    private final int snailSpawnX = Assets.screenSizeWidth / 2;
    private final int snailWidth = 16;
    private final int snailHeight = 16;

    public Engine(Platformer game){

        this.game = game;
        mobList = new ArrayList<Mob>();
        player = new Player(400, 400, 50, 50, Assets.playerSprite);
        World.player = player;
        player.group = 2;
        mobList.add(new Snail(snailSpawnX, snailSpawnY, snailWidth, snailHeight, Assets.enemySprite));
        for(int i = 0; i < 1000; i++)
        {
            Random rand = new Random();
            Bat tempBat = new Bat(Assets.screenSizeHeight / 2 + rand.nextInt(2000), Assets.screenSizeWidth / 2 + rand.nextInt(2000), 16, 16, Assets.enemySprite);
            tempBat.speed = 1 + rand.nextFloat()%5;
            mobList.add(tempBat);
        }
        //for(CollisionObject o in Map.){

        //}
        //Todo delete these before launch
        World.addRect(new CollisionObject(50, 250, 500, 16, 1));
        World.addRect(new CollisionObject(550, 100, 50, 16, 1));
        World.addRect(new CollisionObject(0, 0, Assets.screenSizeWidth * 3, 16, 1));

        //Required for working. Do not touch
        Relations.addCollision(1, 2);
        Relations.addCollision(2, 1);
        Relations.addCollision(1, 1);
        Relations.addCollision(3, 0);


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

    static public ArrayList<Mob> getMobList() {
        return mobList;
    }

}
