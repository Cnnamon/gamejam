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
    public static Texture iceBackground;
    public static Texture earthBackground;
    public static Texture lavaBackground;
    public static Texture spaceBackground;


    public static Sprite spriteBack;
    public static Texture textureSheet;
    public static Texture playerSprite;
    public static Texture snailSprite;
    public static Texture kickerSprite;
    public static Texture reversedEnemySprite;

    public static Texture batSprite;
    public static Texture heart;


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
    public static Texture playerSheet;


    public static int gameMapHeight;
    public static int gameMapWidth;
    public static int screenSizeWidth;
    public static int screenSizeHeight;


    public static TextureRegion[] kickerWalkSprites;
    public static TextureRegion[] kickerKickSprites;
    public static TextureRegion[] kickerFlipSprites;

    public static TextureRegion[] kickerWalkSpritesReverse;
    public static TextureRegion[] kickerKickSpritesReverse;
    public static TextureRegion[] kickerFlipSpritesReverse;

    public static TextureRegion[] playerWalkSprites;

    public static Animation kickerWalkAnimation;
    public static Animation kickerKickAnimation;
    public static Animation kickerFlipAnimation;

    public static Animation kickerWalkAnimationReverse;
    public static Animation kickerKickAnimationReverse;
    public static Animation kickerFlipAnimationReverse;



    public static Animation playerWalkAnimation;


    public static void load(){

        iceBackground = new Texture(Gdx.files.internal("Background/IceBG.png"));
        iceBackground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        earthBackground = new Texture(Gdx.files.internal("Background/EarthBG.png"));
        earthBackground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        lavaBackground = new Texture(Gdx.files.internal("Background/LavaBG.png"));
        lavaBackground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        spaceBackground = new Texture(Gdx.files.internal("Background/SpaceBG.png"));
        spaceBackground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        heart = new Texture(Gdx.files.internal("heart.png"));
        heart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        batSprite = new Texture(Gdx.files.internal("bat_sheet.png"));
        batSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        textureSheet = new Texture(Gdx.files.internal("Test sheet.png"));


        playerSprite = new Texture(Gdx.files.internal("Player/hero1.png"));
        playerSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        snailSprite = new Texture(Gdx.files.internal("snail.png"));
        snailSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        kickerSprite = new Texture(Gdx.files.internal("Kicker1.png"));
        kickerSprite.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

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
        playerSheet = new Texture(Gdx.files.internal("Player/heroSheet.png"));

        kickerWalkSprites = new TextureRegion[2];
        kickerKickSprites = new TextureRegion[2];
        kickerFlipSprites = new TextureRegion[4];

        kickerWalkSpritesReverse = new TextureRegion[2];
        kickerKickSpritesReverse = new TextureRegion[2];
        kickerFlipSpritesReverse = new TextureRegion[4];

        playerWalkSprites = new TextureRegion[2];


        for(int i=0;i<2;i++) kickerWalkSprites[i] = new TextureRegion(kickerSheet, 48*i, 0, 48, 48);
        for(int i=0;i<2;i++) kickerKickSprites[i] = new TextureRegion(kickerSheet, 48*i, 96, 48, 48);
        for(int i=0;i<4;i++) kickerFlipSprites[i] = new TextureRegion(kickerSheet, 48*i, 48, 48, 48);

        for(int i=2;i<4;i++) kickerWalkSpritesReverse[i-2] = new TextureRegion(kickerSheet, 48*i, 0, 48, 48);
        for(int i=2;i<4;i++) kickerKickSpritesReverse[i-2] = new TextureRegion(kickerSheet, 48*i, 96, 48, 48);
        for(int i=4;i<8;i++) kickerFlipSpritesReverse[i-4] = new TextureRegion(kickerSheet, 48*i, 48, 48, 48);

        for(int i=0;i<2;i++) playerWalkSprites[i] = new TextureRegion(playerSheet, 48*i, 0, 48, 48);

        kickerWalkAnimation = new Animation(0.3f, kickerWalkSprites);
        kickerKickAnimation = new Animation(0.025f, kickerKickSprites);
        kickerFlipAnimation = new Animation(0.025f, kickerFlipSprites);

        kickerWalkAnimationReverse = new Animation(0.3f, kickerWalkSpritesReverse);
        kickerKickAnimationReverse = new Animation(0.025f, kickerKickSpritesReverse);
        kickerFlipAnimationReverse = new Animation(0.025f, kickerFlipSpritesReverse);

        playerWalkAnimation = new Animation(0.3f, playerWalkSprites);



        screenSizeWidth = 1280;
        screenSizeHeight = 720;

        gameMapHeight = 4000;
        gameMapWidth = 6400;


    }
}
