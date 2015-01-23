package epic.platformer.game;

/**
 * Created by god on 15.1.1.
 *
 */
public class Map {

    static void generate(int[][] world) {
        for (int i = 0; i < Assets.screenSizeWidth; i++) {
            for (int j = 0; j < Assets.screenSizeHeight; j++) {
                if (i == 0  || j == 0 || i >= Assets.screenSizeWidth-16 || j >= Assets.screenSizeHeight - 16) {
                    world[i][j] = 1;
                }
            }
        }

        for(int x=160;x<=640;x+=16){
            world[x][160] = 1;
        }
    }
}
