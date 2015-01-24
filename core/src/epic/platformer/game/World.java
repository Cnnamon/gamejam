package epic.platformer.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by god on 15.1.24.
 */
public class World {


    public static Player player;
    public static float gravity = 1.0F; //on world switch, change gravity
    public static int worldType = 1; //todo implement enum for different world types (for better perception)
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
        Sprite wall;
        Sprite corner;

        switch (worldType){
            case 1:
                wall = Assets.fireWall;
                corner = Assets.fireWallCorner;
                break;
            case 2:
                wall = Assets.earthWall;
                corner = Assets.earthWallCorner;
                break;
            case 3:
                wall = Assets.iceWall;
                corner = Assets.iceWallCorner;
                break;
            case 4:
                wall = Assets.spaceWall;
                corner = Assets.spaceWallCorner;
                break;
            default:
                wall = Assets.earthWall;
                corner = Assets.earthWallCorner;
        }

        float middle = object.width - 32*2;
        int x = 0;
        while(middle > 0){
            batch.draw(wall, object.x + 32 + x, object.y);
            x += 32;
            middle -= 32;
        }
        batch.draw(corner, object.x+x, object.y);
        batch.draw(corner, object.x, object.y);
    }
}
