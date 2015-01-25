package epic.platformer.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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

    public static Texture batSprite;
    public static Texture heart;

    public static Sprite allySprite;
    public static Sprite wallSprite;
    public static Sprite edgeSprite;
    public static Sprite sunSprite;
    public static Sprite darkEdgeSprite;
    public static Texture badLogic;
    public static int[][] world;

    public static Sprite fireWall;
    public static Sprite fireWallCorner;
    public static Sprite fireWallRightCorner;
    public static Sprite earthWall;
    public static Sprite earthWallCorner;
    public static Sprite earthWallRightCorner;
    public static Sprite iceWall;
    public static Sprite iceWallCorner;
    public static Sprite iceWallRightCorner;
    public static Sprite spaceWall;
    public static Sprite spaceWallCorner;

    public static Texture kickerSheet;

    public static int screenSizeWidth;
    public static int screenSizeHeight;

    public static TextureRegion[] kickerWalkSprites;
    public static TextureRegion[] kickerKickSprites;
    public static TextureRegion[] kickerFlipSprites;

    public static Animation kickerWalkAnimation;
    public static Animation kickerKickAnimation;
    public static Animation kickerFlipAnimation;


    public static void load(){

        textureBack = new Texture(Gdx.files.internal("Background.png"));
        textureBack.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        heart = new Texture(Gdx.files.internal("heart.png"));
        heart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        batSprite = new Texture(Gdx.files.internal("bat_sheet.png"));
        batSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

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

        fireWall = new Sprite(textureSheet, 32*0, 32*0, 32, 32);
        fireWallCorner = new Sprite(textureSheet, 32*0, 32*1, 32, 32);
        fireWallRightCorner = new Sprite(textureSheet, 32*0, 32*2, 32, 32);
        spaceWall = new Sprite(textureSheet, 32*1, 32*0, 32, 32);
        spaceWallCorner = new Sprite(textureSheet, 32*1, 32*0, 32, 32);
        earthWall = new Sprite(textureSheet, 32*2, 32*0, 32, 32);
        earthWallCorner = new Sprite(textureSheet, 32*2, 32*1, 32, 32);
        earthWallRightCorner = new Sprite(textureSheet, 32*2, 32*2, 32, 32);
        iceWall = new Sprite(textureSheet, 32*3, 32*0, 32, 32);
        iceWallCorner = new Sprite(textureSheet, 32*3, 32*1, 32, 32);
        iceWallRightCorner = new Sprite(textureSheet, 32*3, 32*2, 32, 32);


        kickerSheet = new Texture(Gdx.files.internal("Kicker/KickerSheet.png"));
        kickerWalkSprites = new TextureRegion[2];
        kickerKickSprites = new TextureRegion[2];
        kickerFlipSprites = new TextureRegion[4];


        for(int i=0;i<2;i++) kickerWalkSprites[i] = new TextureRegion(kickerSheet, 48*i, 0, 48, 48);
        for(int i=0;i<2;i++) kickerKickSprites[i] = new TextureRegion(kickerSheet, 48*i, 96, 48, 48);
        for(int i=0;i<2;i++) kickerFlipSprites[i] = new TextureRegion(kickerSheet, 48*i, 48, 48, 48);

        kickerWalkAnimation = new Animation(0.025f, kickerWalkSprites);
        kickerKickAnimation = new Animation(0.025f, kickerKickSprites);
        kickerFlipAnimation = new Animation(0.025f, kickerFlipSprites);



        screenSizeWidth = 1280;
        screenSizeHeight = 720;


    }
}
