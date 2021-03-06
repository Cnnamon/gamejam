package epic.platformer.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;


import java.text.DecimalFormat;


import static epic.platformer.game.Assets.timeMapSwap;


/**
 * Created by god on 14.12.31.
 * The class that shall be handling drawing and shit
 */

// prefs.putInteger("score", 99);

public class GameScreen implements Screen {


    Platformer game;
    OrthographicCamera camera;
    Engine engine;
    public Rumble  rumble;
    public boolean doSomeRumble = false;

    static public int level = 1; //----------- LEVEL
    private boolean loading;
    static public float scoreConstant; // zie more, zie better

    static public float score; // zie more, zie better
    float timeConstant; // zie less, zie fastah
    static int timeLeft;
    int timeScale=5;
    int k = 0;

    Label timeText;
    Label scoreText;

    boolean ended;
    static Timer.Task task;

    int frames;
    long frameTime;

    public GameScreen(Platformer game){
        World.changeWorld(World.getRandomWorld());
        Map.generate();
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
        game.batch = new SpriteBatch();
        engine = new Engine(game);
        ended = true;
        frames = 0;
        frameTime = TimeUtils.nanoTime();
        //Gdx.graphics.setContinuousRendering(false);

        //World.addRect(new CollisionObject(0, 0, Assets.screenSizeWidth, Assets.playerSprite.getHeight(), 1));

        Sounds.playGameMusic();
    }

    public static int getTimeLeft(){
        return timeLeft;
    }

    @Override
    public void show() {

        timeText = new Label("00:00", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreText = new Label("0", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        this.rumble = new Rumble();
        this.timeLeft = 20;

        this.timeText.setColor(Color.WHITE);

        scoreConstant = 1f; // zie more, zie better
        score = 0f; // zie more, zie better
        timeConstant = 0.1f; // zie less, zie fastah
        k = 0; // skaiciuos kada praeina sekunde

        task = Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                k++;
                if(k==10) {
                    timeLeft--;
                    k = 0;
                }
                if(timeLeft <= 9) {
                    if((timeLeft%2)==0) {
                        timeText.setColor(Color.WHITE);
                    } else {
                        timeText.setColor(Color.RED);
                    }

                }
                if(timeLeft <= 0) {
                    level++;
//                    Gdx.app.log("Level:", ""+level);
                    timeLeft = timeMapSwap;
                    doSomeRumble = true;
                }
                score = (float)((score + 1 + ((level * 0.1))));
            }
        }
                , 0    //    (delay)
                , timeConstant    //    (seconds)
        );

    }

    @Override
    public void render(float delta) {
//        if(doSomeRumble) {
//            rumble.rumble(10.2f, 10.1f);
//            rumble.tick(Gdx.graphics.getDeltaTime(), camera, player);
//        }

//        if(loading){
//            //start the loading screen animation
//
//            //if the animation is done, launch the thread to load the new world
//
//            //wait for it to complete
//        }
//         if(!loading){ //maybe check for animation stages instead of loading?
//             //move the world shift code here
//
//             //start the load screen animation change
//         }
//
//
//        if(timeLeft <= 5){
//            //draw
//        }
        frames++;
        if(TimeUtils.nanoTime() - frameTime >= 1e+9){
            System.out.println(frames);
            frames = 0;
            frameTime = TimeUtils.nanoTime();
        }



        if( ended && timeLeft >= 10) ended = false;
        if(!ended && timeLeft == 1 ){
            //launch a new thread that disposes of what is no longer necessary and generate all the new objects

            World.changeWorld(World.getRandomWorld());
            World.rectList.clear();
            Engine.getMobList().clear();
            Map.generate();
            ended = true;
        }



        Gdx.gl.glClearColor(0F, 0F, 0F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //time control
        if(((timeLeft/60 <= 9) && (timeLeft%60 > 9)) || (((timeLeft/60 > 9) && (timeLeft%60 <= 9)))) {
            if(timeLeft/60 <= 9) {
                timeText.setText("0"+(timeLeft/60)+":"+(timeLeft%60));
            }
            if(timeLeft%60 <= 9) {
                timeText.setText((timeLeft/60)+":0"+(timeLeft%60));
            }
        }
        if(timeLeft/60 > 9 && timeLeft%60 > 9) {
            timeText.setText((timeLeft/60)+":"+(timeLeft%60));
        }
        if(timeLeft/60 <= 9 && timeLeft%60 <= 9) {
            timeText.setText("0"+(timeLeft/60)+":0"+(timeLeft%60));
        }

        timeText.setFontScale(timeScale, timeScale);
        timeText.setPosition(Assets.screenSizeWidth-timeText.getWidth()*timeScale-10, Assets.screenSizeHeight-timeText.getHeight()*timeScale);


        scoreText.setText(new DecimalFormat("#").format(score));
        scoreText.setFontScale(timeScale, timeScale);
        scoreText.setPosition((Assets.screenSizeWidth/2)-(scoreText.getWidth()/2*timeScale), Assets.screenSizeHeight-(scoreText.getHeight()*timeScale));
        //time control ends

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        engine.update(delta);

        Map.updateMovingPlatforms(delta);

        game.batch.begin();

        //game.batch.draw(Assets.textureBack, 0, 0);

        game.batch.draw(World.background, 0, 0);


        for(CollisionObject object: World.rectList){
            World.drawRect(game.batch, object);
        }

        engine.getPlayer().drawPlayer(game.batch);
        for(Mob m: engine.getMobList())
        drawMob(m);

        timeText.draw(game.batch, 1f);
        scoreText.draw(game.batch, 1f);

        for(int i = 0; i < Engine.player.HP; i++)
        {
            game.batch.draw(Assets.heart, 5 + Assets.heart.getWidth() * i, Assets.screenSizeHeight - 5 - Assets.heart.getHeight());
        }

//        game.font.draw(game.batch, "00:00", 500, 500);

        game.batch.end();


    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        World.rectList.clear();
        task.cancel();
    }

    @Override
    public void dispose() {

    }

    private void drawMob(Mob mob){
        if(mob instanceof Bat)
        {
            Bat temp = (Bat) mob;
            temp.elapsedTime += Gdx.graphics.getDeltaTime();
            game.batch.draw(temp.anim.getKeyFrame(temp.elapsedTime, true), temp.getX(), temp.getY());
        }
        else if (mob instanceof Kicker){
            game.batch.draw(((Kicker) mob).currentFrame, mob.getX(), mob.getY());
        }
        else
        {
            game.batch.draw(mob.getIcon(), mob.getX(), mob.getY());
        }
    }
}
