package epic.platformer.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by god on 15.1.1.
 */
public class Map {

    static final List<Platform> platforms = new ArrayList<Platform>();
    static final int MIN_PLATFORM_WIDTH = 85;
    static final int MAX_PLATFORM_WIDTH = 300;
    static final int MIN_VERT_DIST_BETWEEN_PLATFORMS = 100;
    static final int BUFFER = 20;
    static final int HEIGHT = 110;

    static void generate() {
        int minGapWidth = 80;
        int maxGapWidth = 380;
        int h = 32;

        int y = BUFFER;

        while (y < Assets.screenSizeHeight * 3) {
            Random rand = new Random();
            int x;
            y += HEIGHT;
            x = 0;

            x += rand.nextInt(maxGapWidth / 2 - minGapWidth);
            x += drawPlatform(x, y, h);

            while (x < Assets.screenSizeWidth * 3) {
                x += minGapWidth + rand.nextInt(maxGapWidth - minGapWidth);

                x += drawPlatform(x, y, h);
            }
        }

        World.addRect(new CollisionObject(0, 0, 32, Assets.screenSizeHeight * 4, 1));
        World.addRect(new CollisionObject(Assets.screenSizeWidth * 3, 0, 32, Assets.screenSizeHeight * 4, 1));

        switch(World.worldType){
            case 1: //fire
                World.addRect(new CollisionObject(0,0,Assets.screenSizeWidth*3, 32, 1));
                break;
            case 2: //

            case 3:

            case 4:

            default:
                World.addRect(new CollisionObject(0,0,Assets.screenSizeWidth*3, 32, 1));
                break;
        }
    }

    private static int drawPlatform(int x, int y, int h) {
        Random rand = new Random();

        int w = MIN_PLATFORM_WIDTH + rand.nextInt(MAX_PLATFORM_WIDTH - MIN_PLATFORM_WIDTH);
        int platformY = y - (HEIGHT - MIN_VERT_DIST_BETWEEN_PLATFORMS) / 2 + rand.nextInt(HEIGHT - MIN_VERT_DIST_BETWEEN_PLATFORMS);
        if (x > Assets.screenSizeWidth * 3)
            return 0;
        if (x + w > Assets.screenSizeWidth * 3)
            w = Assets.screenSizeWidth * 3 - x;
        CollisionObject colObj = new CollisionObject(x, platformY, w, h, 1);
        World.addRect(colObj);

        if (rand.nextDouble() < .5)
            platforms.add(new Platform(colObj, 2));

        return w;
    }

    public static void updateMovingPlatforms(float delta) {
        for (Platform platform : platforms) {
            platform.update(delta);
        }
    }
}
