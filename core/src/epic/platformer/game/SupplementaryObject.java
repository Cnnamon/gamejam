package epic.platformer.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.Random;

/**
 * Created by god on 15.1.25.
 */
public class SupplementaryObject extends CollisionObject{
    private Sprite icon;
    private int power;
    Random random;

    public SupplementaryObject(float x, float y, float width, float height, int group, Sprite icon){
        super(x, y, width, height, 1);
        random = new Random();
        power = random.nextInt(1);

    }

    //effects:

    private void getPower(Player player){
        switch (power){
            case 1:
                player.x = random.nextInt(Assets.gameMapWidth);
                player.y = random.nextInt(Assets.gameMapHeight);

                CollisionObject collider = null;
                for(CollisionObject obj: World.rectList){
                    if(player.overlaps(obj)){
                        collider = obj;
                    }
                }
                while(player.overlaps(collider)) player.y++;

        }

    }

}
