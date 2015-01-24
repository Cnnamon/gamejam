package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by god on 14.12.31.
 */
public class Assets {

    public static final int timeMapSwap = 60;

    public static Texture textureBack;
    public static Sprite spriteBack;
    public static Texture textureSheet;
    public static Texture playerSprite;
    public static Texture enemySprite;
    public static Texture reversedEnemySprite;

    public static Sprite allySprite;
    public static Sprite wallSprite;
    public static Sprite edgeSprite;
    public static Sprite sunSprite;
    public static Sprite darkEdgeSprite;
    public static Texture badLogic;
    public static int[][] world;

    public static Sprite fireWall;
    public static Sprite fireWallCorner;
    public static Sprite earthWall;
    public static Sprite earthWallCorner;
    public static Sprite iceWall;
    public static Sprite iceWallCorner;
    public static Sprite spaceWall;
    public static Sprite spaceWallCorner;

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

        playerSprite = new Texture(Gdx.files.internal("hero.png"));
        playerSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        enemySprite = new Texture(Gdx.files.internal("snail.png"));
        enemySprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        allySprite = new Sprite(textureSheet, 16*1, 0, 16, 16);
        wallSprite = new Sprite(textureSheet, 16*2, 0, 16, 16);
        edgeSprite = new Sprite(textureSheet, 16*3, 0, 16, 16);

        sunSprite = new Sprite(textureSheet, 16*5, 0, 16, 16);
        darkEdgeSprite = new Sprite(textureSheet, 16*6, 0, 16, 16);

        fireWall = new Sprite(textureSheet, 16*0, 16, 16, 16);
        fireWallCorner = new Sprite(textureSheet, 16*1, 16, 16, 16);
        earthWall = new Sprite(textureSheet, 16*2, 16, 16, 16);
        earthWallCorner = new Sprite(textureSheet, 16*3, 16, 16, 16);
        iceWall = new Sprite(textureSheet, 16*4, 16, 16, 16);
        iceWallCorner = new Sprite(textureSheet, 16*5, 16, 16, 16);
        spaceWall = new Sprite(textureSheet, 16*6, 16, 16, 16);
        spaceWallCorner = new Sprite(textureSheet, 16*7, 16, 16, 16);




        screenSizeWidth = 1920;
        screenSizeHeight = 1080;
        world = new int[1920][1080];


    }
}
