package epic.platformer.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.Random;

/**
 * Created by god on 15.1.25.
 */
public class SupplementaryObject extends CollisionObject{
    private Sprite icon;

    public SupplementaryObject(float x, float y, float width, float height, int group, Sprite icon){
        super(x, y, width, height, 1);

    }

    //effects:

    private void teleportPower(Player player){
        Random random = new Random();

    }

}
