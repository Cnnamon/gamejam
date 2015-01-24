package epic.platformer.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.media.sound.SoftMixingDataLine;

import java.util.ArrayList;

/**
 * Created by god on 15.1.24.
 */
public class Rects {

    public static int worldType; //todo implement enum for different world types (for better perception)
    /*
    *Possible world types:
    * 1. Normal (nothing out of the ordinary)
    * 2. Space  (less gravity)
    * 3. Fire   (lava at the bottom, gets hot the closer you are to it
    * 4. Frost  (Gets cold unless you constantly move)
    *
     */

    public static ArrayList<CollisionObject> rectList = new ArrayList<CollisionObject>();

    public static void addRect(CollisionObject object){
        rectList.add(object);
    }

    public static void drawRect(SpriteBatch batch, CollisionObject object){
        float middle = object.width - 16*2;
        int x = 0;
        while(middle > 0){
            batch.draw(Assets.sprite3, object.x + 16 + x, object.y);
            x += 16;
            middle -= 16;
        }
        batch.draw(Assets.sprite3, object.x, object.y);
        batch.draw(Assets.sprite3, object.x+x, object.y);
        batch.draw(Assets.sprite1, object.x, object.y);
    }
}
