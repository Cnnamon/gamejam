package epic.platformer.game;

import java.util.Random;

/**
 * Created by god on 15.1.1.
 */
public class Map {

    static void generate() {
//        Rects.addRect(new CollisionObject(160, 320, 600, 32));

        int levels = 7;
        int buffer = 20;
        int maxWidth = 300;
        int minWidth = 50;
        int h = 10;

        int height = (Assets.screenSizeHeight - buffer) / levels;


        int y = 0;
        for (int i = 0; i < levels; i++) {
            Random rand = new Random();
            int x, w;
            y += height;
            x = 0;


            while (x < Assets.screenSizeWidth) {
                w = rand.nextInt(maxWidth);
                Rects.addRect(new CollisionObject(x, y, w, h));

                x += w + minWidth + rand.nextInt(maxWidth - minWidth);
            }

        }

    }
}
