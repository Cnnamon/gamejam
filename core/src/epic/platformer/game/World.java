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
    public static ArrayList<CollisionObject> rectList = new ArrayList<CollisionObject>();
    /*
    *Possible world types:
    * 1. Normal (nothing out of the ordinary)
    * 2. Space  (less gravity)
    * 3. Fire   (lava at the bottom, gets hot the closer you are to it
    * 4. Frost  (Gets cold unless you constantly move)
    *
     */
    static Sprite wall;
    static Sprite lCorner;
    static Sprite rCorner;

    public static void addRect(CollisionObject object) {
        rectList.add(object);
    }


    public static void changeWorld(int a) {
        worldType = a;
        switch (a) {
            case 1:
                wall = Assets.fireWall;
                lCorner = Assets.fireWallCorner;
                rCorner = Assets.fireWallRightCorner;
                gravity = 0.8f;
                break;
            case 2:
                wall = Assets.earthWall;
                lCorner = Assets.earthWallCorner;
                rCorner = Assets.earthWallRightCorner;
                gravity = 1f;
                break;
            case 3:
                wall = Assets.iceWall;
                lCorner = Assets.iceWallCorner;
                rCorner = Assets.iceWallRightCorner;
                gravity = 1.2f;
                break;
            case 4:
                wall = Assets.spaceWall;
                lCorner = Assets.spaceWallCorner;
                rCorner = Assets.spaceWallCorner;
                gravity = 0.4f;
                break;
            default:
                wall = Assets.earthWall;
                lCorner = Assets.earthWallCorner;
                rCorner = Assets.earthWallCorner;
                gravity = 1f;
                break;
        }
    }

    public static void drawRect(SpriteBatch batch, CollisionObject object) {
        float middle = object.width - 32 * 2;
        int x = 0;
        while (middle > 0) {
            batch.draw(wall, object.x + 32 + x, object.y);
            x += 32;
            middle -= 32;
        }
        middle = object.height - 32;
        int y = 0;
        while (middle > 0) {
            batch.draw(wall, object.x, object.y + 32 + y);
            y += 32;
            middle -= 32;
        }
        batch.draw(rCorner, object.x + object.width - 32, object.y);
        batch.draw(lCorner, object.x, object.y);
    }
}
