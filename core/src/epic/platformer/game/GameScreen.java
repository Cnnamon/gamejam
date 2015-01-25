package epic.platformer.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Timer;

import java.text.DecimalFormat;
import java.util.Random;

import static epic.platformer.game.Assets.timeMapSwap;
import static epic.platformer.game.Assets.world;
import static epic.platformer.game.Engine.player;


/**
 * Created by god on 14.12.31.
 * The class that shall be handling drawing and shit
 */

// prefs.putInteger("score", 99);

public class GameScreen implements Screen {

    Random random;

    Platformer game;
    OrthographicCamera camera;
    Engine engine;
    public Rumble  rumble;



    float scoreConstant = 1f; // zie more, zie better
    float score = 0f; // zie more, zie better
    float timeConstant = 1f; // zie less, zie fastah
    static int timeLeft=20;
    int timeScale=5;

    Label timeText;
    Label scoreText;

    boolean ended;
// neduoda pushint sry

    public GameScreen(Platformer game){
        Map.generate();
        random = new Random();
        World.changeWorld(random.nextInt(4)+1);
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
        game.batch = new SpriteBatch();
        engine = new Engine(game);
        ended = true;
        //Gdx.graphics.setContinuousRendering(false);

        //World.addRect(new CollisionObject(0, 0, Assets.screenSizeWidth, Assets.playerSprite.getHeight(), 1));

        Sounds.playGameMusic();
    }

    public static int getTimeLeft(){
        return timeLeft;
    }

    @Override
    public void show() {

        this.rumble = new Rumble();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                timeLeft--;
                if(timeLeft <= 9) {
                    if((timeLeft%2)==0) {
                        timeText.setColor(Color.WHITE);
                    } else {
                        timeText.setColor(Color.RED);
                    }

                }
                if(timeLeft <= 0) {
                    timeLeft = timeMapSwap;
                }
                score = score + 10 * scoreConstant;
            }
        }
                , 0    //    (delay)
                , timeConstant    //    (seconds)
        );

        timeText = new Label("00:00", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreText = new Label("0", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0F, 0F, 0F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        rumble.rumble(10.2f, 10.1f);
        rumble.tick(Gdx.graphics.getDeltaTime(), camera, player);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        //drawMob(engine.getPlayer());

        engine.update(delta);

        Map.updateMovingPlatforms(delta);

        game.batch.begin();
        game.batch.draw(Assets.textureBack, 0, 0);


        //game.batch.draw(engine.getPlayer().getIcon(), engine.getPlayer().getX(), engine.getPlayer().getY());

        for(CollisionObject object: World.rectList){
            World.drawRect(game.batch, object);
        }

        drawMob(engine.getPlayer());

        for(Mob m: engine.getMobList())
        drawMob(m);

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
        timeText.setPosition(Assets.screenSizeWidth-timeText.getWidth()*timeScale, Assets.screenSizeHeight-timeText.getHeight()*timeScale);
        timeText.draw(game.batch, 1f);

        scoreText.setText(new DecimalFormat("#").format(score));
        scoreText.setFontScale(timeScale, timeScale);
        scoreText.setPosition(Assets.screenSizeWidth/2-(scoreText.getWidth()*timeScale)/2, Assets.screenSizeHeight-(scoreText.getHeight()*timeScale));
        scoreText.draw(game.batch, 1f);

        game.batch.end();

        if(timeLeft >= 10) ended = false;
        if(timeLeft == 1 && !ended){
            World.changeWorld(random.nextInt(4)+1);
            World.rectList.clear();
            Map.generate();
            ended = true;

        }




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

    }

    @Override
    public void dispose() {

    }

    private void drawMob(Mob mob){
        game.batch.draw(mob.getIcon(), mob.getX(), mob.getY());
    }
}
