package epic.platformer.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    CollisionObject object;



    public GameScreen(Platformer game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Assets.screenSizeWidth, Assets.screenSizeHeight);
        game.batch = new SpriteBatch();
        engine = new Engine(game);
        //Gdx.graphics.setContinuousRendering(false);
        object = new CollisionObject(160, 320, 600, 32);


    }

    @Override
    public void show() {


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
        Rects.drawRect(game.batch, object);


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
