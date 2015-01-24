package epic.platformer.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Timer;

import java.text.DecimalFormat;
import java.util.Random;


/**
 * Created by god on 14.12.31.
 * The class that shall be handling drawing and shit
 * TODO: Make 64x64 sprites
 * todo: Write a code that generates terrain (it needs to generate a path the unit could walk on)
 * todo: AI for the troops/offensive units (path finding, in general)
 * todo: Collision detection
 * todo: Figure out what genre/style/system I want to work with next
 */
public class GameScreen implements Screen {

    Platformer game;
    OrthographicCamera camera;
    Engine engine;



    float scoreConstant = 1f; // zie more, zie better
    float score = 0f; // zie more, zie better
    float timeConstant = 1f; // zie less, zie fastah
    int timeLeft=160;
    int timeScale=5;

    Label timeText;
    Label scoreText;


    public GameScreen(Platformer game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
        game.batch = new SpriteBatch();
        engine = new Engine(game);
        //Gdx.graphics.setContinuousRendering(false);
        Map.generate();
        Rects.addRect(new CollisionObject(0, 0, Assets.screenSizeWidth, Assets.sprite1.getHeight(), 1));
//

    }

    @Override
    public void show() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                timeLeft--;
                score = score + 1*scoreConstant;
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

        camera.update();


        game.batch.setProjectionMatrix(camera.combined);
        //drawMob(engine.getPlayer());

        engine.update(delta);

        game.batch.begin();
        game.batch.draw(Assets.textureBack, 0, 0);
//        for (int i=0;i<Assets.screenSizeHeight;i+=16){
//            for(int j=0;j<Assets.screenSizeWidth;j+=16){
//                switch (random.nextInt(5)){
//                    case 0:
//                        batch.draw(Assets.sprite1, i, j);
//                        break;
//                    case 1:
//                        batch.draw(Assets.sprite2, i, j);
//                        break;
//                    case 2:
//                        batch.draw(Assets.sprite3, i, j);
//                        break;
//                    case 3:
//                        batch.draw(Assets.sprite4, i, j);
//                        break;
//                    case 4:
//                        batch.draw(Assets.sprite5, i, j);
//                        break;
//                }
//            }
//        }
        for (int i=0;i<Assets.screenSizeHeight;i+=16) {
            for (int j = 0; j < Assets.screenSizeWidth; j += 16) {
                if(Assets.world[j][i] == 1){
                    game.batch.draw(Assets.sprite3, j, i);
                }
            }
        }

        //game.batch.draw(engine.getPlayer().getIcon(), engine.getPlayer().getX(), engine.getPlayer().getY());
        drawMob(engine.getPlayer());
        for(CollisionObject object: Rects.rectList){
            Rects.drawRect(game.batch, object);
        }

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
        timeText.draw(game.batch, 0.5f);

        scoreText.setText(new DecimalFormat("#").format(score));
        scoreText.setFontScale(timeScale, timeScale);
        scoreText.setPosition(Assets.screenSizeWidth/2-(scoreText.getWidth()*timeScale)/2, Assets.screenSizeHeight-(scoreText.getHeight()*timeScale));
        scoreText.draw(game.batch, 1f);

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

    }

    @Override
    public void dispose() {

    }

    private void drawMob(Mob mob){
        game.batch.draw(mob.getIcon(), mob.getX(), mob.getY());
    }
}
