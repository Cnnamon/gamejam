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
    static final int MIN_VERT_DIST_BETWEEN_PLATFORMS = 80;
    static final int LEVELS = 7;
    static final int BUFFER = 20;
    static final int HEIGHT = (Assets.screenSizeHeight - 2 * BUFFER) / LEVELS;

    static void generate() {
        int minGapWidth = 60;
        int maxGapWidth = 300;
        int h = 32;

        int y = BUFFER;

        for (int i = 0; i < LEVELS; i++) {
            Random rand = new Random();
            int x;
            y += HEIGHT;
            x = 0;

            x += rand.nextInt(maxGapWidth/2 - minGapWidth);
            x += drawPlatform(x, y, h);

            while (x < Assets.screenSizeWidth*3) {
                x += minGapWidth + rand.nextInt(maxGapWidth - minGapWidth);

                x += drawPlatform(x, y, h);
            }
        }

    }

    private static int drawPlatform(int x, int y, int h) {
        Random rand = new Random();

        int w = MIN_PLATFORM_WIDTH + rand.nextInt(MAX_PLATFORM_WIDTH - MIN_PLATFORM_WIDTH);
        int platformY = y - (HEIGHT - MIN_VERT_DIST_BETWEEN_PLATFORMS) / 2 + rand.nextInt(HEIGHT - MIN_VERT_DIST_BETWEEN_PLATFORMS);

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
