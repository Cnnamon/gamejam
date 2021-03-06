package epic.platformer.game;


import com.badlogic.gdx.graphics.Color;
import screens.GameOverScreen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by god on 15.1.24.
 */
public class Engine {

    private Platformer game;
    public static Player player;

    private Color defaultColor;
    private boolean colorIsRestored;

    GameOverScreen gameOverScreen;


    private static ArrayList<Mob> mobList;

    private int lastTime = 0;
    private final int snailId = 0;

    private final int snailSpawnY = Assets.screenSizeHeight / 2;
    private final int snailSpawnX = Assets.screenSizeWidth / 2;
    private final int snailWidth = 16;
    private final int snailHeight = 16;

    public Engine(Platformer game){

        this.game = game;
        mobList = new ArrayList<Mob>();
        player = new Player(400, 400, 48, 40, Assets.playerSprite);
        World.player = player;
        player.group = 2;
        Random rand = new Random();
        for(int i = 0; i < 5; i++)
        {
            Bat tempBat = new Bat(Assets.screenSizeHeight / 2 + rand.nextInt(2000), Assets.screenSizeWidth / 2 + rand.nextInt(2000), Assets.batSprite.getWidth()-70, Assets.batSprite.getHeight()-50, Assets.snailSprite);
            tempBat.speed = 1 + rand.nextFloat()%5;
            mobList.add(tempBat);
        }
        //for(CollisionObject o in Map.){

        //}
        // Bottom border.
//        World.addRect(new CollisionObject(0, 0, Assets.screenSizeWidth * 3, 16, 1));

        //Required for working. Do not touch
        Relations.addCollision(1, 2);
        Relations.addCollision(2, 1);
        Relations.addCollision(1, 1);
        Relations.addCollision(2, 3);
        Relations.addCollision(3, 2);


        defaultColor = new Color(game.batch.getColor());
        colorIsRestored = true;
    }

    public void addMob(Mob mob, int x, int y){
       // mobList.add();

        mobList.add(mob);

    }

    public void update(float Delta){
        // Test player-enemy collision
        //ArrayList<Mob> deleteMobs = ArrayList<Mob>();
        for(Iterator iterator = mobList.iterator(); iterator.hasNext(); )
        {
            Mob mob = (Mob)iterator.next();
            if(mob instanceof Kicker && mob.inAir){ //remove kickers if they fall ;/
                //mobList.indexOf(mob);
                //iterator.remove();
            }else {
                if (player.overlaps(mob) && mob.dealsDmg) {
                    player.damage(1);
                }

                if (player.overlaps(mob) && mob instanceof Kicker) {
                    player.getKicked(/*needs direction!!!!*/);
                }
            }
        }

        if(!player.isAlive())
        {
            // Exit everything, he fucking died. GAME OVER SCREEN.
            gameOverScreen = new GameOverScreen(game, GameScreen.score); // Dominykas FTW
		    game.setScreen(gameOverScreen);
        }
        //updating cycle

        //chasing player
        if(lastTime != GameScreen.getTimeLeft()){
            lastTime = GameScreen.getTimeLeft();
            Random rn = new Random();
            mobList.add(new Kicker(Assets.snailSprite.getWidth(), Assets.snailSprite.getHeight(), Map.platforms.get(rn.nextInt(Map.platforms.size())).getCollisionObject()));
            mobList.get(mobList.size()-1).group = 1;

            for(int i=0; i<GameScreen.level; i++) { // levelis
                mobList.add(new Snail(Assets.snailSprite.getWidth(), Assets.snailSprite.getHeight(), Assets.snailSprite, Map.platforms.get(rn.nextInt(Map.platforms.size())).getCollisionObject()));
            }
        }

        for (Mob b: mobList){
            b.update(Delta);
        }

        player.update(Delta);
        if(!player.isInDamageCooldown())
        {
            colorIsRestored = false;
            float colorRatio = (float) player.timeAfterDamage() / (float)player.damageEveryMills;
            float cooldownRatio = (float) player.damageCooldown() / (float)player.damageEveryMills;
            game.batch.setColor(1, defaultColor.g * colorRatio, defaultColor.b * colorRatio, 1);
        }
        else if (!colorIsRestored)
        {
            game.batch.setColor(defaultColor);
            defaultColor = new Color(game.batch.getColor());
        }
    }


    public Player getPlayer() {
        return player;
    }

    static public ArrayList<Mob> getMobList() {
        return mobList;
    }
}
