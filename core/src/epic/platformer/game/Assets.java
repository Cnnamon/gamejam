package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by god on 14.12.31.
 */
public class Assets {


    public static Texture textureBack;
    public static Sprite spriteBack;
    public static Texture textureSheet;
    public static Sprite sprite1;
    public static Sprite sprite2;
    public static Sprite sprite3;
    public static Sprite sprite4;
    public static Sprite sprite5;
    public static Texture badLogic;
    public static int[][] world;

    public static int screenSizeWidth;
    public static int screenSizeHeight;

    public static void load(){
        textureBack = new Texture(Gdx.files.internal("Background.png"));
        textureBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        spriteBack = new Sprite(textureBack);
        spriteBack.flip(false, true);

        textureSheet = new Texture(Gdx.files.internal("Test sheet.png"));

        badLogic = new Texture(Gdx.files.internal("badlogic.jpg"));
        badLogic.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        sprite1 = new Sprite(textureSheet, 16*0, 0, 16, 16);
        sprite2 = new Sprite(textureSheet, 16*1, 0, 16, 16);
        sprite3 = new Sprite(textureSheet, 16*2, 0, 16, 16);
        sprite4 = new Sprite(textureSheet, 16*3, 0, 16, 16);
        sprite5 = new Sprite(textureSheet, 16*4, 0, 16, 16);

        screenSizeWidth = 1920;
        screenSizeHeight = 1080;
        world = new int[1920][1080];


    }
}
